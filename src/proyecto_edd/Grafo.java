package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Grafo {
    private Graph graph;

    public Grafo() {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Grafo");
    }

    public void addStation(String station) {
        if (graph.getNode(station) == null) {
            graph.addNode(station).setAttribute("ui.label", station);
        }
    }

    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2;
        if (graph.getEdge(edgeId) == null) {
            graph.addEdge(edgeId, station1, station2);
        }
    }

    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        graph.display();
    }
}