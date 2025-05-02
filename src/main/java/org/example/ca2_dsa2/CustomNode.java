package org.example.ca2_dsa2;

import java.util.ArrayList;
import java.util.List;

public class CustomNode<String> {
    public String name;
    public int nodeValue = Integer.MAX_VALUE;
    public List<CustomNode> adjList = new ArrayList<>();


    public CustomNode(String name){
        this.name = name;


    }

    public void connectToNodeDirected(CustomNode<String> destNode) {
        adjList.add(destNode);
    }
    public void connectToNodeUndirected(CustomNode<String> destNode) {
        adjList.add(destNode);
        destNode.adjList.add(this);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public List<CustomNode> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<CustomNode> adjList) {
        this.adjList = adjList;
    }
}
