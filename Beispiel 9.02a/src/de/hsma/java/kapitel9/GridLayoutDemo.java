package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Demonstriert die Grid-Layout Strategie */
public class GridLayoutDemo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Grid Layout Demo");
	        
	        GridPane contentPane = new GridPane();
	        
			for (int i=1; i<=3; i++)
				for (int j = 0; j <=3; j++) {
					contentPane.add(new Button("Matrix-Button"), j, i);	// Spalte=j, Reihe=i
				}
				
	        primaryStage.setScene(new Scene(contentPane));
	        primaryStage.show();
	}
}
