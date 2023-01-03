package com.example.demo.design.ifStatament.enumPattern;

import com.example.demo.design.ifStatament.factoryPattern.Operation;

public class Calculator {
    public int calculator(int a, int b, Operator operator) {
        return operator.apply(a, b);
    }
}
