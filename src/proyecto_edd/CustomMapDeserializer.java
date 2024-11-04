package proyecto_edd;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class CustomMapDeserializer extends JsonDeserializer<CustomMap<String, CustomList<CustomMap<String, CustomList<Object>>>>> {

    @Override
    public CustomMap<String, CustomList<CustomMap<String, CustomList<Object>>>> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        CustomMap<String, CustomList<CustomMap<String, CustomList<Object>>>> customMap = new CustomMap<>();
        JsonNode node = jp.getCodec().readTree(jp);

        for (JsonNode child : node) {
            String key = child.fieldNames().next();
            CustomList<CustomMap<String, CustomList<Object>>> value = jp.getCodec().treeToValue(child, new TypeReference<CustomList<CustomMap<String, CustomList<Object>>>>() {});
            customMap.putEntry(key, value);
        }

        return customMap;
    }
}