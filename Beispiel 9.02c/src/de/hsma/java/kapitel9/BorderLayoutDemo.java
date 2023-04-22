package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** Demonstriert die Border-Layout Strategie */
public class BorderLayoutDemo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Border Layout Demo");
	        
	        BorderPane contentPane = new BorderPane();
	        contentPane.setPrefSize(300,200);
	        
	        Button oben = new Button("Top");
	        oben.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);	// Größe maximieren um ganze Fläche auszunutzen
	        
	        Button mitte = new Button("Center");
	        mitte.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        
	        Button unten = new Button("Bottom");
	        unten.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        
	        Button rechts = new Button("Right");
	        rechts.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        
	        Button links = new Button("Left");
	        links.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        
	        contentPane.setTop(oben);
	        contentPane.setCenter(mitte);
	        contentPane.setBottom(unten);
	        contentPane.setRight(rechts);
	        contentPane.setLeft(links);

	        primaryStage.setScene(new Scene(contentPane));
	        primaryStage.show();
	}
}
