package org.example.ca2_dsa2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView mapView;
    @FXML
    private StackPane stackPane;
    @FXML private ComboBox<String> startComboBox;
    @FXML private ComboBox<String> endComboBox;
    @FXML private TextArea resultTextArea;


    @FXML
    protected void onConfirm() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextArea csvTextArea;

    @FXML
    public void initialize() {
        // Called automatically after FXML is loaded
        buildGraphFromCSV("/vienna_subway.csv");
        for (CustomNode node : graph.getNodes()) {
            startComboBox.getItems().add(node.getName());
            endComboBox.getItems().add(node.getName());
        }
        displayGraph();
    }

    private Map<String, CustomNode> nodeMap = new HashMap<>();
    private CustomGraph graph = new CustomGraph();

    private void buildGraphFromCSV(String resourcePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(resourcePath)))) {

            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String start = parts[0].trim();
                String stop = parts[1].trim();
                String lineNum = parts[2].trim();
                String color = parts[3].trim();

                graph.addEdge(start, stop, lineNum, color);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayGraph() {
        StringBuilder builder = new StringBuilder("Graph:\n");
        for (CustomNode node : graph.getNodes()) {
            builder.append(node.getName()).append(" connects to:\n");
            for (CustomLink edge : graph.getAdjacencyList().getOrDefault(node, List.of())) {
                builder.append("  - ").append(edge.getTo().getName())
                        .append(" (Line ").append(edge.getLine())
                        .append(", ").append(edge.getColor()).append(")\n");
            }
        }
        csvTextArea.setText(builder.toString());
    }
    private void displayNodes() {
        StringBuilder builder = new StringBuilder("Nodes:\n");
        for (CustomNode node : nodeMap.values()) {
            builder.append(node).append("\n");
        }
        csvTextArea.setText(builder.toString());
    }
    @FXML
    private void handleFindPath() {
        String start = startComboBox.getValue();
        String end = endComboBox.getValue();

        if (start == null || end == null || start.equals(end)) {
            resultTextArea.setText("Please select two different stations.");
            return;
        }

        List<String> path = bfsPath(start, end);
        if (path != null) {
            resultTextArea.setText("Path:\n" + String.join(" → ", path));
        } else {
            resultTextArea.setText("No path found between " + start + " and " + end);
        }
    }

    private List<String> bfsPath(String startName, String endName) {
        CustomNode start = graph.getNode(startName);
        CustomNode end = graph.getNode(endName);

        Map<CustomNode, CustomNode> cameFrom = new HashMap<>();
        Queue<CustomNode> queue = new LinkedList<>();
        Set<CustomNode> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            CustomNode current = queue.poll();

            if (current.equals(end)) {
                // Reconstruct path
                LinkedList<String> path = new LinkedList<>();
                while (current != null) {
                    path.addFirst(current.getName());
                    current = cameFrom.get(current);
                }
                return path;
            }

            for (CustomLink link : graph.getAdjacencyList().getOrDefault(current, List.of())) {
                CustomNode neighbor = link.getTo();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return null; // No path found
    }
}