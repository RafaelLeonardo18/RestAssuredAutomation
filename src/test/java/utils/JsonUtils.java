package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class JsonUtils {

    public static JSONObject parseJsonFile() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/json_files/Create_User.json")));
        return new JSONObject(content);
    }
}