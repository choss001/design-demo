package com.example.demo.design.ifStatament.factoryPattern;

public class Division implements Operation{
    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
