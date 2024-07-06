package coffeeShop;
// ======= Singleton Pattern =======
// Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
public class CoffeeMachine {
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
