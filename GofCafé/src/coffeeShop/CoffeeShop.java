package coffeeShop;
import java.util.ArrayList;
import java.util.List;

// Classe principal para demonstrar o uso dos padrões
public class CoffeeShop {
    public static void main(String[] args) {
        // Usando Singleton
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.brewCoffee();
        
        // Usando Factory Method
        CoffeeFactory factory = new CoffeeFactory();
        Coffee espresso = factory.createCoffee("espresso");
        Coffee latte = factory.createCoffee("latte");
        
        // Usando Decorator
        Coffee fancyEspresso = new SugarDecorator(new MilkDecorator(espresso));
        fancyEspresso.prepare();
        
        // Usando Observer
        OrderSubject orderSubject = new OrderSubject();
        orderSubject.addObserver(new Customer("Alice"));
        orderSubject.addObserver(new Customer("Bob"));
        orderSubject.notifyObservers("Your coffee is ready!");
        
        // Usando Strategy
        PaymentStrategy creditCardStrategy = new CreditCardPayment();
        PaymentStrategy cashStrategy = new CashPayment();
        
        creditCardStrategy.pay(100);
        cashStrategy.pay(50);
    }
}