package proyecto_edd;
//Esta clase representa el tipo de busqueda en amplitud implementada para un grafo de parada
public class BFSClass {
    private Sucursal sucursal;
    private Object[][] adjacencyList;
    private int stationCount;
    //Constructor
    public BFSClass(Sucursal sucursal, int maxStations) {
        this.sucursal = sucursal;
        this.adjacencyList = new Object[maxStations][maxStations];
        this.stationCount = 0;
    }
    //Añade una parada al grafo
    public void addStation(Object newStation) {
        if (stationCount < adjacencyList.length) {
            adjacencyList[stationCount][0] = newStation;
            stationCount++;
        }
    }
    //Quita una parada del grafo
    public void removeStation(Object station) {
        int index = findStationIndex(station);
        if (index != -1) {
            for (int i = 0; i < stationCount; i++) {
                adjacencyList[index][i] = null;
                adjacencyList[i][index] = null;
            }
            for (int i = index; i < stationCount - 1; i++) {
                adjacencyList[i] = adjacencyList[i + 1];
            }
            stationCount--;
        }
    }
    //Añade un edge al grafo
    public void addEdge(Object station1, Object station2) {
        int index1 = findStationIndex(station1);
        int index2 = findStationIndex(station2);
        if (index1 != -1 && index2 != -1) {
            adjacencyList[index1][index2] = station2;
            adjacencyList[index2][index1] = station1;
        }
    }
    //Metodo para encontrar el indice de una parada en una lista de adyacencia
    private int findStationIndex(Object station) {
        for (int i = 0; i < stationCount; i++) {
            if (adjacencyList[i][0].equals(station)) {
                return i;
            }
        }
        return -1;
    }
    //Realiza una operacion BFS
    public int bfs(int limit) {
        if (stationCount == 0) {
            throw new IllegalStateException("No se han agregado paradas");
        }
        boolean[] visited = new boolean[stationCount];
        return bfsHelper(sucursal.getStation(), limit, visited);
    }
    //Ayuda a realizar la operacion BFS
    private int bfsHelper(Object startStation, int limit, boolean[] visited) {
        Object[] queue = new Object[stationCount];
        int front = 0;
        int rear = 0;

        int startIndex = findStationIndex(startStation);
        if (startIndex == -1 || startIndex >= visited.length) {
            throw new IndexOutOfBoundsException("Fuera de limite");
        }

        queue[rear++] = startStation;
        visited[startIndex] = true;
        int count = 1;

        while (front != rear && limit-- > 0) {
            Object station = queue[front++];
            int index = findStationIndex(station);

            if (index == -1 || index >= visited.length) {
                throw new IndexOutOfBoundsException("Fuera de limite");
            }

            for (int i = 1; i < stationCount; i++) {
                if (adjacencyList[index][i] != null && !visited[i]) {
                    if (rear >= queue.length) {
                        throw new IndexOutOfBoundsException("Fuera de limite");
                    }
                    queue[rear++] = adjacencyList[index][i];
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}