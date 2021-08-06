package org.vinuvicho.tests.staticImport;

import static java.lang.System.out;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        out.println("Hello");
        TestClass testClass = new TestClass();
        int a = (int) sqrt(6.6);
    }
}
