package org.vinuvicho.tests.testInterface;

public class Person implements IMovable {
    @Override
    public void move() {
        System.out.println("Person is moving");
    }
}
