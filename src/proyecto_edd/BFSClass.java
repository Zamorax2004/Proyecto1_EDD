package proyecto_edd;

public class BFSClass {
    private Sucursal sucursal;
    private Object[][] adjacencyList;
    private int stationCount;

    public BFSClass(Sucursal sucursal, int maxStations) {
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

    public int bfs(int limit) {
        boolean[] visited = new boolean[stationCount];
        return bfsHelper(sucursal.getStation(), limit, visited);
    }

    private int bfsHelper(Object startStation, int limit, boolean[] visited) {
        Object[] queue = new Object[stationCount];
        int front = 0;
        int rear = 0;

        queue[rear++] = startStation;
        visited[findStationIndex(startStation)] = true;
        int count = 1;

        while (front != rear && limit-- > 0) {
            Object station = queue[front++];
            int index = findStationIndex(station);

            for (int i = 1; i < stationCount; i++) {
                if (adjacencyList[index][i] != null && !visited[i]) {
                    queue[rear++] = adjacencyList[index][i];
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}