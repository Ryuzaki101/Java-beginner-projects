package de.hsma.java.kapitel9;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Animationen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Beispielanimation");
        
        // Rechteck erstellen das animiert werden soll
        Rectangle rectangle = new Rectangle(10, 10, 50, 50);
        rectangle.setArcHeight(20);		// Abgerundete Ecken
        rectangle.setArcWidth(20);		// Abgerundete Ecken
        rectangle.setFill(Color.RED);
        
        // Animation zur Rotation
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectangle);	// Dauer eines Animationsschrittes: 3 Sekunden , Auswahl des zu animierenden Nodes
        rotateTransition.setByAngle(180);		// Gradzahl, bis zu der die Animation läuft
        rotateTransition.setCycleCount(4);		// Animation läuft viermal nacheinander ab und endet dann
        rotateTransition.setAutoReverse(true);	// Umkehr der Richtung bei Abschluss der Animation
        
        Button rotateButton = new Button("Rotieren");
        rotateButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
            	rotateTransition.playFromStart();	// Start der Animation bei 0
            }
        });
        
        TranslateTransition moveTransition = new TranslateTransition(Duration.millis(5000), rectangle);
        moveTransition.setFromX(0);		// Startpunkt der Animation (X-Koordinate)
        moveTransition.setToX(100);		// Endpunkt der Animation (X-Koordinate)
        moveTransition.setFromY(0);		// Startpunkt der Animation (Y-Koordinate)
        moveTransition.setToY(50);		// Endpunkt der Animation (X-Koordinate)
        moveTransition.setCycleCount(4);
        moveTransition.setAutoReverse(true);

        Button translateButton = new Button("Bewegen");
        translateButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
            	moveTransition.playFromStart();
            }
        });
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectangle);
        scaleTransition.setToX(2);	// Maximale Vergrößerung der Animation
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        
        Button scaleButton = new Button("Skalieren");
        scaleButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
            	scaleTransition.playFromStart();
            }
        });

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), rectangle);
        fadeTransition.setFromValue(1.0);	// Transparenz zwischen 100% ...
        fadeTransition.setToValue(0.1);		// ... und 10% verändern
        fadeTransition.setCycleCount(Timeline.INDEFINITE);	// Animation läuft unendlich lange
        fadeTransition.setAutoReverse(true);
        
        Button fadeButton = new Button("Ausblenden");
        fadeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
            	fadeTransition.playFromStart();
            }
        });

        // Ähnlich eines Menüs
        ToolBar toolbar = new ToolBar(rotateButton, translateButton, scaleButton, fadeButton);
        
        BorderPane contentPane =  new BorderPane();
        contentPane.setTop(toolbar);
        contentPane.setCenter(rectangle);

        primaryStage.setScene(new Scene(contentPane, 400, 400));
        primaryStage.show();
    }
}
