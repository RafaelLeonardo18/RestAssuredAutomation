package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;

public record User(String name, String gender, String email, String status) {

    public JSONObject getJson(){
        return new JSONObject(new Gson().toJson(this));
    }
}