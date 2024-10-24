package proyecto_edd;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Jsontest {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            Object data = mapper.readValue(new File("Caracas.json"), Object.class);
            
            mapper.writeValue(new File("CaracasNew.json"), data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    }
}