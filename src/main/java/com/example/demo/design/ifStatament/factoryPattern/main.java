package com.example.demo.design.ifStatament.factoryPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int divided = calculator.calculateUsingFactory(13, 6, "divide");
        log.info("result : {}", divided);
    }
}
