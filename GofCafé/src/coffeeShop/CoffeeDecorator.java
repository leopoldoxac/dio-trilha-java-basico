package coffeeShop;

// ======= Decorator Pattern =======
// Anexa responsabilidades adicionais a um objeto dinamicamente. 
// Os decoradores fornecem uma alternativa flexível à subclasse para estender a funcionalidade.
public interface CoffeeDecorator extends Coffee {
    Coffee getBaseCoffee();
}