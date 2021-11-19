package runner;

import org.json.JSONObject;
import org.junit.Test;
import utils.JsonUtils;

public class UpdateJson {

    @Test
    public void update() throws Exception {
        JSONObject json = JsonUtils.parseJsonFile("update");
        System.out.println(json);
        System.out.println("======================================================================================");
        json = JsonUtils.updateJsonObject(json, "origin", "192.168.0.111");
        json = JsonUtils.updateJsonObject(json, "nome", "Leonardo");
        System.out.println(json);
    }
}
