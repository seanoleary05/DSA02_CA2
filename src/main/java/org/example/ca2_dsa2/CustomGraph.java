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

    public static <T> CostedPath findCheapestPathDijkstra(CustomNode<?> startNode, T lookingfor) {
        CostedPath cp = new CostedPath(); //Create result object for cheapest path
        List<CustomNode<?>> encountered = new ArrayList<>(), unencountered = new ArrayList<>(); //Create encountered/unencountered lists
        startNode.nodeValue = 0; //Set the starting node value to zero
        unencountered.add(startNode); //Add the start node as the only value in the unencountered list to start
        CustomNode<?> currentNode;
        do { //Loop until unencountered list is empty
            currentNode = unencountered.remove(0); //Get the first unencountered node (sorted list, so will have lowest value)
            encountered.add(currentNode); //Record current node in encountered list
            if (currentNode.name.equals(lookingfor)) { //Found goal - assemble path list back to start and return it
                cp.pathList.add(currentNode); //Add the current (goal) node to the result list (only element)
                cp.pathCost = currentNode.nodeValue; //The total cheapest path cost is the node value of the current/goal node
                while (currentNode != startNode) { //While we're not back to the start node...
                    boolean foundPrevPathNode = false; //Use a flag to identify when the previous path node is identified
                    for (CustomNode<?> n : encountered) { //For each node in the encountered list...
                        for (CustomLink e : n.adjList) //For each edge from that node...
                            if (e.destNode == currentNode && currentNode.nodeValue - e.cost == n.nodeValue) { //If that edge links to the
//current node and the difference in node values is the cost of the edge -> found path node!
                                cp.pathList.add(0, n); //Add the identified path node to the front of the result list
                                currentNode = n; //Move the currentNode reference back to the identified path node
                                foundPrevPathNode = true; //Set the flag to break the outer loop
                                break; //We've found the correct previous path node and moved the currentNode reference
//back to it so break the inner loop
                            }
                        if (foundPrevPathNode)
                            break; //We've identified the previous path node, so break the inner loop to continue
                    }
                }
//Reset the node values for all nodes to (effectively) infinity so we can search again (leave no footprint!)
                for (CustomNode<?> n : encountered) n.nodeValue = Integer.MAX_VALUE;
                for (CustomNode<?> n : unencountered) n.nodeValue = Integer.MAX_VALUE;
                return cp; //The costed (cheapest) path has been assembled, so return it!
            }
//We're not at the goal node yet, so...
            for (CustomLink e : currentNode.adjList) //For each edge/link from the current node...
                if (!encountered.contains(e.destNode)) { //If the node it leads to has not yet been encountered (i.e. processed)
                    e.destNode.nodeValue = Integer.min(e.destNode.nodeValue, currentNode.nodeValue + e.cost); //Update the node value at the end
//of the edge to the minimum of its current value or the total of the current node's value plus the cost of the edge
                    if (!unencountered.contains(e.destNode)) unencountered.add(e.destNode);
                }
            Collections.sort(unencountered, (n1, n2) -> n1.nodeValue - n2.nodeValue); //Sort in ascending node value order
        } while (!unencountered.isEmpty());
        return null; //No path found, so return null

    }
}
