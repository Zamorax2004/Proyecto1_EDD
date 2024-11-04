package proyecto_edd;

import org.graphstream.graph.Node;

public class DFS {
    private int maxIterations;
    private CustomSet<String> reachableStations;
    private Grafo grafo;

    public DFS(int maxIterations, Grafo grafo) {
        this.maxIterations = maxIterations;
        this.reachableStations = new CustomSet<>();
        this.grafo = grafo;
    }

    public CustomSet<String> getReachableStations() {
        return reachableStations;
    }

    public void search(Node startNode) {
        CustomSet<String> visited = new CustomSet<>();
        dfs(startNode, visited, 0);
    }

    private void dfs(Node node, CustomSet<String> visited, int currentIteration) {
        if (currentIteration > maxIterations) {
            return;
        }
        visited.add(node.getId());
        reachableStations.add(node.getId());
        node.setAttribute("ui.class", "marked");

        CustomList<String> neighbors = grafo.getAdjacencyList().get(node.getId());
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