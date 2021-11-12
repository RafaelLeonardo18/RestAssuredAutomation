package steps;

import api.ApiUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.PropertiesUtils;

public class GorestSteps extends ApiUtils {

    PropertiesUtils properties = new PropertiesUtils();

    @Dado("que possuo gorest token valido")
    public void quePossuoGorestTokenValido(){
        token = properties.getProperties("token_gorest");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envioUmRequestDeCadastroDeUsuarioComDadosValidos(){

    }

    @Entao("o usuario deve ser criado corretamente")
    public void usuarioDeveSerCriadoCorretamente(){

    }

    @E("o status code do response deve ser {int}")
    public void statusCodeDoResponseDeveSer(Integer statusCode){

    }

}
