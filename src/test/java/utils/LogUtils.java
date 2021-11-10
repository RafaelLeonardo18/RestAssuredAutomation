package utils;

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
