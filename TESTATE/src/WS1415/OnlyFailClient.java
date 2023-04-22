package WS1415;

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OnlyFailClient extends Application {

	private Socket cliSock = null;
	private PrintWriter out;
	private ObjectInputStream ois;
	private String myChoise = " ";
	private int statistik[] = {0,0,0};
	private ObservableList<PieChart.Data> pieChartData = null;
	private PieChart chart;

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Sunni-OnlyFailClient");
		BorderPane rootPane = new BorderPane();
		BorderPane subPane = new BorderPane();
		BorderPane datePane = new BorderPane();
		Label datelbl = new Label("Zeitstempel unbekannt");
//		datelbl.setFont(new Font(12));			//Anforderung in der Aufgabe. Jedoch zu klein für mein (High-DPI) Dsplay
		Label statlbl = new Label("Bitte Server Auswählen");
		Button refbtn = new Button("Aktualisieren");
		datePane.setLeft(datelbl);
		datePane.setRight(refbtn);
		
		Menu datMen = new Menu("_Datei");
		MenuItem beend = new MenuItem("_Beenden");
		beend.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Wirklich beenden?");
				alert.setHeaderText(null);
				alert.setContentText("Wollen Sie die Anwendung wirklich beenden?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) 
					System.exit(0);
			}
		});
		datMen.getItems().add(beend);
		Menu eigMen = new Menu("_Eigenschaften");
		MenuItem ausw = new MenuItem("_Server Auswahl");
		ausw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				List<String> choices = new ArrayList<>();
				choices.add("localhost:3333");
				choices.add("141.19.69.40:3333");

				ChoiceDialog<String> dialog = new ChoiceDialog<>(myChoise, choices);
				dialog.setTitle("Server Auswahl");
				dialog.setHeaderText("Auswahl eines Servers");
				dialog.setContentText("Bitte einen Server Wählen:");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
					myChoise = result.get();
					String tmp[] = myChoise.split(":");
					try {
						cliSock = new Socket(tmp[0], Integer.parseInt(tmp[1]));
						out = new PrintWriter(cliSock.getOutputStream(),true);  // true for autoflush
						ois = new ObjectInputStream(cliSock.getInputStream());
					}
					catch (IOException e) {
						e.printStackTrace();					
					}
					statlbl.setText("Server ausgewählt - " + statlbl.getText());
				}
			}
		});
		eigMen.getItems().add(ausw);
		Menu infMen = new Menu("_Info");
		MenuItem info = new MenuItem("_Info...");
		info.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Info");
				alert.setHeaderText("Information zu dieser Anwendung");
				alert.setContentText("Testat zur Java Vorleung \nFachbereich Informationstechnik \nHochschule Mannheim \nWintersemeseter 2014/15");
				alert.showAndWait();
			}
		});
		infMen.getItems().add(info);
		MenuBar menu = new MenuBar(datMen, eigMen, infMen);

		refbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if (cliSock == null) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Server nicht gesetzt");
					alert.setHeaderText(null);
					alert.setContentText("Bitte erst einen Server wählen");
					alert.showAndWait();
				} else {
					Object tempo;
					try {
						out.println("blabla");
						tempo = ois.readObject();
//						out.println("zeitstempel");
//						if ((tempo = ois.readObject()) != null) {
//							datelbl.setText((String) tempo);
//							statlbl.setText("Zeitstempel aktualisiert - " + statlbl.getText());
//						}
//						out.println("diagramm");
//						if ((tempo = ois.readObject()) != null) 
//							statistik =  (int[]) tempo;
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}
				
					pieChartData = FXCollections.observableArrayList();
					pieChartData.add(new PieChart.Data("Diagramm ("+statistik[0]+")", statistik[0]));
					pieChartData.add(new PieChart.Data("Zeitstempel ("+statistik[1]+")",statistik[1]));
					pieChartData.add(new PieChart.Data("Fehler ("+statistik[2]+")", statistik[2]));
					chart.setData(pieChartData);
					pieChartData.get(0).getNode().setStyle("-fx-pie-color: coral;");
					pieChartData.get(1).getNode().setStyle("-fx-pie-color: bisque;");
					pieChartData.get(2).getNode().setStyle("-fx-pie-color: firebrick;");

					statlbl.setText("Diagramm aktualisiert - " + statlbl.getText());
				}
			}
		});

		chart = new PieChart(pieChartData);
		chart.setTitle("Zugriffe auf Server");
		chart.legendVisibleProperty().set(false);

		rootPane.setTop(menu);
		rootPane.setCenter(subPane);
		subPane.setTop(datePane);
		subPane.setCenter(chart);
		rootPane.setBottom(statlbl);
		
		primaryStage.setScene(new Scene(rootPane, 500, 500));
		primaryStage.show();

	}

}
