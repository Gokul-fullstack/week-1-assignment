package week1.problem2;

import java.util.*;

public class InventoryManager {

    private HashMap<String, Product> inventory = new HashMap<>();
    private HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int stock) {
        inventory.put(productId, new Product(productId, stock));
        waitingList.put(productId, new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId, int userId) {

        Product product = inventory.get(productId);

        if (product == null) {
            return "Product not found";
        }

        if (product.getStock() > 0) {

            product.decreaseStock();

            return "Success: User " + userId +
                    " purchased " + productId +
                    " (Remaining stock: " + product.getStock() + ")";
        }

        Queue<Integer> queue = waitingList.get(productId);
        queue.add(userId);

        return "Stock finished. User " + userId +
                " added to waiting list position #" + queue.size();
    }

    public int checkStock(String productId) {

        Product product = inventory.get(productId);

        if (product == null) return -1;

        return product.getStock();
    }
}