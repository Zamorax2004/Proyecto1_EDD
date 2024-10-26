package proyecto_edd;

public class Sucursal {
    private int t;
    private Object station;
    private Lista stations;
    private Lista connections;
    
    public Sucursal(Object station){
        this.t = 0;
        this.station = station;
        this.stations = new Lista();
        this.connections = new Lista();
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public Object getStation() {
        return station;
    }

    public void setStation(Object station) {
        this.station = station;
    }
    
     public void addStation(Object station) {
        stations.add(station);
    }

    public void addConnection(Object station1, Object station2) {
        connections.add(new String[]{station1.toString(), station2.toString()});
    }
    
    public Lista getStations() {
        return stations;
    }

    public Lista getConnections() {
        return connections;
    }
}