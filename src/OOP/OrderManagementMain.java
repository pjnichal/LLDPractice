package OOP;

interface ShippingStrategy{
    double calculateCost(double weightKg);
}
class StandardShipping implements ShippingStrategy{

    @Override
    public double calculateCost(double weightKg) {
        return 50 + (10 * weightKg);
    }
}
class ExpressShipping implements ShippingStrategy{
    @Override
    public double calculateCost(double weightKg) {
        return 100 + (20 * weightKg);
    }
}
class InternationalShipping implements ShippingStrategy{
    @Override
    public double calculateCost(double weightKg) {
        return 500 + (100 * weightKg);
    }
}
class ShippingService{
    ShippingStrategy shippingStrategy;
    public ShippingService(ShippingStrategy shippingStrategy){
        this.shippingStrategy=shippingStrategy;
    }

    double calculateShippingCost(double weightKg){
        if(!Double.isFinite(weightKg) || weightKg<=0) throw new IllegalArgumentException();
        return  shippingStrategy.calculateCost(weightKg);
    }

}
class Order{
    private double price;
    private int quantity;
    private double weight;
    public Order(double price,int quantity,double weight){
        if(!Double.isFinite(price) || price<0){
            throw  new IllegalArgumentException();
        }
        if(!Double.isFinite(quantity) || quantity<0) throw  new IllegalArgumentException();
        if(!Double.isFinite(weight) || weight<0) throw new IllegalArgumentException();
        this.price=price;
        this.quantity=quantity;
        this.weight=weight;
    }
    public double calculateTotal() {
        return this.price * this.quantity;
    }
    public double getWeight(){
        return weight;
    }
}
class OrderRepository{

    public void saveOrder(Order order) {
        System.out.println("Saving order to database");
    }

}
class OrderNotification{

    public void sendEmail(Order order) {
        System.out.println("Sending order confirmation");
    }
}

public class OrderManagementMain {
    public static void main(String[] args) {
        ShippingStrategy standardShipping = new StandardShipping();
        ShippingStrategy expressShipping = new ExpressShipping();
        ShippingStrategy internationalShipping = new InternationalShipping();
        Order order = new Order(10,2,2);
        ShippingService standardShippingService = new ShippingService(standardShipping);
        ShippingService expressShippingService = new ShippingService(expressShipping);
        ShippingService internationalShippingService = new ShippingService(internationalShipping);
        System.out.println(standardShippingService.calculateShippingCost(order.getWeight()));
        System.out.println(expressShippingService.calculateShippingCost(order.getWeight()));
        System.out.println(internationalShippingService.calculateShippingCost(order.getWeight()));
    }
}
