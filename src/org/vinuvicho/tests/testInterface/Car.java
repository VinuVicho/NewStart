package org.vinuvicho.tests.testInterface;

public class Car implements IMovable {
    @Override
    public void move() {
        System.out.println("Car is driving");
    }
}
