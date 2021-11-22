package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/***************************************************************************************************
* Descrição: classe que realiza a execução dos testes e gera o relatório dos resultados
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
* * ************************************************************************************************/

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"html:target/report.html"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@Gorest")
public class RunTest {}