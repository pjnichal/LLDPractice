package OOP;

enum TrafficLight {
    // Define enum constants with duration: RED(30), YELLOW(5), GREEN(25)
    RED(30),
    YELLOW(5),
    GREEN(25);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public TrafficLight next() {
        // Return next light: RED->GREEN, GREEN->YELLOW, YELLOW->RED
        return switch (this){
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }

    public void display() {
        // Print: "COLOR (Xs)" e.g. "RED (30s)"
        System.out.println(this.name()+" ("+this.getDuration()+"s)");
    }
}
public class TrafficLightMain {
    public static void main(String[] args) {
        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < 6; i++) {
            light.display();  // Should show color and duration
            light = light.next();
        }
    }
}
