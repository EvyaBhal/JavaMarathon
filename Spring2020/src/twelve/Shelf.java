package twelve;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Book> books;

    public Shelf() {
        books = new ArrayList<>();
    }

    public boolean add(Book b) {
        return books.add(b);
    }

    public List<Book> getBooks() {
        return books;
    }
}
