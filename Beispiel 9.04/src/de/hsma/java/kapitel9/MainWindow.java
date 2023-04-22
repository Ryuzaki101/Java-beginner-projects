package de.hsma.java.kapitel9;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainWindow extends BorderPane {

    @FXML
    private Button left;

    @FXML
    private Button center;

    @FXML
    private Button right;

    @FXML
    private TextField textField;

    @FXML
    void onCenterButton(ActionEvent event) {
    	textField.setText(textField.getText() + " pressed");
    }
    
    public MainWindow() {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
    	loader.setController(this);
    	loader.setRoot(this);
    	
    	try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
