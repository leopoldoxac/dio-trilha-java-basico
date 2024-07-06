package coffeeShop;


// ======= Strategy Pattern =======
// Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.


public class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}