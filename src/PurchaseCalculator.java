public class PurchaseCalculator {

    public double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    public boolean isValidPurchase(double price, int quantity) {
        return price > 0 && quantity > 0;
    }

    public double calculateDiscount(double subtotal) {
        if (subtotal >= 1000.0) {
            return subtotal * 0.10;
        }
        return 0.0;
    }

    public double calculateFinalPrice(double subtotal) {
        return subtotal - calculateDiscount(subtotal);
    }
}