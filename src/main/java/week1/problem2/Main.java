package week1.problem2;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct("IPHONE15_256GB", 3);

        System.out.println("Stock: " +
                manager.checkStock("IPHONE15_256GB"));

        System.out.println(manager.purchaseItem("IPHONE15_256GB", 101));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 102));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 103));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 104));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 105));
    }
}
