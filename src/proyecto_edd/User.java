package proyecto_edd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String red;
    private String linea;
    private String parada;

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    } 
}