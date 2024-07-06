package coffeeShop;

// ======= Decorator Pattern =======
// Anexa responsabilidades adicionais a um objeto dinamicamente. 
// Os decoradores fornecem uma alternativa flexível à subclasse para estender a funcionalidade.

public class MilkDecorator implements CoffeeDecorator {
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