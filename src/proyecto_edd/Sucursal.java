package proyecto_edd;

//La clase Sucursal contiene una variable t, el numero de sucursal y la estacion asociada
public class Sucursal {
    private int t;
    private int sucursal;
    private Object station;
    //Constructor
    public Sucursal(int sucursal, Object station){
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
    public int getSucursal() {
        return sucursal;
    }
    //Setter
    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public Object getStation() {
        return station;
    }

    public void setStation(Object station) {
        this.station = station;
    }
    
}