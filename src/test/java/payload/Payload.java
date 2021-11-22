package payload;

import io.cucumber.messages.internal.com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.json.XML;

@NoArgsConstructor
public abstract class Payload {

    public JSONObject getJson(){
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXML(){
        return XML.toString(this.getJson());
    }

}
