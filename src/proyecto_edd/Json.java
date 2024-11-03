package proyecto_edd;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

//metodos para leer y escribir jsons usando gson
public class Json {
    private File file;
    //Constructor
    public Json(File file) {
        this.file = file;
    }
    //lee un json y retorna un JsonObject
    public JsonObject readJson() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, JsonObject.class);
        }
    }
    //añade JsonObject especifico al archivo
    public void writeJson(JsonObject jsonObject) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(jsonObject, writer);
        }
    }
}