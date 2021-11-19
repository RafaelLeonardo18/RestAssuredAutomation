package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONObject;

public class JsonUtils {

    public static JSONObject parseJsonFile(String jsonFile) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/json_files/" + jsonFile + ".json")));
        return new JSONObject(content);
    }

    public static JSONObject updateJsonObject(JSONObject json, String keyMain, String newValue) throws Exception {
        Iterator iterator = json.keys();
        iterator.forEachRemaining(iteratorKey -> {
            if ((json.optJSONArray(iteratorKey.toString()) == null) && (json.optJSONObject(iteratorKey.toString()) == null)) {
                if (iteratorKey.toString().equals(keyMain)){
                    json.put(iteratorKey.toString(), newValue);
                }
            }
            if (json.optJSONObject(iteratorKey.toString()) != null) {
                try {
                    updateJsonObject(json.getJSONObject(iteratorKey.toString()), keyMain, newValue);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (json.optJSONArray(iteratorKey.toString()) != null){
                json.optJSONArray(iteratorKey.toString()).forEach(jsonObject -> {
                    try {
                        updateJsonObject((JSONObject) jsonObject, keyMain, newValue);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
            }
        });
        return json;
    }

}