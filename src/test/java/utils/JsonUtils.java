package utils;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public JsonObject parseJsonFile() throws Exception {
        JsonObject json = new JsonObject();
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/json_files/Create_User")));
        List <String> lines = Arrays.stream(content.split(",")).toList();
        for (String attribute : lines) {
            json.add(attribute.split(":")[0].trim(), attribute.split(":")[1].trim());
        }
        return json;
    }
}