package petshop.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONHelper {
    public ArrayList<JsonNode> getJsonObjectFilteredByName(String json, String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonpObject = objectMapper.readTree(json);
        Iterator<JsonNode> it = jsonpObject.iterator();
        ArrayList<JsonNode> result = new ArrayList<>();

        while (it.hasNext()) {
            JsonNode node = it.next();
            if (node.has("category") && (node.get("category").toString().contains(name))) {
                result.add(node);
            }
        }

        return result;
    }
}
