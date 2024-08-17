package SPU.oop;

import com.google.gson.JsonObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

public abstract class Literature {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String getCard();

    public static Literature fromJson(JsonObject jsonObject) throws ParseException {
        if (jsonObject.has("author")) {
            // ищем метод помеченный фабрика
            for (Method method: Book.class.getDeclaredMethods())
            {
                if ( method.isAnnotationPresent(FromJsonFactory.class) ) {
                    method.setAccessible(true);
                    try{
                        return (Literature) method.invoke(null, jsonObject);
                    } catch (InvocationTargetException | IllegalAccessException ex) {
                        System.err.println( ex.getMessage() );
                    }


                    //данный метод имеет соответств аннотацию

                }
            }
            throw new ParseException("@FromJsonFactory Not found", 0);
          //  return Book.fromJson(jsonObject);
        }
        else if (jsonObject.has("date")) {
            return Newspaper.fromJson(jsonObject);
        }
        else if (jsonObject.has("number")) {
            return Journal.fromJson(jsonObject);
        }
        else {
            throw new ParseException("No this type literature found", 0);
        }
    }


}
