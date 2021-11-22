package api;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import payload.Payload;
import user.UserLombok;

public class ApiBodies {

    public static JSONObject createRequestBody(String uri) {
        JSONObject jsonRequest = new JSONObject();
        if (uri.equals("https://gorest.co.in/public/v1/users")){
            jsonRequest = gorestBody();
        }
        return jsonRequest;
    }

    private static JSONObject gorestBody() {
        Payload payload = UserLombok.builder()
                .name(new Faker().funnyName().name())
                .gender("male")
                .email(new Faker().internet().emailAddress())
                .status("active")
                .build();
        return payload.getJson();
    }
}