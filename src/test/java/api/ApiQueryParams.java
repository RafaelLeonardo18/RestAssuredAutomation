package api;

import java.util.HashMap;
import java.util.Map;

public class ApiQueryParams {

    public static Map<String, String> createRequestQueryParams() {
        return correioQueryParams();
    }

    private static Map<String, String> correioQueryParams() {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("StrRetorno", "xml");
        queryParams.put("nCdServico", "04510");
        queryParams.put("sCepOrigem", "74371520");
        queryParams.put("sCepDestino", "13175613");
        queryParams.put("nVlPeso", "1.00");
        queryParams.put("nVlComprimento", "36.00");
        queryParams.put("nVlAltura", "18.00");
        queryParams.put("nVlLargura", "12.00");
        return queryParams;
    }
}