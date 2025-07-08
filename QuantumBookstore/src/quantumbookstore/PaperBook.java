package quantumbookstore;

public class PaperBook extends Book implements Purchasable {
    
    private int stock;
    
    public PaperBook(String ISBN, String title, String author, double price, int year , int stock){
        super(ISBN, title, author, price, year);
        this.stock = stock;
    }
    
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public boolean isPurchasbale(){
        return true;
    }
    
    @Override
    public String buy(String ISBN, int quantity, String email, String address){
        if (stock < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        stock -= quantity;
        ShippingService.ship(title, address);
        return "Paid Amount: " + (price * quantity);
    }
}
