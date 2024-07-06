package coffeeShop;

// ======= Strategy Pattern =======
// Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.

public class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " in Cash");
    }
}