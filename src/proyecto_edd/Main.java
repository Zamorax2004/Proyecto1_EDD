package proyecto_edd;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class Main {
    
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            User user = objectMapper.readValue(new File("Caracas.json"),User.class);
            System.out.println("Red: " + user.getRed());
            System.out.println("Linea: " + user.getNum_linea());
            System.out.println("Parada: " + user.getParada());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
