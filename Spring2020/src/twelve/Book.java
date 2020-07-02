package twelve;

public class Book {
    private String title;
    private String author;
    private double width;

    public Book(String title, String author, double width) {
        this.title = title;
        this.author = author;
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getWidth() {
        return width;
    }
}
