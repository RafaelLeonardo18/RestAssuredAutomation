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

import static org.junit.Assert.*;

/**************************************************************************************************
* Descrição: classe de implementação dos Steps da Feature 'Gorest.feature'
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
 * ************************************************************************************************/

public class GorestSteps extends ApiRequests {

    UserConstrutor userRequest = new UserConstrutor(), userResponse = new UserConstrutor();

    @Dado("que possuo gorest token valido")
    public void quePossuoGorestTokenValido(){
        super.token = PropertiesUtils.getProperties("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envioUmRequestDeCadastroDeUsuarioComDadosValidos() throws Exception {
        super.uri = PropertiesUtils.getProperties("uri_gorest");
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.body = ApiBodies.createRequestBody(super.uri);
        super.POST();
    }

    @E("o usuario deve ser criado corretamente")
    public void usuarioDeveSerCriadoCorretamente() {
        this.userRequest = new Gson().fromJson(super.body.toString(), UserConstrutor.class);
        this.userResponse = super.response.jsonPath().getObject("data", UserConstrutor.class);
        assertTrue("Os objetos não são iguais", this.userRequest.equals(this.userResponse));
    }

    @E("existe um usuário cadastrado na API")
    public void existeUmUsuárioCadastradoNaAPI() throws Exception{
        envioUmRequestDeCadastroDeUsuarioComDadosValidos();
    }

    @Quando("consultar este usuário")
    public void consultarEsteUsuário() {
        super.uri = PropertiesUtils.getProperties("uri_gorest") + "/" + super.response.jsonPath().get("data.id").toString();
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.body = new JSONObject();
        super.GET();
    }

    @E("os dados do usuário devem ser exibidos na resposta")
    public void osDadosDoUsuárioDevemSerExibidosNaResposta() {
        assertNotNull("A resposta não retornou conforme esperado", super.response.getBody());
    }

    @Entao("o status code do response deve ser {int}")
    public void statusCodeDoResponseDeveSer(Integer statusCode){
        assertTrue("Status Code diferente do esperado", super.response.statusCode() == statusCode);
    }

    @E("altero os dados do usuário")
    public void alteroOsDadosDoUsuário() {
        this.userRequest = new Gson().fromJson(super.body.toString(), UserConstrutor.class);
        super.body = ApiBodies.createRequestBody(super.uri);
    }

    @Quando("envio request para editar o usuário")
    public void envioRequestParaEditarOUsuário() {
        super.uri = PropertiesUtils.getProperties("uri_gorest") + "/" + super.response.jsonPath().get("data.id").toString();
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.PUT();
    }

    @E("o usuário deve ser alterado com sucesso")
    public void oUsuárioDeveSerAlteradoComSucesso() {
        this.userResponse = super.response.jsonPath().getObject("data", UserConstrutor.class);
        assertFalse("O usuário não foi alterado", userRequest.equals(userResponse));
    }

    @E("altero algum dado do usuário")
    public void alteroAlgumDadoDoUsuário() {
        this.userRequest = new Gson().fromJson(super.body.toString(), UserConstrutor.class);
        this.body = new JSONObject("{\"gender\": \"female\"}");
    }

    @Quando("envio request para editar parcialmente o usuário")
    public void envioRequestParaEditarParcialmenteOUsuário() {
        super.uri = PropertiesUtils.getProperties("uri_gorest") + "/" + super.response.jsonPath().get("data.id").toString();
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.PATCH();
    }

    @Quando("envio request para excluir este usuário")
    public void envioRequestParaExcluirEsteUsuário() {
        super.uri = PropertiesUtils.getProperties("uri_gorest") + "/" + super.response.jsonPath().get("data.id").toString();
        super.headers = ApiHeaders.createRequestHeaders(super.uri, super.token);
        super.body = new JSONObject();
        super.DELETE();
    }

    @Entao("o usuário deve ser excluido com sucesso")
    public void oUsuárioDeveSerExcluidoComSucesso() {
        super.GET();
        assertEquals(404, response.getStatusCode());
    }
}