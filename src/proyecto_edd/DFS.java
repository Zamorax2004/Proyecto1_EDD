package proyecto_edd;

import org.graphstream.graph.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {
    private int maxIterations;
    private Set<String> reachableStations;
    private Grafo grafo;

    public DFS(int maxIterations, Grafo grafo) {
        this.maxIterations = maxIterations;
        this.reachableStations = new HashSet<>();
        this.grafo = grafo;
    }

    public Set<String> getReachableStations() {
        return reachableStations;
    }

    public void search(Node startNode) {
        Set<String> visited = new HashSet<>();
        dfs(startNode, visited, 0);
    }

    private void dfs(Node node, Set<String> visited, int currentIteration) {
        if (currentIteration > maxIterations) {
            return;
        }
        visited.add(node.getId());
        reachableStations.add(node.getId());
        node.setAttribute("ui.class", "marked");

        List<String> neighbors = grafo.getAdjacencyList().get(node.getId());
        if (neighbors != null) {
            for (String neighborId : neighbors) {
                Node neighborNode = grafo.getGraph().getNode(neighborId);
                if (!visited.contains(neighborId)) {
                    dfs(neighborNode, visited, currentIteration + 1);
                }
            }
        }
    }
}