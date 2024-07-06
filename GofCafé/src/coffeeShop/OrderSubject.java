package coffeeShop;
import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
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
