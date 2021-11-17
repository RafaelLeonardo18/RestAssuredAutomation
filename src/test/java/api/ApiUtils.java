package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiUtils extends LogUtils {

    protected static Response response;
    protected static JSONObject body;
    protected static String uri;
    protected static Map<String, String> headers = new HashMap<String, String>();
    protected static Map<String, String> params = new HashMap<String, String>();
    protected static String token;

    //Método para exibir os logs de todas as ações executadas
    public void log(String verbose){
        super.logInfo("******* Dados enviados no request *******");
        super.logInfo(verbose + " " + uri);
        super.logInfo("Body: \n" + body);
        super.logInfo("Headers: " + headers);
        super.logInfo("Params: " + params);
        super.logInfo("******* Dados recebidos do response *******");
        super.logInfo("Status Code: " + response.statusCode());
        super.logInfo("Payload recebido: \n" + response.asPrettyString());
        super.logInfo("Tempo de resposta: " + response.timeIn(TimeUnit.MILLISECONDS));
    }

}