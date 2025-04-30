package org.example.ca2_dsa2;

public class CustomLink<T> {
    public CustomNode<T> destNode;
    public int cost;

    public CustomLink(CustomNode<T> destNode, int cost) {
        this.destNode = destNode;
        this.cost = cost;
    }

    public CustomNode<T> getDestNode() {
        return destNode;
    }

    public void setDestNode(CustomNode<T> destNode) {
        this.destNode = destNode;
    }
    public int getCost() {
        return cost;
    }
}
