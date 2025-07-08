package quantumbookstore;

public interface Purchasable {
    String buy(String ISBN, int quantity, String email, String address);
}
