package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CSSDemo extends Application {

	private Label headerLabel, bodyLabel;
	private Button darkCSSButton, defaultCSSButton;

	private Stage primaryStage;

	// CSS Datei einlesen
	private String darkTheme = getClass().getResource("darkTheme.css").toExternalForm();

	// Alternativ ginge auch
	// "http://swt.hs-mannheim.de/layouts/layout5/layout.css" o.ä.

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("CSS Demo");

		this.primaryStage = primaryStage;

		headerLabel = new Label("Dieses Beispiel zeigt den Umgang mit CSS");
		headerLabel.getStyleClass().add("header");	// Diesem Label eine spezielle CSS Klasse zuweisen
		
		bodyLabel = new Label("Lorem ipsum dolor sit amet,\n"	// Standard Blindtext, ohne Sinn...
				+ "consetetur sadipscing elitr,\n"
				+ "sed diam nonumy eirmod tempor invidunt\n"
				+ "ut labore et dolore magna aliquyam erat,\n"
				+ "sed diam voluptua.");

		darkCSSButton = new Button("Dunkles CSS aktivieren");
		darkCSSButton.setOnAction(new DarkCSSButtonEventHandler());
		
		defaultCSSButton = new Button("Standard CSS aktivieren");
		defaultCSSButton.setOnAction(new DefaultCSSButtonEventHandler());

		FlowPane buttonPane = new FlowPane();
		buttonPane.setHgap(5);				// Abstand zwischen Elementen setzen
		buttonPane.getChildren().add(darkCSSButton);
		buttonPane.getChildren().add(defaultCSSButton);
		
		BorderPane contentPane = new BorderPane();
		contentPane.setCenter(bodyLabel);
		contentPane.setBottom(buttonPane);
		contentPane.setTop(headerLabel);

		primaryStage.setScene(new Scene(contentPane, 400, 400));
		primaryStage.show();
	}

	/**
	 * Umschalten auf dunkles Theme 
	 */
	class DarkCSSButtonEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ev) {
			// "Spezial CSS" hinzufügen, überschreibt damit Werte aus Standard CSS
			if(!primaryStage.getScene().getStylesheets().contains(darkTheme))
				primaryStage.getScene().getStylesheets().add(darkTheme);
		}
	}
	
	/**
	 * Umschalten auf Standard Theme 
	 */
	class DefaultCSSButtonEventHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent ev) {
			// Für Standard CSS werden die Attribute vom "Spezial CSS" wieder entfernt
			primaryStage.getScene().getStylesheets().remove(darkTheme);
		}
	}
}
