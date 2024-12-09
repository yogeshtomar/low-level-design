package DesignPatterns.prototype;

interface Shape{
    Shape clone();
    void draw();
}

class Circle implements Shape {
    private String color;

    public Circle(String color){
        this.color = color;
    }

    @Override
    public Shape clone() { 
        return new Circle(this.color);
    }

    @Override
    public void draw() {
        System.out.println("Crawing a " + color + " circle...");
    }
}

class ShapeClient {
    private Shape shapePrototype;

    public ShapeClient(Shape shapePrototype){
        this.shapePrototype = shapePrototype;
    }

    public Shape createShape() {
        return shapePrototype.clone();
    }
}

public class ProtoTypePattern {
    public static void main(String[] args) {
        Shape redCirclePrototype = new Circle("redCircle");
        ShapeClient client = new ShapeClient(redCirclePrototype);

        Shape redCircle = client.createShape();

        redCircle.draw();
    }
}
