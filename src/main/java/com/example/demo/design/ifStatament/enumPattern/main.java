package com.example.demo.design.ifStatament.enumPattern;

public class main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculator(3, 4, Operator.valueOf("ADD"));
    }
}
