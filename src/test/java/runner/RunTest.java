package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

/***************************************************************************************************
* Descrição: classe que realiza a execução dos testes e gera o relatório dos resultados
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
* * ************************************************************************************************/

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"html:target/cucumber-report/report.html", "json:target/cucumber-report/cucumber.json"},
        publish = true,
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@Gorest")

public class RunTest {

    @AfterClass
    public static void report() throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
    }
}