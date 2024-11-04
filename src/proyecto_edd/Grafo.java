package proyecto_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import org.graphstream.ui.view.Viewer;

public class Grafo {
    private Graph graph;
    private CustomMap<String, String> combinedStationsMap = new CustomMap<>();
    private CustomMap<String, double[]> nodePositions = new CustomMap<>();
    private CustomMap<String, CustomList<String>> adjacencyList = new CustomMap<>();

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
            adjacencyList.put(station, new CustomList<>());
        }
    }

    // Adds a connection or edge
    public void addConnection(String station1, String station2) {
        String edgeId = station1 + "-" + station2 + "_" + CustomUUIDGenerator.generateUUID();
        graph.addEdge(edgeId, station1, station2);
        adjacencyList.get(station1).add(station2);
        adjacencyList.get(station2).add(station1);
    }

    // Removes a station or node
    public void removeStation(String station) {
        Node node = graph.getNode(station);
        if (node != null) {
            graph.removeNode(station);
            adjacencyList.remove(station);
            for (CustomList<String> neighbors : adjacencyList.values()) {
                neighbors.remove(station);
            }
        }
    }

    // Displays the graph
    public void display() {
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }

        // Set node styles like a subway map
        String styleSheet =
                "graph { padding: 50px; }" +
                "node { size: 10px; text-size: 14; text-alignment: at-right; fill-color: blue; }" +
                "node.marked { fill-color: red; }" +
                "edge { text-size: 14; fill-color: black; }" +
                "edge.marked { fill-color: red; }";

        graph.setAttribute("ui.stylesheet", styleSheet);
        Viewer viewer = graph.display();

        // Adjust node positions for better layout
        double xIncrement = 100.0;
        double yIncrement = 100.0;
        double x = 0.0;
        double y = 0.0;

        for (Node node : graph) {
            double[] pos = nodePositions.get(node.getId());
            if (pos != null) {
                // Adjust positions programmatically for subway station layout
                node.setAttribute("xyz", pos[0], pos[1], 0);
            } else {
                // New layout logic
                node.setAttribute("xyz", x, y, 0);
                x += xIncrement;
                if (x > 500) { // Reset x and increment y to create a grid-like layout
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
            CustomMap<String, CustomList<CustomMap<String, CustomList<Object>>>> data = mapper.readValue(new File(jsonFile), CustomMap.class);
            double x = 0.0;
            double y = 0.0;
            double yIncrement = 100.0;
            for (CustomMap.Entry<String, CustomList<CustomMap<String, CustomList<Object>>>> entry : data.entrySet()) {
                CustomList<CustomMap<String, CustomList<Object>>> lines = entry.getValue();
                for (CustomMap<String, CustomList<Object>> line : lines) {
                    for (CustomMap.Entry<String, CustomList<Object>> lineEntry : line.entrySet()) {
                        CustomList<Object> stations = lineEntry.getValue();
                        String previousStation = null;
                        for (int i = 0; i < stations.size(); i++) {
                            Object station = stations.get(i);
                            String stationName;
                            if (station instanceof String) {
                                stationName = (String) station;
                            } else if (station instanceof CustomMap) {
                                CustomMap<String, String> transfer = (CustomMap<String, String>) station;
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
    // Create edges between matching stations from combinedStationsMap
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

    public CustomMap<String, CustomList<String>> getAdjacencyList() {
        return adjacencyList;
    }
}