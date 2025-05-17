package org.example.ca2_dsa2;

import java.util.*;

public class CustomGraph {
    private Map<String, CustomNode> nodes = new HashMap<>();
    private Map<CustomNode, List<CustomLink>> adjacencyList = new HashMap<>();

    public void addEdge(String fromName, String toName, String line, String color) {
        CustomNode from = nodes.computeIfAbsent(fromName, CustomNode::new);
        CustomNode to = nodes.computeIfAbsent(toName, CustomNode::new);

        CustomLink link = new CustomLink(from, to, line, color);
        adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(link);

        // For undirected graphs, add reverse edge:
        CustomLink reverseLink = new CustomLink(to, from, line, color);
        adjacencyList.computeIfAbsent(to, k -> new ArrayList<>()).add(reverseLink);
    }

    public Map<CustomNode, List<CustomLink>> getAdjacencyList() {
        return adjacencyList;
    }

    public Collection<CustomNode> getNodes() {
        return nodes.values();
    }

    public CustomNode getNode(String name) {
        return nodes.get(name);
    }
    public Set<CustomNode> getAllNodes() {
        return adjacencyList.keySet();
    }
}