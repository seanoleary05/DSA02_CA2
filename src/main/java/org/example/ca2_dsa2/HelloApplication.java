package org.example.ca2_dsa2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelloApplication extends Application {

    public static Stage mainStage;
    public static Scene homePage;
    @Override
    public void start(Stage stage) throws IOException {
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        String[][] data = readCSV("/vienna_subway.csv");

        StringBuilder builder = new StringBuilder();
        for (String[] row : data) {
            builder.append(String.join(" | ", row)).append("\n");
        }

        textArea.setText(builder.toString());

        StackPane stackPane = new StackPane(textArea);
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        mainStage.setTitle("Vienna U-Bahn Route Finder");
        mainStage.setScene(homePage);
        mainStage.setScene(scene);
        mainStage.show();
    }
    private String[][] readCSV(String resourcePath) {
        ArrayList<String[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(resourcePath)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim(); // Remove spaces
                }
                dataList.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList.toArray(new String[0][]);
    }


    public static void main(String[] args) {
        launch();

    }



    }
