package org.example.ca2_dsa2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        buildNodesFromCSV("/vienna_subway.csv");

        displayNodes();
    }

    private Map<String, CustomNode> nodeMap = new HashMap<>();

    private void buildNodesFromCSV(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(resourcePath)))) {

            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String start = parts[0].trim();
                String stop = parts[1].trim();
                // You can also read lineNumber and color if needed

                // Add start and stop stations as nodes (only if not already in the map)
                nodeMap.putIfAbsent(start, new CustomNode(start));
                nodeMap.putIfAbsent(stop, new CustomNode(stop));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void displayNodes() {
        StringBuilder builder = new StringBuilder("Nodes:\n");
        for (CustomNode node : nodeMap.values()) {
            builder.append(node).append("\n");
        }
        csvTextArea.setText(builder.toString());
    }
}