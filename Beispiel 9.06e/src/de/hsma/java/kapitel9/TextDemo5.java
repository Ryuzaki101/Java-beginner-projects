package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TextDemo5 extends Application {
	private TextArea textArea;
	private TextField textField;
	private Label labelPrefixField, labelField;
	private Button clearButton;
	
	private FontWeight bold = FontWeight.NORMAL;
	private FontPosture italic = FontPosture.REGULAR;
	
	private final String lextLenghtPrefix = "Textl�nge: ";
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Text Demo (Version 5)");
	        
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
	        
			ToggleGroup group = new ToggleGroup(); 
			RadioButton blackButton = new RadioButton("_schwarz");
			blackButton.setSelected(true);
			blackButton.setToggleGroup(group);
			blackButton.setUserData("schwarz");

			RadioButton redButton = new RadioButton("_rot");
			redButton.setToggleGroup(group);
			redButton.setUserData("rot");

			RadioButton blueButton = new RadioButton("_blau");
			blueButton.setToggleGroup(group);
			blueButton.setUserData("blau");
			
			ColorListener colorListener = new ColorListener();
			blackButton.setOnAction(colorListener);
			redButton.setOnAction(colorListener);
			blueButton.setOnAction(colorListener);
			
			// Erstelle die CheckBboxes
			CheckBox boldButton = new CheckBox("_fett");
			boldButton.setSelected(false);
			
			// Innere Klasse kann auch auf diese Weise erstellt werden:
			boldButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
		        public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
		        	
		        	// bold Flag abh�ngig von neuem Wert der CheckBox setzen 
		        	if(new_val){
		        		bold = FontWeight.BOLD;
		        	}else{
		        		bold = FontWeight.NORMAL;
		        	}
		        	
		        	// Neue Schrift auf Basis aktueller Schrift setzen
		        	Font oldFont = textArea.getFont();
		        	textArea.setFont(Font.font(oldFont.getName(), bold, italic, oldFont.getSize()));
		        }});

			CheckBox italicButton = new CheckBox("_kursiv");
			italicButton.setSelected(false);
			
			italicButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
		        public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
		        	
		        	// italic Flag abh�ngig von neuem Wert der CheckBox setzen 
		        	if(new_val){
		        		italic = FontPosture.ITALIC;
		        	}else{
		        		italic = FontPosture.REGULAR;
		        	}
		        	
		        	// Neue Schrift auf Basis aktueller Schrift setzen
		        	Font oldFont = textArea.getFont();
		        	textArea.setFont(Font.font(oldFont.getName(), bold, italic, oldFont.getSize()));
		        }});
			
			// CheckBoxes in eine Spalte einf�gen
			GridPane checkPanel = new GridPane();
			checkPanel.add(boldButton, 1, 0);
			checkPanel.add(italicButton, 1, 1);
			
			// Radio Buttons mit Titel anzeigen und "schliessbar"
			TitledPane titledCheckPane = new TitledPane("Schriftstil", checkPanel);
			
			GridPane radioPanel = new GridPane();
			radioPanel.add(blackButton, 1, 0);
			radioPanel.add(redButton, 1, 1);
			radioPanel.add(blueButton, 1, 2);
			
			TitledPane titledRadioPane = new TitledPane("Farbe", radioPanel);
			
			// Erstelle ButtonPanel 
			GridPane buttonPanel = new GridPane();
			buttonPanel.add(titledRadioPane, 1, 0);
			buttonPanel.add(titledCheckPane, 1, 1);
			
			BorderPane controlPanel = new BorderPane();
			controlPanel.setBottom(clearButton);
			controlPanel.setCenter(buttonPanel);
			
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

				sourceButton.setSelected(true);
			}
		}
	}
	
	/** Wenn der Clear Button geklickt wird soll aller Inhalt aus der TextArea gel�scht werden */
	class ClearButtonEventHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent ev) {
			
			if(clearButton == ev.getSource()){
				textArea.setText("");
			}
		}
	}
	
	/** 
	 * Wenn der Text in der Textarea leer ist soll der Clear Button disabled werden, ansonsten enabled.
	 */
	class TextAreaButtonListener implements ChangeListener<String> {
        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
           if(newValue.length() == 0){
        	   clearButton.setDisable(true);
           }else{
        	   clearButton.setDisable(false);   
           }
         }
	}
	
	/** Reagiert auf ein <CR> im textField */
	class TextFieldEventHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent ev) {
			
			if(textField == ev.getSource()){
				
				textArea.appendText(textField.getText() + "\n");
				textField.selectAll();
			}
		}
	}
}
