package org.example.ca2_dsa2;

import java.util.ArrayList;
import java.util.List;

public class CustomNode<String> {
    public String name;
    public int nodeValue = Integer.MAX_VALUE;
    public List<CustomLink> adjList = new ArrayList<>();
    private int xCoordinate;
    private int yCoordinate;

    public CustomNode(String name, int xCoordinate, int yCoordinate){
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
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

    public List<CustomLink> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<CustomLink> adjList) {
        this.adjList = adjList;
    }
}
