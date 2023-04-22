/*
 * 
 * 
 * 
 */

package SS15;

import java.io.*;
import java.util.*;
import java.net.Socket;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatClient extends Application {

	private TextArea textArea;
	private TextField textField;
	private Socket cliSock = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Chat Client");
		BorderPane rootPane = new BorderPane();

		textArea = new TextArea();
		textField = new TextField();
		textArea.setEditable(false);

		MenuBar menuBar = new MenuBar();

		Menu menuDatei = new Menu("_Datei");
		MenuItem beenden = new MenuItem("_Beenden");

		Menu menuEigenschaften = new Menu("_Eigenschaften");
		MenuItem auswahl = new MenuItem("_Server Auswahl");

		Menu menuInfo = new Menu("_Info");
		MenuItem ueber = new MenuItem("_Über");

		beenden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ev) {

				// Bestätigung Dialog
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Wirklich beenden?");
				alert.setHeaderText("Bitte das Beenden der Anwendung bestätigen...");
				alert.setContentText("Wollen Sie die Anwendung wirklich beenden?");

				// Dialog anzeigen
				Optional<ButtonType> result = alert.showAndWait();

				// Gedrückten Button auswerten
				if (result.isPresent() && result.get() == ButtonType.OK) {
					System.exit(0);
				}
			}
		});

		auswahl.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				List<String> choices = new ArrayList<>();
				choices.add("localhost:8888");
				choices.add("141.19.96.40:8888");

				ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
				dialog.setTitle("Server Auswahl");
				dialog.setHeaderText(null);
				dialog.setContentText("Bitte einen Server Wählen:");

				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					result.get();
					String tmp[] = result.get().split(":");
					try {
						cliSock = new Socket(tmp[0], Integer.parseInt(tmp[1]));
						out = new PrintWriter(cliSock.getOutputStream(), true); // true for autoflush
						in = new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
						(new InputThread()).start();
					} catch (IOException e) {
						e.printStackTrace();
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Server Verbindung");
						alert.setHeaderText(null);
						alert.setContentText("Verbindung mit dem Server fehlgeschlagen!");
						alert.showAndWait();
					}
				}
			}
		});

		ueber.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ev) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Info");
				alert.setHeaderText("Information zu dieser Anwendung");
				alert.setContentText("Testat zur Java Vorlesung.\n"
									+"Sommersemester 2015\n"
									+"Ein einfacher Chat Client");
				alert.showAndWait();
			}
		});

		menuDatei.getItems().add(beenden);
		menuEigenschaften.getItems().add(auswahl);
		menuInfo.getItems().add(ueber);
		menuBar.getMenus().addAll(menuDatei, menuEigenschaften, menuInfo);

		textField.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if (cliSock == null) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Server auswählen");
					alert.setHeaderText(null);
					alert.setContentText("Bitte zuerst einen Server auswählen");
					alert.showAndWait();
				} else if (textField.getText().equals("")){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Nachricht leer");
					alert.setHeaderText(null);
					alert.setContentText("Bitte einen Text eingeben.");
					alert.showAndWait();
				} else
					out.println(textField.getText());

				textField.clear();
			}
		});

		rootPane.setTop(menuBar);
		rootPane.setCenter(textArea);
		rootPane.setBottom(textField);

		primaryStage.setScene(new Scene(rootPane, 600, 500));
		primaryStage.show();
	}

	class InputThread extends Thread {

		public void run() {
			String temp;
			try {
				while ((temp = in.readLine()) != null)
				textArea.setText(textArea.getText() + "\n" + temp);
				out.close();
				in.close();
				cliSock.close();
			} catch (IOException e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Server Kommunikation");
				alert.setHeaderText(null);
				alert.setContentText("Fehler bei der Kommunikation mit dem Server!");
				alert.showAndWait();
			}
		}
	}
}
