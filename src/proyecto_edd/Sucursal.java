package proyecto_edd;

//La clase sucursal representa una rama con un conjunto de estaciones y conexiones
public class Sucursal {
    private int t;
    private Object station;
    private Lista stations;
    private Lista connections;
    //Constructor
    public Sucursal(Object station){
        this.t = 0;
        this.station = station;
        this.stations = new Lista();
        this.connections = new Lista();
    }
    //Getter
    public int getT() {
        return t;
    }
    //Setter
    public void setT(int t) {
        this.t = t;
    }
    //Getter
    public Object getStation() {
        return station;
    }
    //Setter
    public void setStation(Object station) {
        this.station = station;
    }
    //Funcion que añade una estacion
     public void addStation(Object station) {
        stations.add(station);
    }
     //Funcion que quita una estacion
    public void removeStation(Object station) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).equals(station)) {
                stations.remove(i);
                break;
            }
        }
    }
    //Funcion que añade una conexion
    public void addConnection(Object station1, Object station2) {
        connections.add(new String[]{station1.toString(), station2.toString()});
    }
    //Getter
    public Lista getStations() {
        return stations;
    }
    //Getter
    public Lista getConnections() {
        return connections;
    }
}