package steps;

import api.ApiQueryParams;
import api.ApiRequests;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import utils.PropertiesUtils;

import static org.junit.Assert.*;

public class CorreioSteps extends ApiRequests {

    @Dado("que possuo dados válidos para consulta na API Correios")
    public void quePossuoDadosVálidosParaConsultaNaAPICorreios() {
        super.uri = PropertiesUtils.getProperties("uri_correios");
        super.queryParams = ApiQueryParams.createRequestQueryParams();
    }

    @Quando("envio um request de consulta para a API Correios")
    public void envioUmRequestDeConsulta() {
        super.GET();
    }

    @Entao("o status code deve ser {int}")
    public void oStatusCodeDeveSer(int statusCode) {
        assertTrue("O status code é diferente do esperado", super.response.getStatusCode() == statusCode);
    }

    @E("o valor do frete deve ser calculado")
    public void oValorDoFreteDeveSerCalculado() {
        assertNotNull(super.response.xmlPath().get("Servicos").toString());
    }

    @E("o valor do frete deve ser igual a {string}")
    public void oValorDoFreteDeveSerIgualA(String value) {
        assertEquals(value, super.response.xmlPath().getString("Servicos.cServico.Valor"));
    }

    @Quando("envio um request de consulta para a API Correios usando DataTable")
    public void envioUmRequestDeConsultaParaAAPICorreiosUsandoDataTable(DataTable dataTable) {
        dataTable.asMaps().get(0).entrySet().forEach(
                information -> super.queryParams.put(information.getKey(), information.getValue()));
        super.GET();
    }

    @Quando("envio um request de consulta com cep origem {string} e cep de destino {string}")
    public void envioUmRequestDeConsultaComCepOrigemECepDeDestino(String origin, String destiny) {
        super.queryParams.put("sCepOrigem", origin);
        super.queryParams.put("sCepDestino", destiny);
        super.GET();
    }
}