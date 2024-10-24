package proyecto_edd;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Json {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            User data = mapper.readValue(new File("Caracas.json"), User.class);
            
            mapper.writeValue(new File("CaracasNew.json"), data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
