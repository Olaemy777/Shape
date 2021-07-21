package com.olaemy;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3, 3);
        Ball ball = new Ball(5);
        Pyramid pyramid = new Pyramid(50, 50);
        Box box = new Box(700);
        System.out.println(box.add(cylinder));
        System.out.println(box.add(ball));
        System.out.println(box.add(pyramid));


    }
}
    class Shape {
        private double volume;

        public Shape(double volume) {
            this.volume = volume;
        }

        public double getVolume() {
            return volume;
        }
    }

    class SolidOfRevolution extends Shape {
        private double radius;

        public SolidOfRevolution(double volume, double radius) {
            super(volume);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    class Ball extends SolidOfRevolution {
        public Ball(double radius) {
            super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
        }
    }

    class Cylinder extends SolidOfRevolution {
        private double height;

        public Cylinder(double radius, double height) {
            super(Math.PI * radius * radius * height, radius);
            this.height = height;
        }
    }

    class Pyramid extends Shape {
        private double h; // height
        private double s;

        public Pyramid(double h, double s) {
            super(h * s * 4 / 3);
            this.h = h;
            this.s = s;
        }
    }

    class Box extends Shape {
        private ArrayList<Shape> shapes = new ArrayList<>();
        double possible;

        public Box(double possible) {
            super(possible);
            this.possible = possible;
        }

        public boolean add(Shape shape) {
            if (possible >= shape.getVolume()) {
                shapes.add(shape);
                possible -= shape.getVolume();
                return true;
            } else {
                return false;
            }
        }
    }


