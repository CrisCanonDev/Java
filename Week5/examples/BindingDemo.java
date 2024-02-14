package com.example.jaavafxtesting;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingDemo {
    public static void main(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(3);
        d1.bind(d2); // Bind d1 with d2
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());
        d2.setValue(156.123);
        System.out.println("d1 is " + d1.getValue()
                + " and d2 is " + d2.getValue());
    }
}