package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
 
public class PieChartSample extends Application {
 
    public void start(Stage stage) {
     
        stage.setTitle("Aktivitäten in einer Vorlesung");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Surfen", 15),
                new PieChart.Data("Spielen", 10),
                new PieChart.Data("Schlafen", 5),
                new PieChart.Data("Quatschen", 15),
                new PieChart.Data("Aufpassen",55));
        
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Aktivitäten in einer Vorlesung");
        chart.setLegendSide(Side.LEFT);

        BorderPane contentPane = new BorderPane();
        contentPane.setCenter(chart);
        
        stage.setScene(new Scene(contentPane));
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}