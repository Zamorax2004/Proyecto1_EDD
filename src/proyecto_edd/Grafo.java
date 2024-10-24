package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class Grafo {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        // Create a new graph
        Graph graph = new SingleGraph("Tutorial 1");

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        // Add edges
        graph.addEdge("AB", "A", "B"); // Undirected edge
        graph.addEdge("BC", "B", "C"); // Directed edge from B to C
        graph.addEdge("CA", "C", "A"); // Undirected edge

        // Display the graph
        graph.display();
    }
}