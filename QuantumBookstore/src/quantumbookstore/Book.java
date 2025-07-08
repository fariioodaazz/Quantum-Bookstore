package quantumbookstore;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String author;
    protected int year;
    protected double price;
    

    public Book(String ISBN, String title, String author, double price, int year) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getYear() { return year; }

    public abstract boolean isPurchasbale();
}
