package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextDemo4 extends Application {
	private TextArea textArea;
	private TextField textField;
	private Label labelPrefixField, labelField;
	private Button clearButton;

	private final String lextLenghtPrefix = "Textl�nge: ";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Text Demo (Version 4)");

		textArea = new TextArea("");
		textArea.setPrefRowCount(15);
		textArea.setPrefColumnCount(30);

		textField = new TextField();
		textField.setOnAction(new TextFieldEventHandler());

		labelPrefixField = new Label(lextLenghtPrefix);
        labelField = new Label("0");
        labelField.textProperty().bind(textArea.lengthProperty().asString());

		clearButton = new Button("_L�schen");
		clearButton.setDisable(true); 
		textArea.textProperty().addListener(new TextAreaButtonListener()); 
		clearButton.setOnAction(new ClearButtonEventHandler()); 

		// Erstelle die RadioButtons
		ToggleGroup group = new ToggleGroup(); 	// Gruppiere die RadioButtons, damit immer nur einer ausgew�hlt werden kann
		RadioButton blackButton = new RadioButton("_schwarz");
		blackButton.setSelected(true); 			// Schwarzer Button ist vorausgew�hlt
		blackButton.setToggleGroup(group);
		blackButton.setUserData("schwarz"); 	// Hiermit l�sst sich eine Information an den Button h�ngen, z.B. f�r EventHandler

		RadioButton redButton = new RadioButton("_rot");
		redButton.setToggleGroup(group);
		redButton.setUserData("rot");

		RadioButton blueButton = new RadioButton("_blau");
		blueButton.setToggleGroup(group);
		blueButton.setUserData("blau");

		// Registriere Listener f�r RadioButtons
		ColorListener colorListener = new ColorListener();
		blackButton.setOnAction(colorListener);
		redButton.setOnAction(colorListener);
		blueButton.setOnAction(colorListener);

		// RadioButtons in eine Spalte einf�gen
		GridPane radioPanel = new GridPane();
		radioPanel.add(blackButton, 1, 0);
		radioPanel.add(redButton, 1, 1);
		radioPanel.add(blueButton, 1, 2);

		// Radio Buttons mit Titel anzeigen und "schliessbar"
		TitledPane titledRadioPane = new TitledPane("Farbe", radioPanel);

		BorderPane controlPanel = new BorderPane();
		controlPanel.setBottom(clearButton);
		controlPanel.setCenter(titledRadioPane);

		GridPane topPane = new GridPane();
	    topPane.addColumn(0, labelPrefixField);
	    topPane.addColumn(1, labelField);
		
		BorderPane contentPane = new BorderPane();
		contentPane.setCenter(textArea);
		contentPane.setBottom(textField);
		contentPane.setTop(topPane);
		contentPane.setRight(controlPanel);

		primaryStage.setScene(new Scene(contentPane));
		primaryStage.show();
	}

	class ColorListener implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ev) {

			Object source = ev.getSource();

			if (source instanceof RadioButton) {
				RadioButton sourceButton = (RadioButton) source;

				// Vorsicht: Damit werden alle andere Styles �berschrieben!
				switch (sourceButton.getUserData().toString()) {
				case "schwarz":
					textArea.setStyle("-fx-text-fill: #000000;");
					break;
				case "blau":
					textArea.setStyle("-fx-text-fill: #000080;");
					break;
				case "rot":
					textArea.setStyle("-fx-text-fill: #FF0000;");
					break;
				}

				sourceButton.setSelected(true); // Workaround f�r Alt-? Bedienung
			}
		}
	}

	/**
	 * Wenn der Clear Button geklickt wird soll aller Inhalt aus der TextArea gel�scht werden
	 */
	class ClearButtonEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ev) {

			if (clearButton == ev.getSource()) {
				textArea.setText("");
			}
		}
	}

	/**
	 * Wenn der Text in der Textarea leer ist soll der Clear Button disabled werden, ansonsten enabled.
	 */
	class TextAreaButtonListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observableValue,
				String oldValue, String newValue) {
			if (newValue.length() == 0) {
				clearButton.setDisable(true);
			} else {
				clearButton.setDisable(false);
			}
		}
	}

	/** Reagiert auf ein <CR> im textField */
	class TextFieldEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ev) {

			if (textField == ev.getSource()) {

				textArea.appendText(textField.getText() + "\n");
				textField.selectAll();
			}
		}
	}
}
