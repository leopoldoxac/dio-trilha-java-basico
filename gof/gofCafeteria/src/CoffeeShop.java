import java.util.ArrayList;
import java.util.List;

// ======= Singleton Pattern =======
// Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
class CoffeeMachine {
    private static CoffeeMachine instance;
    
    private CoffeeMachine() {}
    
    public static CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }
    
    public void brewCoffee() {
        System.out.println("Brewing coffee...");
    }
}

// ======= Factory Method Pattern =======
// Define uma interface para criar um objeto, mas deixa as subclasses decidirem qual classe instanciar.
interface Coffee {
    void prepare();
}

class Espresso implements Coffee {
    public void prepare() {
        System.out.println("Preparing espresso");
    }
}

class Latte implements Coffee {
    public void prepare() {
        System.out.println("Preparing latte");
    }
}

class CoffeeFactory {
    public Coffee createCoffee(String type) {
        if ("espresso".equalsIgnoreCase(type)) {
            return new Espresso();
        } else if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        }
        throw new IllegalArgumentException("Unknown coffee type");
    }
}

// ======= Observer Pattern =======
// Define uma dependência um-para-muitos entre objetos para que quando um objeto mude de estado, 
// todos os seus dependentes sejam notificados e atualizados automaticamente.
interface OrderObserver {
    void update(String orderStatus);
}

class Customer implements OrderObserver {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void update(String orderStatus) {
        System.out.println(name + " received update: " + orderStatus);
    }
}

class OrderSubject {
    private List<OrderObserver> observers = new ArrayList<>();
    
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    
    public void notifyObservers(String status) {
        for (OrderObserver observer : observers) {
            observer.update(status);
        }
    }
}

// ======= Strategy Pattern =======
// Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " in Cash");
    }
}

// ======= Decorator Pattern =======
// Anexa responsabilidades adicionais a um objeto dinamicamente. 
// Os decoradores fornecem uma alternativa flexível à subclasse para estender a funcionalidade.
interface CoffeeDecorator extends Coffee {
    Coffee getBaseCoffee();
}

class MilkDecorator implements CoffeeDecorator {
    private Coffee baseCoffee;
    
    public MilkDecorator(Coffee coffee) {
        this.baseCoffee = coffee;
    }
    
    public void prepare() {
        baseCoffee.prepare();
        System.out.println("Adding milk");
    }
    
    public Coffee getBaseCoffee() {
        return baseCoffee;
    }
}

class SugarDecorator implements CoffeeDecorator {
    private Coffee baseCoffee;
    
    public SugarDecorator(Coffee coffee) {
        this.baseCoffee = coffee;
    }
    
    public void prepare() {
        baseCoffee.prepare();
        System.out.println("Adding sugar");
    }
    
    public Coffee getBaseCoffee() {
        return baseCoffee;
    }
}

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