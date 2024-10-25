package proyecto_edd;

public class DFSClass {
    private Sucursal sucursal;
    private Object[][] adjacencyList;
    private int stationCount;

    public DFSClass(Sucursal sucursal, int maxStations) {
        this.sucursal = sucursal;
        this.adjacencyList = new Object[maxStations][maxStations];
        this.stationCount = 0;
    }

    public void addStation(Object newStation) {
        if (stationCount < adjacencyList.length) {
            adjacencyList[stationCount][0] = newStation;
            stationCount++;
        }
    }

    public void addEdge(Object station1, Object station2) {
        int index1 = findStationIndex(station1);
        int index2 = findStationIndex(station2);
        if (index1 != -1 && index2 != -1) {
            adjacencyList[index1][index2] = station2;
            adjacencyList[index2][index1] = station1;
        }
    }

    private int findStationIndex(Object station) {
        for (int i = 0; i < stationCount; i++) {
            if (adjacencyList[i][0].equals(station)) {
                return i;
            }
        }
        return -1;
    }

    public int dfs(int limit) {
        boolean[] visited = new boolean[stationCount];
        return dfsHelper(sucursal.getStation(), limit, visited);
    }

    private int dfsHelper(Object station, int limit, boolean[] visited) {
        if (limit < 0) return 0;
        int index = findStationIndex(station);
        if (index == -1 || visited[index]) return 0;
        visited[index] = true;
        int count = 1;
        for (int i = 1; i < stationCount; i++) {
            if (adjacencyList[index][i] != null && !visited[i]) {
                count += dfsHelper(adjacencyList[index][i], limit - 1, visited);
            }
        }
        return count;
    }
}