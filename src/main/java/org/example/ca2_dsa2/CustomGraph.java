package org.example.ca2_dsa2;

import javafx.fxml.Initializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomGraph {
    public static CustomGraph graph;

    public static class CostedPath {
        public int pathCost = 0;
        public List<CustomNode<?>> pathList = new ArrayList<>();
        public int index; //Just for displaying in listView, Ex. Route 1, Route 2 etc. for clarity

        @Override
        public String toString() {

            StringBuilder pathString = new StringBuilder("[ ROUTE " + index + " ]  -   PATH COST : " + pathCost + "\n\n");
            for (int i = 0; i < pathList.size(); i++) {
                CustomNode<?> node = pathList.get(i);
                pathString.append(node.getName());

                if (i < pathList.size() - 1) {
                    pathString.append("  ->  ");
                }
            }
            return pathString + "\n\n";
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    //Regular recursive depth-first graph traversal
    public static void traverseGraphDepthFirst(CustomNode<?> from, List<CustomNode<?>> encountered ){
        System.out.println(from.name);
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        for(CustomNode<?> adjNode : from.adjList)
            if(!encountered.contains(adjNode)) traverseGraphDepthFirst(adjNode, encountered );
    }



}
