package proyecto_edd;

import org.graphstream.graph.Node;

public class BFS {
    private int maxIterations;
    private CustomSet<String> reachableStations;

    public BFS(int maxIterations) {
        this.maxIterations = maxIterations;
        this.reachableStations = new CustomSet<>();
    }

    public CustomSet<String> getReachableStations() {
        return reachableStations;
    }

    public void search(Grafo grafo, Node startNode) {
        CustomSet<String> visited = new CustomSet<>();
        CustomQueue<Node> queue = new CustomQueue<>();
        queue.enqueue(startNode);
        visited.add(startNode.getId());

        int currentIteration = 0;

        while (!queue.isEmpty() && currentIteration <= maxIterations) {
            Node node = queue.dequeue();
            reachableStations.add(node.getId());
            node.setAttribute("ui.class", "marked");

            for (String neighborId : grafo.getAdjacencyList().get(node.getId())) {
                Node neighborNode = grafo.getGraph().getNode(neighborId);
                if (!visited.contains(neighborNode.getId())) {
                    queue.enqueue(neighborNode);
                    visited.add(neighborNode.getId());
                }
            }

            currentIteration++;
        }
    }
}