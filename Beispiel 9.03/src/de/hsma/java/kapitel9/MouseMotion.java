package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Ein "mouse motion observer" */
public class MouseMotion extends Application {
	private BlankArea blankArea;
	private Label posLabel;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Mouse Motion Observer");

		posLabel = new Label("Bitte Maus bewegen");

		blankArea = new BlankArea(300, 200, Color.CORNSILK);	// Eigenen Node für Zeichenfläche anlegen

		MouseEventHandler meh = new MouseEventHandler();
		blankArea.setOnMouseMoved(meh);		// Listener für Mausbewegungen
		blankArea.setOnMouseDragged(meh);	// Listener für Mausbewegungen mit gedrückter Maustaste

		BorderPane contentPane = new BorderPane();
		contentPane.setCenter(blankArea);
		contentPane.setBottom(posLabel);
		BorderPane.setAlignment(posLabel, Pos.BOTTOM_RIGHT);	// Label rechtsbündig ausrichten

		primaryStage.setScene(new Scene(contentPane));
		primaryStage.show();
	}

	// Innere Klasse zum Behandeln der Mouse Events der BlankArea
	class MouseEventHandler implements EventHandler<MouseEvent> {

		public void handle(MouseEvent e) {
			posLabel.setText("(" + e.getX() + ", " + e.getY() + ")");
		}
	}
}
