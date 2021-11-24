package steps;

import api.ApiBodies;
import api.ApiHeaders;
import api.ApiRequests;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import user.UserConstrutor;
import utils.PropertiesUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.body = ApiBodies.createRequestBody(super.uri);
        super.POST();
    }

    @Entao("o usuario deve ser criado corretamente")
    public void usuarioDeveSerCriadoCorretamente() {
        UserConstrutor userRequest = new Gson().fromJson(super.body.toString(), UserConstrutor.class);
        UserConstrutor userResponse = response.jsonPath().getObject("data", UserConstrutor.class);
        assertTrue("Os objetos não são iguais", userRequest.equals(userResponse));
    }

    @E("existe um usuário cadastrado na API")
    public void existeUmUsuárioCadastradoNaAPI() throws Exception{
        envioUmRequestDeCadastroDeUsuarioComDadosValidos();
    }

    @Quando("consultar este usuário")
    public void consultarEsteUsuário() {
        super.uri = properties.getProperties("uri_gorest") + "/" + response.jsonPath().get("data.id").toString();
        super.headers = ApiHeaders.createRequestHeaders(super.uri, token);
        super.body = new JSONObject();
        super.GET();
    }

    @Entao("os dados do usuário devem ser exibidos na resposta")
    public void osDadosDoUsuárioDevemSerExibidosNaResposta() {
        assertNotNull("A resposta não retornou conforme esperado", response.getBody());
    }

    @E("o status code do response deve ser {int}")
    public void statusCodeDoResponseDeveSer(Integer statusCode){
        assertTrue("Status Code diferente do esperado", response.statusCode() == statusCode);
    }


}