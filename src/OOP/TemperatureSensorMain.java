package OOP;

import java.util.ArrayList;
import java.util.List;

class TemperatureSensor {
    private final List<Double> readings = new ArrayList<>();
    private double total = 0.0;

    public void addReading(double value) {
        if (value < -50 || value > 150) {
            return;
        }

        readings.add(value);
        total += value;
    }

    public double getAverage() {
        if (readings.isEmpty()) {
            return 0.0;
        }

        return Math.round((total / readings.size()) * 100.0) / 100.0;
    }

    public int getReadingCount() {
        return readings.size();
    }

    public List<Double> getReadings() {
        return new ArrayList<>(readings);
    }
}

// Test your implementation
public class TemperatureSensorMain {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.addReading(22.5);
        sensor.addReading(23.1);
        sensor.addReading(200.0);  // Should be rejected
        sensor.addReading(-10.0);

        System.out.println("Count: " + sensor.getReadingCount());  // 3
        System.out.println("Average: " + sensor.getAverage());     // 11.87
    }
}
