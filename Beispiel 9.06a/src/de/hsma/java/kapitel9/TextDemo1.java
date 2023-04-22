package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextDemo1 extends Application {
	private TextArea textArea;
	private TextField textField;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Text Demo (Version 1)");
	        
	        textArea = new TextArea("");	// leere Textfläche mit 15 Zeilen und 30 Spalten
	        textArea.setPrefRowCount(15);
	        textArea.setPrefColumnCount(30);
	        
	        textField = new TextField();
	        textField.setOnAction(new TextFieldEventHandler());
	        
	        BorderPane contentPane = new BorderPane();
	        
	        contentPane.setCenter(textArea);
	        contentPane.setBottom(textField);
	        
	        primaryStage.setScene(new Scene(contentPane));
	        primaryStage.show();
	}
	
	/** Reagiert auf ein <CR> im textField */
	class TextFieldEventHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent ev) {
			
			// Überprüfung ob die auslösende Komponente das Textfeld ist
			if(textField == ev.getSource()){
				
				//Text aus Texfeld lesen und mit Zeilenumbruch an TextArea anhängen
				textArea.appendText(textField.getText() + "\n");
				textField.selectAll();	// Alles im Texfeld markieren um ohne Zusatzklick etwas neues eintragen zu können
			}
		}
	}
}
