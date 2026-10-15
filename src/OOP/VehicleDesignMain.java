package OOP;
//Requirements
//1. Define an Engine interface with a startEngine() method.
//2. Implement PetrolEngine and ElectricEngine.
//        3. Create a Car class that uses an Engine.
//        4. The Car must expose a start() method that delegates to its engine.
//        5. Use constructor injection to supply the engine.
//6. Demonstrate both petrol and electric cars without modifying the Car class.
//Constraints
//- Use Java.
//        - Don't make Car extend PetrolEngine or ElectricEngine.
//        - Don't use if-else or switch inside Car to determine the engine type.
//        - Include a main() method demonstrating both variants.

interface Engine{
    void startEngine();
}
class PetrolEngine implements Engine{

    @Override
    public void startEngine() {
        System.out.println("Petrol Engine Started");
    }
}
class ElectricEngine implements Engine{
    @Override
    public void startEngine() {
        System.out.println("Electric Engine Started");
    }
}
class Car{
    private final Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
    public void start(){
        engine.startEngine();
    }
}
public class VehicleDesignMain {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Engine electricEngine = new ElectricEngine();
        Car petrolCar = new Car(petrolEngine);
        Car electricCar= new Car(electricEngine);
        petrolCar.start();
        electricCar.start();
    }
}
