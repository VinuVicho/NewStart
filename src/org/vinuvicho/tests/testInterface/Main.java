package org.vinuvicho.tests.testInterface;

public class Main {
    public static void main(String[] args) {
        IMovable tom = new Person();
        Car tesla = new Car();
        tom.move();     //Walking
        tesla.move();   //Driving
    }
}
