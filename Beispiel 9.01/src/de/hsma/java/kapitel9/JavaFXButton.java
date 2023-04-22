package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXButton extends Application {
	
	private Label label;
	private static String labelPrefix = "Anzahl der Klicks: ";
	private int numClicks = 0;
	
	// Main-Methode
	public static void main(String[] args) {
		launch(args);	// Java FX Anwendung starten
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("JavaFX Button");
		
	        label =  new Label(labelPrefix + numClicks);
	        
	        Button button = new Button("_Drücke mich!");		// _-Zeichen um Tastenkürzel zu aktivieren (Alt + Zeichen "drückt" den button)
	        button.setMnemonicParsing(true);					// Parsing auf Tastenkürzel aktivieren
	        button.setOnAction(new ButtonEventHandler());		// Action Event behandeln wenn Button angeklickt wird
	        
	        GridPane contentPane = new GridPane();
	        contentPane.setAlignment(Pos.CENTER);				// Grid Panel zentrieren
	        contentPane.addRow(0, button);
	        contentPane.addRow(1, label);
	        
	        primaryStage.setScene(new Scene(contentPane, 300, 250));	// Größe der Anwendung festlegen
	        primaryStage.show();
	}
	
	// Innere Klasse zum Behandeln der Action Events des Buttons
	class ButtonEventHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent ev) {
			numClicks++;
			label.setText(labelPrefix + numClicks);
		}
	}
}
