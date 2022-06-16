package com.example.demo.effective_java._29;

import java.util.Arrays;

public class Stack {
  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack() {
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object object) {
    ensureCapacity();
    elements[size++] = object;
  }

  public boolean isEmpty() {
    return size == 0;
  }


  private void ensureCapacity() {
    if(elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
  }
}
