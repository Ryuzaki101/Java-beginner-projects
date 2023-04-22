package de.hsma.java.kapitel9;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PfadAnimation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Beispielanimation");
        
        // zu animierende Figur
        Polygon polygon = new Polygon();
        polygon.getPoints().setAll(0.0,0.0, 20.0,10.0, 0.0,20.0); 
        polygon.setFill(Color.BLUE);
        polygon.setVisible(false);	// Figur wird erst durch Animation sichtbar
        
        // Pfad, entlang dessen sich die Figur bewegen soll		
        Path path = new Path();
        path.getElements().add(new MoveTo(20,40));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        		
        // Animation entlang eines Pfades
        PathTransition pathTransition = new PathTransition();
        // Ein Durchlauf dauert vier Sekunden
        pathTransition.setDuration(Duration.millis(4000));
        // Pfad, entlang dessen bewegt werden soll
        pathTransition.setPath(path);
        // Knoten, der bewegt werden soll
        pathTransition.setNode(polygon);
        // Die Figur soll sich mit dem Pfad mitdrehen
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        // Animation soll unendlich laufen
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        // Nach jedem Durchlauf soll die Animation in der gleichen Reihenfolge erneut beginnen
        pathTransition.setAutoReverse(false);

        // Panel zur Anzeige der Animation
        Pane animationPane = new Pane();
        
        // Optik des Pfades anpassen und diesen anzeigen (nicht erforderlich für die Animation)
        path.setStroke(Color.SILVER);					// Farbe des Pfades
        path.getStrokeDashArray().addAll(10.0, 10.0);	// Pfad als gestrichelte Linie darstellen
        animationPane.getChildren().add(path);
        
        animationPane.getChildren().add(polygon);	// Animierte Figur anzeigen
        
        Button startButton = new Button("Starten");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
            	polygon.setVisible(true);		// Figur anzeigen
            	pathTransition.playFromStart();	// Animation starten
            	startButton.setText("Neustart");// Buttontext ändern
            }
        });
        
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                if (pathTransition.getStatus().equals(Animation.Status.PAUSED)) {
                	pathTransition.play();
                	pauseButton.setText("Pause");
                }else if (pathTransition.getStatus().equals(Animation.Status.RUNNING)) { 
                	pathTransition.pause();
                	pauseButton.setText("Weiter");
                }
            }
        });
        
        ToolBar toolbar = new ToolBar(startButton, pauseButton);
        
        BorderPane contentPane =  new BorderPane();
        contentPane.setTop(toolbar);
        contentPane.setCenter(animationPane);

        primaryStage.setScene(new Scene(contentPane, 400, 300));
        primaryStage.show();
    }
}
