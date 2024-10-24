package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Grafo {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("example");

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        // Add edges
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        // Display the graph
        graph.display();
    }
}