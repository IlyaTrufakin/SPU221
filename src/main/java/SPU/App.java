package SPU;

import SPU.basics.Arrays;
import SPU.basics.Console;
import SPU.basics.Vars;
import SPU.oop.OopDemo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
 //       new Vars().run();
 //       new Arrays().run();
 //       new Console().run();
        new OopDemo().run();

       // Gson gson = new Gson();
        //JsonReader jsonReader = new JsonReader(new StringReader("drgsd"));
       // JsonElement jsonElement = gson.fromJson("name", JsonElement.class);
       // jsonElement.getAsJsonObject().get("name").getAsString();
       // System.out.println(jsonElement);

     //   Gson gson = new Gson();
      //  JsonElement json = gson.fromJson("{\"name\":\"Name\"}", JsonElement.class);
      //  System.out.println(
       //         json.getAsJsonObject().get("name").getAsString());

    }

}
