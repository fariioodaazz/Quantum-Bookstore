package quantumbookstore;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class QuantumBookstore {
    
    private Map<String, Book> inventory = new HashMap<>();
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    
    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Added book : " + book.getTitle());
    }
    
    public List<Book> removeOutdatedBooks(int maxYears) {
        List<Book> outdatedBooks = inventory.values().stream()
                .filter(book -> (currentYear - book.getYear()) > maxYears)
                .collect(Collectors.toList());

        outdatedBooks.forEach(book -> inventory.remove(book.getISBN()));
        
        if (!outdatedBooks.isEmpty()) {
            System.out.println("Removed " + outdatedBooks.size() + " outdated books");
        }
        
        return outdatedBooks;
    }
    
    public String buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found in inventory");
        }
        
        if (book instanceof Purchasable) {
            return ((Purchasable)book).buy(isbn, quantity, email, address);
        } else {
            throw new IllegalArgumentException("This book is not for sale");
        }
    }
    
    public void inventory() {  
        System.out.println("Current Inventory:");
        inventory.values().forEach(book -> 
            System.out.println("- " + book.getTitle() + 
                             " (" + book.getISBN() + ") " + 
                             (book instanceof PaperBook ? "[Stock: " + ((PaperBook)book).getStock() + "]" : "") +
                             (book instanceof EBook ? "[Format: " + ((EBook)book).getFileType() + "]" : "") +
                             (book instanceof ShowcaseBook ? "[DEMO]" : ""))
        );
    }
    
    
}
