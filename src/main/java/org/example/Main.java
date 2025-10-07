package org.example;

class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

abstract class Shape {
    protected Point centerPoint;
    protected static int count = 0;

    public Shape(Point centerPoint) {
        this.centerPoint = centerPoint;
        count++;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public static int getCount() {
        return count;
    }

    public abstract String toString();
}

class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(Point centerPoint, float width, float height) {
        super(centerPoint);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Hình chữ nhật [Tâm: " + centerPoint + ", Rộng: " + width + ", Cao: " + height + "]";
    }
}

class Square extends Shape {
    private float side;

    public Square(Point centerPoint, float side) {
        super(centerPoint);
        this.side = side;
    }

    @Override
    public String toString() {
        return "Hình vuông [Tâm: " + centerPoint + ", Cạnh: " + side + "]";
    }
}

class Circle extends Shape {
    private float radius;

    public Circle(Point centerPoint, float radius) {
        super(centerPoint);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Hình tròn [Tâm: " + centerPoint + ", Bán kính: " + radius + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(new Point(2, 3), 4, 5),
                new Square(new Point(0, 0), 2),
                new Circle(new Point(5, 1), 3)
        };

        System.out.println("Tổng số hình đã khởi tạo: " + Shape.getCount());

        System.out.println("\nDanh sách chi tiết các hình:");
        for (Shape s : shapes) {
            System.out.println(" - " + s);
        }

        System.out.println("\nDanh sách tâm điểm:");
        for (Shape s : shapes) {
            System.out.println(" - " + s.getCenterPoint());
        }
    }
}
