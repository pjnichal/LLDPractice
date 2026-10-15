package OOP;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private boolean discountApplied = false;
    private boolean isCheckedOut = false;

    public void addItem(String name, double price) {
        // Add item to cart, but reject if already checked out
        if (this.isCheckedOut) {
            System.out.println("Cannot modify a checked-out cart");
            return;
        }
        items.putIfAbsent(name, price);
    }

    public boolean applyDiscount(String code) {
        // If code is "SAVE10" and no discount applied yet and not checked out,
        // mark discount as applied and return true. Otherwise return false.
        if (code.equals("SAVE10") &&  !this.discountApplied && !this.isCheckedOut) {
            this.discountApplied = true;
            return true;
        }
        return false;
    }

    public double getTotal() {
        // Sum all item prices. If discount was applied, subtract 10%.
        Double total = 0d;
        for (Double priceOfItem : items.values()) {
            total += priceOfItem;
        }
        if (total > 0 && this.discountApplied) {
            Double discountedPrice = total - (total * .10);
            return (double) Math.round(discountedPrice * 100.0) /100;

        }
        return (double) Math.round(total * 100.0) /100;
    }

    public void checkout() {
        // Mark cart as checked out (only if it has items and isn't already checked out)
        if (!items.isEmpty() && !isCheckedOut) {
            this.isCheckedOut = true;
        }
    }
}


public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("Total: $" + cart.getTotal());            // 1029.98

        System.out.println("Discount: " + cart.applyDiscount("SAVE10")); // true
        System.out.println("Total: $" + cart.getTotal());            // 926.98

        System.out.println("Discount: " + cart.applyDiscount("SAVE10")); // false (already applied)

        cart.checkout();
        cart.addItem("Keyboard", 79.99);  // Should be rejected
        System.out.println("Total: $" + cart.getTotal());            // 926.98 (unchanged)
    }
}

