package SPU.oop;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Library {
    private final List<Literature> funds;
    public Library() {
    String[] jsons = {
            "{\"title\":\"Art of Programming\", \"author\":\"D. Knuth\" }",
            "{\"title\":\"Daily Mail\", \"date\":\"13.07.2024\" }",
            "{\"title\":\"Quantum Mechanics\", \"number\":\"77\" }",
            "{\"title\":\"Martin Eden\", \"author\":\"J. London\" }",
            "{\"title\":\"Daily Telegraph\", \"date\":\"22.01.1978\" }",
            "{\"title\":\"Argc & Argv\", \"number\":\"43\" }"
    };

        Gson gson = new Gson();
         funds = new ArrayList<>();

        for (String json : jsons) {
            try {
                funds.add(Literature.fromJson(
                        gson.fromJson(json, JsonElement.class).getAsJsonObject()
                ));
            }
            catch (ParseException e) {
                System.err.println( e.getMessage() );
            }
        }
    }

    public void printFunds(){
        for(Literature fund : funds){
            System.out.println(fund.getCard());
        }
    }

    public void printCopyable(){
        System.out.println("Copyable funds") ;

        for(Literature fund : funds){
            if(fund instanceof Copyable){
                System.out.println(fund.getCard());
            }
        }
    }

    public void printPeriodic(){
        System.out.println("\nPeriodic funds") ;
        for(Literature fund : funds){
            if(fund.getClass().isAnnotationPresent(Periodic.class)){
                System.out.println(fund.getCard());
            }
        }
    }

}
