package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/** Demonstriert die Flow-Layout Strategie */
public class FlowLayoutDemo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Flow Layout Demo");
	        
	        FlowPane contentPane = new FlowPane();
	        contentPane.setVgap(8);	// Abstände zwischen Elementen setzen
	        contentPane.setHgap(4);
	        contentPane.getChildren().add(new Button("Button 1"));
	        contentPane.getChildren().add(new Button("Button 2"));
	        contentPane.getChildren().add(new Button("Button 3"));
	        
	        primaryStage.setScene(new Scene(contentPane, 150, 150));
	        primaryStage.show();
	}
}
