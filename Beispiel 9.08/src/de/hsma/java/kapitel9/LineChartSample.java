package de.hsma.java.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;

public class LineChartSample extends Application {

	public void start(Stage stage) {
		stage.setTitle("Studenten in Vorlesung");

		// Datenreihe erstellen
		Series<Number, Number> normalesSemester = new Series<Number, Number>();
		normalesSemester.setName("Normales Semester");
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(1, 40));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(2, 32));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(3, 30));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(4, 24));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(5, 22));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(6, 23));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(7, 20));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(8, 18));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(9, 21));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(10, 24));
		normalesSemester.getData().add(new XYChart.Data<Number, Number>(11, 24));
		
		// Datenreihe erstellen
		Series<Number, Number> komischesSemester = new Series<Number, Number>();
		komischesSemester.setName("Untypisches Semester");
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(1, 25));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(2, 21));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(3, 13));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(4, 9));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(5, 11));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(6, 10));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(7, 12));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(8, 15));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(9, 13));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(10, 16));
		komischesSemester.getData().add(new XYChart.Data<Number, Number>(11, 21));

		// Achsen definieren
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Vorlesung");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Anzahl Studenten");

		// Linien Diagamm erstellen
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Studenten in Vorlesung");
		lineChart.getData().add(normalesSemester);
		lineChart.getData().add(komischesSemester);
		
		BorderPane contentPane = new BorderPane();
		contentPane.setCenter(lineChart);

		stage.setScene(new Scene(contentPane));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}