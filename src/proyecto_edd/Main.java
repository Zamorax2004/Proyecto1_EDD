package proyecto_edd;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class Main {
    
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            User user = mapper.readValue(new File("Caracas.json"), User.class);
            mapper.writeValue(new File("CaracasNew.json"), user);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
