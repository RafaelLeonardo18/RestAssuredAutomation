package api;

import java.util.HashMap;
import java.util.Map;

/**************************************************************************************************
* Descrição: classe responsável por criar os Headers de cada requisição
* Autor: Rafael Leonardo de Lima
* Data de criação: 16/11/2021
 * ************************************************************************************************/

public class ApiHeaders {

    public static Map<String, String> gorestHeaders(String token){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        headers.put("Authorization", token);
        return headers;
    }
}
