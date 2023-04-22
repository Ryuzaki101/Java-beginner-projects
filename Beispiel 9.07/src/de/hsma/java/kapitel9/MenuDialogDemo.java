package de.hsma.java.kapitel9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuDialogDemo extends Application {
	
	private TextArea textArea;
	private InsertOption insertOption = InsertOption.append;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
	        primaryStage.setTitle("Menü Demo");
	        
	        textArea = new TextArea();
	        textArea.setPrefColumnCount(50);
	        textArea.setPrefRowCount(20);
	        
	        MenuBar menuBar = new MenuBar();
	        Menu menuDatei = new Menu("_Datei");
	        Menu menuEigenschaften = new Menu("_Eigenschaften");
	        
	        MenuItem laden = new MenuItem("_Laden");
	        laden.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ev) {
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Textdatei öffnen");
					fileChooser.getExtensionFilters().add(new ExtensionFilter("Textdatei", "*.txt"));
					
					File chosenFile = fileChooser.showOpenDialog(primaryStage);
					if(chosenFile != null && chosenFile.canRead()){
						
						if(insertOption == InsertOption.insert)
							textArea.clear();
							
						BufferedReader br = null;
						String inString;
						try {
							br = new BufferedReader(new InputStreamReader(new FileInputStream(chosenFile)));
							while((inString = br.readLine()) != null){
								primaryStage.sizeToScene();
								textArea.appendText(inString + "\n");
							}
							
							
						} catch (IOException e) {
							// Error Dialog für Fehlermeldung
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Fehler aufgetreten");
							alert.setHeaderText(null);	// keinen Header Bereich anzeigen
							alert.setContentText(e.getMessage());
							
						} finally {
							try {
								if(br != null)
									br.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
	        
	        MenuItem beenden = new MenuItem("_Beenden");
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
					if (result.isPresent() && result.get() == ButtonType.OK){
						System.exit(0);
					} 
				}
			});
	        
	        MenuItem resetView = new MenuItem("_Einfügeoption");
	        resetView.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ev) {
					
					ChoiceDialog<InsertOption> choice = new ChoiceDialog<InsertOption>(InsertOption.append,InsertOption.append, InsertOption.insert);
					choice.setTitle("Einfügeoption wählen");
					choice.setHeaderText(null);
					choice.setContentText("Bitte wählen Sie eine Einfügeoption");
					
					Optional<InsertOption> result = choice.showAndWait();
					
					if (result.isPresent()){
						insertOption = result.get();
					} 
				}
			});
	        
	        Menu menuInfo = new Menu("_Info");
	        
	        MenuItem ueber = new MenuItem("_Über");
	        ueber.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ev) {
					
					// Informations Dialog anzeigen
					Alert alert = new Alert(AlertType.INFORMATION);
			        alert.setTitle("Info");
			        alert.setHeaderText("Information zu dieser Anwendung");
			        alert.setContentText("Beispiel zur Java Vorlesung.\n"
			        		+ "Fachbereich Informationstechnik\n"
			        		+ "Hochschule Mannheim");
			        alert.initModality(Modality.NONE);	// Dialog ist nicht modal, die übrige Anwendung kann also weiter genutzt werden

			        alert.showAndWait();
					
				}
			});
	        
	        menuDatei.getItems().addAll(laden, new SeparatorMenuItem(), beenden);
	        menuEigenschaften.getItems().add(resetView);
	        menuInfo.getItems().add(ueber);
	        menuBar.getMenus().addAll(menuDatei, menuEigenschaften, menuInfo);
			
	        BorderPane menuPane = new BorderPane();
	        menuPane.setTop(menuBar);
	        menuPane.setCenter(textArea);
	        
	        primaryStage.setScene(new Scene(menuPane));
	        primaryStage.show();
	}
}
