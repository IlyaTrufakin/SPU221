package SPU.oop;

import com.google.gson.JsonObject;

public class Book extends Literature implements Copyable{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() { return ""; }

    @Override
    public String getCard() {
        return String.format(
                "Book: %s '%s'",
                this.getAuthor(),
                super.getTitle()
        );
    }

@FromJsonFactory
    public static Literature FromJsonFactory(JsonObject jsonObject) {
        Book book = new Book();
        book.setTitle(jsonObject.get("title").getAsString());
        book.setAuthor(jsonObject.get("author").getAsString());
        return book;
    }
}
