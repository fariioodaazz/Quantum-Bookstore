package quantumbookstore;


public class ShowcaseBook extends Book {
    
    public ShowcaseBook(String ISBN, String title, String author, double price, int year) {
        super(ISBN, title, author, price ,year);
    }
    
    @Override
    public boolean isPurchasbale(){
        return false;
    }
}
