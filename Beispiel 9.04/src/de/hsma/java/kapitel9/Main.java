package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SceneBuilder Demo");
		primaryStage.setScene(new Scene(new MainWindow()));
		
		primaryStage.show();
	}
}
