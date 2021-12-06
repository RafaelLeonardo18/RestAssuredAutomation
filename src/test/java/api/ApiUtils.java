package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**************************************************************************************************
* Descrição: classe que irá representar os dados da requisição e resposta
* Autor: Rafael Leonardo de Lima
* Data de criação: 16/11/2021
* *************************************************************************************************/

public class ApiUtils extends LogUtils {

    protected Response response;
    protected JSONObject body;
    protected String uri;
    protected Map<String, String> headers = new HashMap<String, String>();
    protected Map<String, String> queryParams = new HashMap<String, String>();
    protected Map<String, String> pathParams = new HashMap<String, String>();
    protected String token;

    //Método para exibir os logs da requisição e resposta
    public void log(String verbose){
        super.logInfo("******* Dados enviados no request *******");
        super.logInfo(verbose + " " + uri);
        super.logInfo("Body: \n" + body);
        super.logInfo("Headers: " + headers);
        super.logInfo("Params: " + queryParams);
        super.logInfo("******* Dados recebidos do response *******");
        super.logInfo("Status Code: " + response.statusCode());
        super.logInfo("Payload recebido: \n" + response.asPrettyString());
        super.logInfo("Tempo de resposta: " + response.timeIn(TimeUnit.MILLISECONDS));
    }

}