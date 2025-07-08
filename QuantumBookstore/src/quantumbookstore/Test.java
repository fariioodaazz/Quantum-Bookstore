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
        System.out.println("Attempting to buy: E101 x1");
        try {
            String result = store.buyBook("E101", 1, "user@email.com", "");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Attempting to buy: P102 x2");
        try {
            String result = store.buyBook("P102", 2, "", "12B Barker St");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Attempting to buy: SC101 x1");
        try {
            String result = store.buyBook("SC101", 1, "", "");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Attempting to buy: P101 x20");
        try {
            String result = store.buyBook("P101", 20, "", "12B Barker St");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
