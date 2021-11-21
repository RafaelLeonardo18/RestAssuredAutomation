package steps;

import api.ApiHeaders;
import api.ApiRequests;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONObject;
import user.UserLombok;
import user.UserRecord;
import utils.PropertiesUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

/**************************************************************************************************
* Descrição: classe de implementação dos Steps da Feature 'Gorest.feature'
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
 * ************************************************************************************************/

public class GorestSteps extends ApiRequests {

    PropertiesUtils properties = new PropertiesUtils();

    @Dado("que possuo gorest token valido")
    public void quePossuoGorestTokenValido(){
        super.token = properties.getProperties("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envioUmRequestDeCadastroDeUsuarioComDadosValidos() throws Exception {
        super.uri = properties.getProperties("uri_gorest");
        super.headers = ApiHeaders.gorestHeaders(token);
//        Map<String, String> keyValues = new HashMap<String, String>();
//        keyValues.put("email", new Faker().internet().emailAddress());
//        keyValues.put("name", new Faker().funnyName().name());
//        super.body = JsonUtils.updateMultiJsonValues(JsonUtils.parseJsonFile("create_user"), keyValues);
        super.body = new UserRecord(new Faker().funnyName().name(), "male", new Faker().internet().emailAddress(), "active").getJson();
        super.POST();
    }

    @Entao("o usuario deve ser criado corretamente")
    public void usuarioDeveSerCriadoCorretamente() {
        assertAll("Validação do body",
            () -> assertEquals("Nome deve ser igual ao da requisição", response.jsonPath().getString("data.name"), super.body.get("name")),
            () -> assertEquals("Gênero deve ser igual ao da requisição", response.jsonPath().getString("data.gender"), super.body.get("gender")),
            () -> assertEquals("Email deve ser igual ao da requisição", response.jsonPath().getString("data.email"), super.body.get("email")),
            () -> assertEquals("Status deve ser igual ao da requisição", response.jsonPath().getString("data.status"), super.body.get("status"))
        );
    }

    @E("o status code do response deve ser {int}")
    public void statusCodeDoResponseDeveSer(Integer statusCode){
        assertTrue("Status Code diferente do esperado", response.statusCode() == statusCode);
    }

}