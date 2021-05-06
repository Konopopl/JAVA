import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.google.gson.*;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Handler {
   // public static String fileLocation = "C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client.json";


    public static HashMap<String, String> handler(String fileLocation) throws IOException {
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(new String(Files.readAllBytes(Paths.get(fileLocation)))).getAsJsonObject();
        HashMap<String, String> fieldsHashMap = new HashMap<String, String>();
        Set<Map.Entry<String, JsonElement>> fields = o.entrySet();
        for (Map.Entry<String, JsonElement> m : fields) {
            fieldsHashMap.put(m.getKey(), m.getValue().toString().replace("\"", ""));
        }
        return fieldsHashMap;
    }
}
