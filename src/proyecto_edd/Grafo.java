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

    // Añade una estacion o nodo
    public void addStation(String station, double x, double y) {
        if (graph.getNode(station) == null) {
            Node node = graph.addNode(station);
            node.setAttribute("ui.label", station);
            node.setAttribute("xyz", x, y, 0);
            nodePositions.put(station, new double[]{x, y});
        }
    }

    // Añade una conexion o edge
    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2 + "_" + UUID.randomUUID();
        graph.addEdge(edgeId, station1, station2);
    }

    // Quita una estacion o Nodo
    public void removeStation(String station) {
        Node node = graph.getNode(station);
        if (node != null) {
            graph.removeNode(station);
        }
    }

    // Muestra el grafo
    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }

        String styleSheet =
                "graph { padding: 50px; }" +
                "node { size: 10px; text-size: 14; text-alignment: at-right; fill-color: blue; }" +
                "node.marked { fill-color: red; }" +
                "edge { text-size: 14; fill-color: black; }" +
                "edge.marked { fill-color: red; }";

        graph.setAttribute("ui.stylesheet", styleSheet);
        Viewer viewer = graph.display();

        double xIncrement = 100.0;
        double yIncrement = 100.0;
        double x = 0.0;
        double y = 0.0;

        for (Node node : graph) {
            double[] pos = nodePositions.get(node.getId());
            if (pos != null) {
                node.setAttribute("xyz", pos[0], pos[1], 0);
            } else {
                node.setAttribute("xyz", x, y, 0);
                x += xIncrement;
                if (x > 500) {
                    x = 0;
                    y += yIncrement;
                }
            }
        }
    }

    // Loads stations and connections from a JSON file
    public void loadFromJSON(String jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, List<Map<String, List<Object>>>> data = mapper.readValue(new File(jsonFile), Map.class);
            double x = 0.0;
            double y = 0.0;
            double yIncrement = 100.0;
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
                                addStation(fromStation, x, y);
                                addStation(toStation, x, y);
                                if (previousStation != null) {
                                    addConnection(previousStation, fromStation);
                                    addConnection(previousStation, toStation);
                                }
                                previousStation = fromStation;
                                continue;
                            } else {
                                continue;
                            }
                            x = i * 30.0;
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
            createEdgesBetweenMatchingStations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Crea edges entre matchingStations dentro de combinedStationsMap
    private void createEdgesBetweenMatchingStations() {
        for (String station1 : combinedStationsMap.keySet()) {
            for (String station2 : combinedStationsMap.keySet()) {
                if (!station1.equals(station2) && combinedStationsMap.get(station1).equals(combinedStationsMap.get(station2))) {
                    addConnection(station1, station2);
                }
            }
        }
    }
    public Graph getGraph() {
        return graph;
    }
}