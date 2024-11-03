package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

//Esta clase representa una estructura "Grafo" utilizando la libreria GraphStream
public class Grafo {
    private Graph graph;
    //Constructor
    public Grafo() {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Grafo");
    }
    //Añade una estacion o nodo
    public void addStation(String station) {
        if (graph.getNode(station) == null) {
            graph.addNode(station).setAttribute("ui.label", station);
        }
    }
    //Añade una conexion o edge
    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2;
        if (graph.getEdge(edgeId) == null) {
            graph.addEdge(edgeId, station1, station2);
        }
    }
    //Quita una estacion o nodo
    public void removeStation(String station) {
        Node node = graph.getNode(station);
        if (node != null) {
            graph.removeNode(station);
        }
    }
    //Muestra el grafico 
    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        
        graph.setAttribute("ui.stylesheet", "edge { text-size: 14; fill-color: black; }");
        graph.display();
    }
}