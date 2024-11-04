package proyecto_edd;

//La clase sucursal representa una rama con un conjunto de estaciones y conexiones
public class Sucursal {
    private int t;
    private Object sucursal;
    //Constructor
    public Sucursal(Object station){
        this.t = 0;
        this.sucursal = station;
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
}