//package OOP;
////An e-commerce application supports three shipping methods:
////        - Standard shipping: ₹50 base cost.
////- Express shipping: ₹100 base cost.
////- International shipping: ₹500 base cost.
////Each shipping method calculates its own cost based on the order weight in kilograms.
////Requirements
////1. Define a ShippingStrategy interface with a method calculateCost(double weightKg).
////        2. Implement StandardShipping, ExpressShipping, and InternationalShipping.
////3. For this exercise, use these formulas:
////        - Standard: \(50 + 10 \times weightKg\)
////        - Express: \(100 + 20 \times weightKg\)
////        - International: \(500 + 100 \times weightKg\)
////        4. Create a ShippingService that accepts a ShippingStrategy through its constructor.
////        5. Add a method to the service that returns the shipping cost for a given weight.
////6. Demonstrate all three methods using the same service implementation.
////7. Reject zero, negative, NaN, and infinite weights.
////Constraints
////- Use Java.
////        - Do not use if-else or switch to select a shipping method inside ShippingService.
////- Do not use static utility methods to calculate shipping costs.
////        - Include a main() method.
//interface ShippingStrategy{
//    double calculateCost(double weightKg);
//}
//class StandardShipping implements ShippingStrategy{
//
//    @Override
//    public double calculateCost(double weightKg) {
//        return 50 + (10 * weightKg);
//    }
//}
//class ExpressShipping implements ShippingStrategy{
//    @Override
//    public double calculateCost(double weightKg) {
//        return 100 + (20 * weightKg);
//    }
//}
//class InternationalShipping implements ShippingStrategy{
//    @Override
//    public double calculateCost(double weightKg) {
//        return 500 + (100 * weightKg);
//    }
//}
//class ShippingService{
//    ShippingStrategy shippingStrategy;
//    public ShippingService(ShippingStrategy shippingStrategy){
//        this.shippingStrategy=shippingStrategy;
//    }
//
//    double calculateShippingCost(double weightKg){
//        if(Double.isNaN(weightKg) || Double.isInfinite(weightKg) || weightKg<0) throw new IllegalArgumentException();
//        return  shippingStrategy.calculateCost(weightKg);
//    }
//
//}
//public class ShoppingCardMain {
//    public static void main(String[] args) {
//        ShippingStrategy standardShipping = new StandardShipping();
//        ShippingStrategy expressShipping = new ExpressShipping();
//        ShippingStrategy internationalShipping = new InternationalShipping();
//
//        ShippingService standardShippingService = new ShippingService(standardShipping);
//        ShippingService expressShippingService = new ShippingService(expressShipping);
//        ShippingService internationalShippingService = new ShippingService(internationalShipping);
//        System.out.println(standardShippingService.calculateShippingCost(10));
//        System.out.println(expressShippingService.calculateShippingCost(10));
//        System.out.println(internationalShippingService.calculateShippingCost(10));
//    }
//}
