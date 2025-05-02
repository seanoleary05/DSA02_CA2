package org.example.ca2_dsa2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    public static Stage mainStage;
    public static Scene homePage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        mainStage.setTitle("Vienna U-Bahn Route Finder");
        mainStage.setScene(homePage);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
        CustomNode<String> a = new CustomNode<>("Oberlaa");
        CustomNode<String> b = new CustomNode<>("Neulaa");
        CustomNode<String> c = new CustomNode<>("Alaudagasse");
        CustomNode<String> d = new CustomNode<>("Altes Landgut");
        CustomNode<String> e = new CustomNode<>("Troststrasse");

        a.connectToNodeUndirected(b);
        a.connectToNodeUndirected(c);
        b.connectToNodeUndirected(c);
        c.connectToNodeUndirected(d);
        d.connectToNodeUndirected(e);

        CustomGraph.traverseGraphDepthFirst(b,null);



    }



    }
