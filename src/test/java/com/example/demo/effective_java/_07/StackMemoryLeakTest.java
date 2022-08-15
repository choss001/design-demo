package com.example.demo.effective_java._07;

import com.example.demo.effective_java._29.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMemoryLeakTest {
    private final static StackMemoryLeak stackMemoryLeak = new StackMemoryLeak();

    @Test
    void push() {

        stackMemoryLeak.push("test01");
        stackMemoryLeak.push("test02");
        stackMemoryLeak.pop();

        stackMemoryLeak.pop();

    }

    @Test
    void pop() {
    }

    @Test
    void ensureCapacity() {
    }
}