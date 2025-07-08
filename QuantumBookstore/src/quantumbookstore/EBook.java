package quantumbookstore;


public class EBook extends Book implements Purchasable {
    
    private String fileType;
    
    public EBook(String ISBN, String title, String author, double price, int year , String fileType){
        super(ISBN, title, author, price, year);
        this.fileType = fileType;
    }
    
    public String getFileType() { return fileType; }
    
    @Override
    public boolean isPurchasbale(){
        return true;
    }
    
    @Override
    public String buy(String ISBN, int quantity, String email, String address){
        if (quantity > 1) {
            throw new IllegalArgumentException("Only one eBook per purchase allowed");
        }
        MailService.send(email, title + "." + fileType);
        return "Paid Amount: " + price;
    }
    
}
