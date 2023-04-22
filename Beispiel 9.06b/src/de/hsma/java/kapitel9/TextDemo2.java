package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextDemo2 extends Application {
	private TextArea textArea;
	private TextField textField;
	private Label labelPrefixField, labelField;
	
	private final String lextLenghtPrefix = "Textlänge: ";
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Text Demo (Version 2)");
	        
	        textArea = new TextArea("");
	        textArea.setPrefRowCount(15);
	        textArea.setPrefColumnCount(30);
	        
	        textField = new TextField();
	        textField.setOnAction(new TextFieldEventHandler());
	        
	        labelPrefixField = new Label(lextLenghtPrefix);
	        labelField = new Label("0");
	        
	        // Wenn der Text in der Textarea verändert wird, soll sich das LabelField mit der Zeichenzahl anpassen.
	        labelField.textProperty().bind(textArea.lengthProperty().asString());
	        
	        GridPane topPane = new GridPane();
	        topPane.addColumn(0, labelPrefixField);
	        topPane.addColumn(1, labelField);
	        
	        BorderPane contentPane = new BorderPane();
	        
	        contentPane.setCenter(textArea);
	        contentPane.setBottom(textField);
	        contentPane.setTop(topPane);
	        
	        primaryStage.setScene(new Scene(contentPane));
	        primaryStage.show();
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
