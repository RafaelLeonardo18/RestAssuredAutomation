package utils;

/**************************************************************************************************
* Descrição: classe utilitária para gerar os logs dos testes
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
 * ************************************************************************************************/

public class LogUtils {

    public void logInfo(String text){
        if (!text.contains("{}")){
            ScenarioUtils.addText(text);
        }
    }

    public void logError(String errorText){
        if (!errorText.contains("{}")){
            ScenarioUtils.addText(errorText);
        }
    }

}
