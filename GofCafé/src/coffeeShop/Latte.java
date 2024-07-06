// ======= Factory Method Pattern =======
// Define uma interface para criar um objeto, mas deixa as subclasses decidirem qual classe instanciar.
package coffeeShop;

class Latte implements Coffee {
    public void prepare() {
        System.out.println("Preparing latte");
    }
}