package coffeeShop;

public class Customer implements OrderObserver {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void update(String orderStatus) {
        System.out.println(name + " received update: " + orderStatus);
    }
}