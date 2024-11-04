package proyecto_edd;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    private int maxIterations;
    private Set<String> reachableStations;

    public BFS(int maxIterations) {
        this.maxIterations = maxIterations;
        this.reachableStations = new HashSet<>();
    }

    public Set<String> getReachableStations() {
        return reachableStations;
    }

    public void search(Grafo grafo, Node startNode) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode.getId());

        int currentIteration = 0;

        while (!queue.isEmpty() && currentIteration <= maxIterations) {
            Node node = queue.poll();
            reachableStations.add(node.getId());
            node.setAttribute("ui.class", "marked");

            for (String neighborId : grafo.getAdjacencyList().get(node.getId())) {
                Node neighborNode = grafo.getGraph().getNode(neighborId);
                if (!visited.contains(neighborNode.getId())) {
                    queue.add(neighborNode);
                    visited.add(neighborNode.getId());
                }
            }

            currentIteration++;
        }
    }
}