package proyecto_edd;

public class Sucursal {
    private int t;
    private Object station;
    
    public Sucursal(Object station){
        this.t = 0;
        this.station = station;
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
}