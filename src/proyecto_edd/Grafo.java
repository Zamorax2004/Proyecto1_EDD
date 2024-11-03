package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

//Esta clase representa una estructura "Grafo" utilizando la libreria GraphStream
public class Grafo {
    private Graph graph;
    private Lista estaciones;
    private Lista[] adjacencyList;
    //Constructor
    public Grafo() {
        System.setProperty("org.graphstream.ui", "javafx");
        graph = new SingleGraph("Grafo");
        estaciones = new Lista();
        adjacencyList = new Lista[10];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Lista();
        }
    }
    //Añade una estacion o nodo
    public void addStation(String station) {
        if (graph.getNode(station) == null) {
            graph.addNode(station).setAttribute("ui.label", station);
            estaciones.add(station);
            resizeAdjacencyList();
        }
    }
    //Añade una conexion o edge
    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2;
        if (graph.getEdge(edgeId) == null) {
            graph.addEdge(edgeId, station1, station2);
        }
        int index1 = findStationIndex(station1);
        int index2 = findStationIndex(station2);
        if (index1 != -1 && index2 != -1) {
            adjacencyList[index1].add(station2);
            adjacencyList[index2].add(station1);
        }
    }
    //Quita una estacion o nodo
    public void removeStation(String station) {
        Node node = graph.getNode(station);
        if (node != null) {
            graph.removeNode(station);
        }
        int index = findStationIndex(station);
        if (index != -1){
            estaciones.remove(station);
            adjacencyList[index] = null;
            for (int i = 0; i < adjacencyList.length; i++){
                if (adjacencyList[i] != null){
                    adjacencyList[i].remove(station);
                }
            }
        }
    }
    //Muestra el grafico 
    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        for (Edge edge : graph.getEdgeSet()){
            edge.setAttribute("ui.label", edge.getId());
        }
        graph.setAttribute("ui.stylesheet", "edge { text-size: 14; fill-color: black; }");
        graph.display();
    }
    
    // Devuelve las estaciones
    public Lista getEstaciones() {
        return estaciones;
    }

    // Devuelve la lista de adyacencia
    public Lista[] getAdjacencyList() {
        return adjacencyList;
    }

    // Encuentra el índice de una estación
    private int findStationIndex(String station) {
        for (int i = 0; i < estaciones.size(); i++) {
            if (estaciones.get(i).equals(station)) {
                return i;
            }
        }
        return -1;
    }

    // Redimensiona la lista de adyacencia
    private void resizeAdjacencyList() {
        if (estaciones.size() > adjacencyList.length) {
            Lista[] newAdjacencyList = new Lista[estaciones.size()];
            for (int i = 0; i < newAdjacencyList.length; i++) {
                if (i < adjacencyList.length) {
                    newAdjacencyList[i] = adjacencyList[i];
                } else {
                    newAdjacencyList[i] = new Lista();
                }
            }
            adjacencyList = newAdjacencyList;
        }
    }
}