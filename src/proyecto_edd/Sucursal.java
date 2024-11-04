package proyecto_edd;

//La clase sucursal representa una rama con un conjunto de estaciones y conexiones
public class Sucursal {
    private int t;
    private Object sucursal;
    private Object station;
    //Constructor
    public Sucursal(Object sucursal, Object station){
        this.t = 0;
        this.sucursal = sucursal;
        this.station = station;
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
    public Object getSucursal() {
        return sucursal;
    }
    //Setter
    public void setSucursal(Object sucursal) {
        this.sucursal = sucursal;
    }

    public Object getStation() {
        return station;
    }

    public void setStation(Object station) {
        this.station = station;
    }
    
}