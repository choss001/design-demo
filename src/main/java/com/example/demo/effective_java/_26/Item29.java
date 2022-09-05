package com.example.demo.effective_java._26;

import java.util.ArrayList;
import java.util.List;

public class Item29 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
//        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }
}
