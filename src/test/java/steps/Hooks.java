package steps;

import api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.json.JSONObject;
import utils.ScenarioUtils;

/**************************************************************************************************
* Descrição: classe que prepara a execução dos cenários
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
 * ************************************************************************************************/

public class Hooks extends ApiUtils {

    @Before
    public void setup(Scenario scenario){
        ScenarioUtils.add(scenario);
    }

    @After
    public void tearDown(){
        ScenarioUtils.remove();
        super.uri = new String();
        super.token = new String();
        super.body = new JSONObject();
        super.headers.clear();
        super.queryParams.clear();
        super.pathParams.clear();
    }
}