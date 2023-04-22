package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextDemo3 extends Application {
	private TextArea textArea;
	private TextField textField;
	private Label labelPrefixField, labelField;
	private Button clearButton;
	
	private final String lextLenghtPrefix = "Textlänge: ";
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Text Demo (Version 3)");
	        
	        textArea = new TextArea("");
	        textArea.setPrefRowCount(15);
	        textArea.setPrefColumnCount(30);
	        
	        textField = new TextField();
	        textField.setOnAction(new TextFieldEventHandler());
	        
	        labelPrefixField = new Label(lextLenghtPrefix);
	        labelField = new Label("0");
	        labelField.textProperty().bind(textArea.lengthProperty().asString());
	        
			clearButton = new Button("_Löschen");
			clearButton.setDisable(true);			// Da Textfläche zu Beginn leer, Button deaktivieren
			textArea.textProperty().addListener(new TextAreaButtonListener());	// Button enablen/disablen abhängig vom Inhalt der TextArea
			clearButton.setOnAction(new ClearButtonEventHandler());				// Text löschen wenn Button geklickt wird
	        
			BorderPane controlPanel = new BorderPane();
			controlPanel.setBottom(clearButton);
			
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
	
	/** Wenn der Clear Button geklickt wird soll aller Inhalt aus der TextArea gelöscht werden */
	class ClearButtonEventHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent ev) {
			
			// Überprüfung ob die auslösende Komponente das Textfeld ist
			if(clearButton == ev.getSource()){
				textArea.setText("");		// TextArea leeren
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
