import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseCalculatorTest {

    private final PurchaseCalculator calculator = new PurchaseCalculator();

    @Test
    void testCalculateSubtotal() {
        // Un producto con precio de $100 y cantidad de 3
        assertEquals(300.0, calculator.calculateSubtotal(100.0, 3), 0.001);
        // Un producto con cantidad de 1
        assertEquals(50.0, calculator.calculateSubtotal(50.0, 1), 0.001);
        // Un producto con precio de $0
        assertEquals(0.0, calculator.calculateSubtotal(0.0, 5), 0.001);
    }

    @Test
    void testIsValidPurchase() {
        // Precio y cantidad positivos
        assertTrue(calculator.isValidPurchase(100.0, 2));
        // Precio igual a cero
        assertFalse(calculator.isValidPurchase(0.0, 5));
        // Cantidad igual a cero
        assertFalse(calculator.isValidPurchase(100.0, 0));
        // Precio negativo
        assertFalse(calculator.isValidPurchase(-50.0, 2));
    }

    @Test
    void testCalculateDiscount() {
        // Subtotal inferior a $1,000
        assertEquals(0.0, calculator.calculateDiscount(500.0), 0.001);
        // Subtotal exactamente igual a $1,000
        assertEquals(100.0, calculator.calculateDiscount(1000.0), 0.001);
        // Subtotal superior a $1,000
        assertEquals(150.0, calculator.calculateDiscount(1500.0), 0.001);
    }

    @Test
    void testCalculateFinalPrice() {
        // Compra sin descuento
        assertEquals(900.0, calculator.calculateFinalPrice(900.0), 0.001);
        // Compra cuyo subtotal es exactamente $1,000
        assertEquals(900.0, calculator.calculateFinalPrice(1000.0), 0.001);
        // Compra con descuento
        assertEquals(1350.0, calculator.calculateFinalPrice(1500.0), 0.001);
    }
}