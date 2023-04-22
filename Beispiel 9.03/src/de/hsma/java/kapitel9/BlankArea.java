package de.hsma.java.kapitel9;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/** Ein leeres Zeichenblatt */
public class BlankArea extends Pane {

	public BlankArea(double width, double height, Color color) {
		
		setStyle("-fx-border-color: black;");		// Schwarzen Rahmen um Zeichenfläche setzen (mit CSS) 
		setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));		// Hintergrund setzen ohne CSS
		setPrefSize(width, height);
	}
}