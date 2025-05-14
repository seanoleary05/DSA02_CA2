package org.example.ca2_dsa2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView mapView;
    @FXML
    private StackPane stackPane;


    @FXML
    protected void onConfirm() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextArea csvTextArea;

    @FXML
    public void initialize() {
        // Called automatically after FXML is loaded
        String[][] data = readCSV("/vienna_subway.csv");

        StringBuilder builder = new StringBuilder();
        for (String[] row : data) {
            builder.append(String.join(" | ", row)).append("\n");
        }

        csvTextArea.setText(builder.toString());
    }

    private String[][] readCSV(String resourcePath) {
        ArrayList<String[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(resourcePath)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                dataList.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList.toArray(new String[0][]);
    }
}