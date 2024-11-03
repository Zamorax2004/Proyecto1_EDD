package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import org.graphstream.ui.view.Viewer;

public class Grafo {
    private Graph graph;
    private Map<String, String> combinedStationsMap = new HashMap<>();
    private Map<String, double[]> nodePositions = new HashMap<>();

    // Constructor
    public Grafo() {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new MultiGraph("Grafo");
    }

    // Adds a station or node
    public void addStation(String station, double x, double y) {
        if (graph.getNode(station) == null) {
            Node node = graph.addNode(station);
            node.setAttribute("ui.label", station);
            node.setAttribute("xyz", x, y, 0);
            nodePositions.put(station, new double[]{x, y});
        }
    }

    // Adds a connection or edge
    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2 + "_" + UUID.randomUUID();
        graph.addEdge(edgeId, station1, station2);
    }

    // Removes a station or node
    public void removeStation(String station) {
        Node node = graph.getNode(station);
        if (node != null) {
            graph.removeNode(station);
        }
    }

    // Displays the graph
    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        graph.setAttribute("ui.stylesheet", "graph { padding: 50px; } node { size: 20px; text-size: 14; text-alignment: at-right; } edge { text-size: 14; fill-color: black; }");
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    // Loads stations and connections from a JSON file
    public void loadFromJSON(String jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, List<Map<String, List<Object>>>> data = mapper.readValue(new File(jsonFile), Map.class);
            double x = 0.0;
            double y = 0.0;
            double yIncrement = 50.0; // Increase the increment to make nodes more spacious
            for (Map.Entry<String, List<Map<String, List<Object>>>> entry : data.entrySet()) {
                List<Map<String, List<Object>>> lines = entry.getValue();
                for (Map<String, List<Object>> line : lines) {
                    for (Map.Entry<String, List<Object>> lineEntry : line.entrySet()) {
                        List<Object> stations = lineEntry.getValue();
                        String previousStation = null;
                        for (int i = 0; i < stations.size(); i++) {
                            Object station = stations.get(i);
                            String stationName;
                            if (station instanceof String) {
                                stationName = (String) station;
                            } else if (station instanceof Map) {
                                Map<String, String> transfer = (Map<String, String>) station;
                                String fromStation = transfer.keySet().iterator().next();
                                String toStation = transfer.get(fromStation);
                                stationName = fromStation + ":" + toStation;
                                combinedStationsMap.put(fromStation, stationName);
                                combinedStationsMap.put(toStation, stationName);
                            } else {
                                continue;
                            }
                            x = i * 30.0; // Increase spacing between nodes
                            addStation(stationName, x, y);
                            if (previousStation != null) {
                                addConnection(previousStation, stationName);
                            }
                            previousStation = stationName;
                        }
                        y += yIncrement;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.loadFromJSON("Caracas.json");
        grafo.loadFromJSON("Bogota.json");
        grafo.display();
    }
}