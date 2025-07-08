package quantumbookstore;
import java.util.List;


public class Test {
     public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();
        
        store.addBook(new PaperBook("P101", "Java", "Joe", 49.47, 2018, 15));
        store.addBook(new EBook("E101", "C++", "Robert", 29.59, 2021, "PDF"));
        store.addBook(new ShowcaseBook("SC101", "Python", "Ali", 0.0, 2012));
        store.addBook(new PaperBook("P102", "Data Analysis", "Ahmed", 39.21, 2025, 8));
        
        store.inventory();
        System.out.println();
        
        
        System.out.println("--- Testing removeOutdatedBooks() ---");
        List<Book> outdated = store.removeOutdatedBooks(5); 
        System.out.println("Removed books count: " + outdated.size());
        store.inventory();
        System.out.println();
        

        System.out.println("--- Testing buyBook() ---");
        testPurchase(store, "E101", 1, "user@email.com", "");      
        testPurchase(store, "P102", 2, "", "12B Barker St");         
        testPurchase(store, "SC101", 1, "", "");                    
        testPurchase(store, "P101", 20, "", "12B Barker St");               
    }
    
    private static void testPurchase(QuantumBookstore store, String ISBN, int quantity, String email, String address) {
        try {
            System.out.println("Attempting to buy: " + ISBN + " x" + quantity);
            String result = store.buyBook(ISBN, quantity, email, address);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}
