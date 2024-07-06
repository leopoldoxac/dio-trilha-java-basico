package coffeeShop;
public class CoffeeFactory {
    public Coffee createCoffee(String type) {
        if ("espresso".equalsIgnoreCase(type)) {
            return new Espresso();
        } else if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        }
        throw new IllegalArgumentException("Unknown coffee type");
    }
}