package api;

import static io.restassured.RestAssured.given;

/**************************************************************************************************
* Descrição: classe de implementação das requisições HTTP utilizadas na automação
* Autor: Rafael Leonardo de Lima
* Data de criação: 16/11/2021
* **************************************************************************************************/

public class ApiRequests extends ApiUtils implements ApiVerbose {

    @Override
    public void GET() {
        response = given().relaxedHTTPSValidation().params(params).headers(headers).get(uri);
        super.log("GET");
    }

    @Override
    public void POST() {
        response = given().relaxedHTTPSValidation().params(params).headers(headers).body(body.toString()).post(uri);
        super.log("POST");
    }

    @Override
    public void PUT() {
        response = given().relaxedHTTPSValidation().params(params).headers(headers).body(body.toString()).put(uri);
        super.log("PUT");
    }

    @Override
    public void PATCH() {
        response = given().relaxedHTTPSValidation().params(params).headers(headers).body(body.toString()).patch(uri);
        super.log("PATCH");
    }

    @Override
    public void DELETE() {
        response = given().relaxedHTTPSValidation().params(params).headers(headers).delete(uri);
        super.log("DELETE");
    }

}