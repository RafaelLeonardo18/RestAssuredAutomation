package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;

/**************************************************************************************************
* Descrição: classe que representa o payload de criação de usuário da API
* Autor: Rafael Leonardo de Lima
* Data de criação: 19/11/2021
 * ************************************************************************************************/

public record UserRecord (String name, String gender, String email, String status) {

    public JSONObject getJson(){
        return new JSONObject(new Gson().toJson(this));
    }

}