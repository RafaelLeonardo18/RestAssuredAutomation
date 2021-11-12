package api;

import utils.PropertiesUtils;

public class ApiHeaders extends ApiUtils{

    PropertiesUtils properties = new PropertiesUtils();

    public void gorestHeaders(){
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization", token);
    }
}
