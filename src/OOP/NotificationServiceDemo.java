package OOP;
//Design a notification system that can send messages through email and SMS.
//Requirements
//1. Define a common NotificationChannel interface.
//        2. The interface must declare a send(String recipient, String message) method.
//3. Implement EmailNotification and SmsNotification.
//        4. Each implementation must print a different message showing how it sends the notification.
//5. Create a NotificationService that accepts a NotificationChannel and sends a notification.
//6. Demonstrate that the same service can send through either channel without changing its implementation.
//Constraints
//- Use Java.
//        - Don't use if-else or switch to choose the channel inside NotificationService.
//        - Don't use static utility methods for sending notifications.
//        - Include a main() method demonstrating both implementations.
interface NotificationChannel{
    void send(String recipient, String message);
}
class EmailNotification implements NotificationChannel{

    @Override
    public void send(String recipient, String message) {
        System.out.println("Send Via Email\nRecipient: "+recipient+"\nMessage: "+message);
    }
}
class SmsNotification implements NotificationChannel{

    @Override
    public void send(String recipient, String message) {
        System.out.println("Send Via SMS\nRecipient: "+recipient+"\nMessage: "+message);
    }
}
class NotificationService {
    private final NotificationChannel notificationChannel;
    NotificationService(NotificationChannel notificationChannel){
        this.notificationChannel=notificationChannel;
    }
    public void sendNotification(String recipient,String message){
        this.notificationChannel.send(recipient,message);
    }
}
public class NotificationServiceDemo{
    static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new SmsNotification());
        notificationService.sendNotification("abc@gmail.com","Hello");

    }
}
