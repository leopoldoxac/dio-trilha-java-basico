package coffeeShop;

// ======= Decorator Pattern =======
// Anexa responsabilidades adicionais a um objeto dinamicamente. 
// Os decoradores fornecem uma alternativa flexível à subclasse para estender a funcionalidade.

public class SugarDecorator implements CoffeeDecorator {
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