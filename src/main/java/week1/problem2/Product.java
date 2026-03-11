package week1.problem2;

public class Product {

    private String productId;
    private int stock;

    public Product(String productId, int stock) {
        this.productId = productId;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock() {
        stock--;
    }
}