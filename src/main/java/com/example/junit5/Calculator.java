package com.example.junit5;

public class Calculator {

    public int multiply(int a, int b) {
        if (a > 999 || b > 999) {
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return a * b;
    }
}
