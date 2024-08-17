package SPU.oop;

import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Periodic
public class Newspaper extends Literature{
    private static final SimpleDateFormat dottedFormat =
            new SimpleDateFormat("dd.MM.yyyy");
    private Date date;

    public Newspaper(String title, Date date) throws ParseException {
        this.setDate (date);
        super.setTitle (title);
    }

    public Newspaper(String title, String dottedDate) throws ParseException {
        this.setDate ( dottedDate);
        super.setTitle (title);
    }

    public String getDate() {
        return dottedFormat.format(date);
    }

    public void setDate(String dottedDate) throws ParseException {
        this.date = dottedFormat.parse(dottedDate);
    }

    public void setDate(Date date) throws ParseException {
        this.date = date;
    }

    @Override
    public String getCard() {
        return String.format(
                "Newspaper: '%s' (%s)",
                this.getDate(),
                super.getTitle()
        );
    }


    public static Literature fromJson(JsonObject jsonObject) throws ParseException {

        return new Newspaper(
                jsonObject.get("title").getAsString(),
                jsonObject.get("date").getAsString()
        );
    }
}
