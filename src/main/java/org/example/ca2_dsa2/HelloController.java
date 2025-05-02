package org.example.ca2_dsa2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView mapView;

    @FXML
    protected void onConfirm() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}