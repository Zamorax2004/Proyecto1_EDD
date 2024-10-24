package proyecto_edd;

public class Nodo {
    private Object data;
    private Nodo next;
    
    ObjectMapper objectMapper = new ObjectMapper();
    
    ObjectNode objectNode = objectmapper.createObjectNode();
    
    objectNode.put("attribute1", "value1");
    
}