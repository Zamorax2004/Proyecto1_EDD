package proyecto_edd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String red;
    private String num_linea;
    private String parada;

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getNum_linea() {
        return num_linea;
    }

    public void setNum_linea(String num_linea) {
        this.num_linea = num_linea;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }
    
    
}