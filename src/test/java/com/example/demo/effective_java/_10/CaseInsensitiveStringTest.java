package com.example.demo.effective_java._10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseInsensitiveStringTest {

    @Test
    void test(){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "Polish";
        CaseInsensitiveString cis1 = new CaseInsensitiveString("polish1");

        boolean equals = cis.equals(cis1);
        System.out.println("test : " + equals);

        boolean equals1 = cis1.equals(cis);
        System.out.println("test1 : " + equals1);
    }

}