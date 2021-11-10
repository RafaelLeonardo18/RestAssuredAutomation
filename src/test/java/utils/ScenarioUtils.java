package utils;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioUtils {

    private static Map<Long, Scenario> repository = new HashMap<Long, Scenario>();

    //Atribui um ID ao cenário que será executado
    public static Long getId(){
        return Thread.currentThread().getId();
    }

    //Retorna o cenário com o respectivo ID
    public static Scenario get() {
        return repository.get(getId());
    }

    //Adiciona o texto que será exibido nos logs da execução
    public static void addText(String text){
        get().log(text);
    }

    //Adiciona o cenário ao conjunto de execuções
    public static void add(Scenario scenario){
        if (get() == null){
            repository.put(getId(), scenario);
        }
    }

    //Após a execução, remove o cenário da lista de execução
    public static void remove(){
        if (get() != null){
            repository.remove(getId());
        }
    }
}
