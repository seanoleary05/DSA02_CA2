import static org.junit.jupiter.api.Assertions.*;

import org.example.ca2_dsa2.CustomLink;
import org.example.ca2_dsa2.CustomNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class TestClass {
    @Test
    public void testNameGetter() {
        CustomNode node = new CustomNode("A");
        assertEquals("A", node.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        CustomNode node1 = new CustomNode("A");
        CustomNode node2 = new CustomNode("A");
        CustomNode node3 = new CustomNode("B");

        assertEquals(node1, node2);
        assertEquals(node1.hashCode(), node2.hashCode());
        assertNotEquals(node1, node3);
    }

    @Test
    public void testToString() {
        CustomNode node = new CustomNode("TestNode");
        assertEquals("TestNode", node.toString());
    }
    @Test
    public void testLinkCreation() {
        CustomNode from = new CustomNode("A");
        CustomNode to = new CustomNode("B");
        CustomLink link = new CustomLink(from, to, "Line1", "Red");

        assertEquals(from, link.getFrom());
        assertEquals(to, link.getTo());
        assertEquals("Line1", link.getLine());
        assertEquals("Red", link.getColor());
    }

    @Test
    public void testToStringFormat() {
        CustomNode from = new CustomNode("X");
        CustomNode to = new CustomNode("Y");
        CustomLink link = new CustomLink(from, to, "L1", "Blue");

        String expected = "X -> Y (L1, Blue)";
        assertEquals(expected, link.toString());
    }
    @Test
    public void testAddEdgeAndNodes() {
        CustomGraph graph = new CustomGraph();
        graph.addEdge("A", "B", "L1", "Green");

        CustomNode nodeA = graph.getNode("A");
        CustomNode nodeB = graph.getNode("B");

        assertNotNull(nodeA);
        assertNotNull(nodeB);

        // Check adjacency
        List<CustomLink> linksFromA = graph.getAdjacencyList().get(nodeA);
        List<CustomLink> linksFromB = graph.getAdjacencyList().get(nodeB);

        assertEquals(1, linksFromA.size());
        assertEquals(1, linksFromB.size());

        assertEquals(nodeB, linksFromA.get(0).getTo());
        assertEquals(nodeA, linksFromB.get(0).getTo());
    }

    @Test
    public void testGetAllNodes() {
        CustomGraph graph = new CustomGraph();
        graph.addEdge("A", "B", "L1", "Red");
        graph.addEdge("B", "C", "L2", "Blue");

        Set<CustomNode> allNodes = graph.getAllNodes();
        assertEquals(3, allNodes.size());
    }
}
