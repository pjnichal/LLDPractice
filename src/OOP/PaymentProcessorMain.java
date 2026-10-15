package OOP;

import java.util.Objects;

interface PaymentProcessor{
    public void pay(double amount);
}
interface Refundable {
    public void refund(double amount);
}
class PaymentValidator {
    public static void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be finite and greater than zero"
            );
        }
    }
}
class CardPaymentProcessor implements PaymentProcessor{

    @Override
    public void pay(double amount) {
        PaymentValidator.validateAmount(amount);
        System.out.println("Paid Using Card -> "+amount);
    }
}
class UpiPaymentProcessor implements PaymentProcessor,Refundable{

    @Override
    public void pay(double amount) {
        PaymentValidator.validateAmount(amount);
        System.out.println("Paid Using UPI -> "+amount);
    }

    @Override
    public void refund(double amount) {
        PaymentValidator.validateAmount(amount);

        System.out.println("Refunded Via UPI -> "+amount);
    }
}
class PaymentFactory{
    public static PaymentProcessor getPaymentProcessor(String paymentType){
        if(paymentType==null){
            throw  new IllegalArgumentException();
        }
        if (paymentType.equalsIgnoreCase("UPI")) {
            return new UpiPaymentProcessor();
        }

        if (paymentType.equalsIgnoreCase("CARD")) {
            return new CardPaymentProcessor();
        }


        throw new IllegalArgumentException(
                "Unsupported payment type: " + paymentType
        );
    }

}

class OrderService{
    PaymentProcessor paymentProcessor;
    OrderService(PaymentProcessor paymentProcessor){
        this.paymentProcessor=Objects.requireNonNull(paymentProcessor,"paymentProcessor");
    }
    public void placeOrder(double amount){

        paymentProcessor.pay(amount);
    }
}
public class PaymentProcessorMain {
    public static void main(String[] args) {
        PaymentProcessor upiProcessor = PaymentFactory.getPaymentProcessor("UPI");
        PaymentProcessor cardProcessor = PaymentFactory.getPaymentProcessor("CARD");
        OrderService upiOrderService = new OrderService(upiProcessor);
        OrderService cardOrderService = new OrderService(cardProcessor);
        upiOrderService.placeOrder(23);
        cardOrderService.placeOrder(42);

    }
}
