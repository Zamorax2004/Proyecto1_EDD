package proyecto_edd;

//Esta clase representa el tipo de busqueda en profundidad implementada para un grafo de paradas
public class DFSClass {
    private Sucursal sucursal;
    private Object[][] adjacencyList;
    private int stationCount;
    //Constructor
    public DFSClass(Sucursal sucursal, int maxStations) {
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
    //Funcion para buscar el indice de una parada en la lista de adyacencia
    private int findStationIndex(Object station) {
        for (int i = 0; i < stationCount; i++) {
            if (adjacencyList[i][0].equals(station)) {
                return i;
            }
        }
        return -1;
    }
    //Realiza un DFS
    public int dfs(int limit) {
        boolean[] visited = new boolean[stationCount];
        return dfsHelper(sucursal.getStation(), limit, visited);
    }
    //Ayuda a realizar un DFS
    private int dfsHelper(Object station, int limit, boolean[] visited) {
        if (limit < 0) return 0;
        int index = findStationIndex(station);
        if (index == -1 || visited[index]) return 0;
        visited[index] = true;
        int count = 1;
        System.out.println("Parada: " + station);
        for (int i = 1; i < stationCount; i++) {
            if (adjacencyList[index][i] != null && !visited[i]) {
                count += dfsHelper(adjacencyList[index][i], limit - 1, visited);
            }
        }
        return count;
    }
}