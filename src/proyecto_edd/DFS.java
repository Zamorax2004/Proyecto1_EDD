package proyecto_edd;

import org.graphstream.graph.Node;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DFS {
    private int maxIterations;
    private Set<String> reachableStations;

    public DFS(int maxIterations) {
        this.maxIterations = maxIterations;
        this.reachableStations = new HashSet<>();
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

        Stream<Node> neighbors = node.neighborNodes();
        neighbors.forEach(neighbor -> {
            if (!visited.contains(neighbor.getId())) {
                dfs(neighbor, visited, currentIteration + 1);
            }
        });
    }
}