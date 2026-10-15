package OOP;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double area();
    abstract double perimeter();

    void describe() {
        // Print: "Shape: [name], Area: [area], Perimeter: [perimeter]"
        // Use String.format("%.2f", value) to format to 2 decimal places
        String area = String.format("%.2f",this.area());
        String perimeter = String.format("%.2f",this.perimeter());
        System.out.println("Shape: "+this.name+", Area: "+area+", Perimeter: "+perimeter);
    }
}

class Circle extends Shape {
    private double radius;
    private final double pi = Math.PI;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double area() {
        // Area = pi * r^2
        return pi * radius * radius;
    }

    @Override
    double perimeter() {
        // Perimeter = 2 * pi * r
        return 2 * pi * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        // Area = width * height
        return width * height;
    }

    @Override
    double perimeter() {
        // Perimeter = 2 * (width + height)
        return 2 * (width+height);
    }
}

public class ShapeCalculatorMain {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        circle.describe();

        Shape rectangle = new Rectangle(4.0, 6.0);
        rectangle.describe();
    }
}
