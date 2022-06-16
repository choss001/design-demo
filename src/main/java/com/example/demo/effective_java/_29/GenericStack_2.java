package com.example.demo.effective_java._29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStack_2<E> {

  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public GenericStack_2() {
    elements =  new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E pop(){
    if (size == 0)
      throw new EmptyStackException();

    @SuppressWarnings("unchecked")
    E result = (E)elements[size--];

    elements[size] = null;
    return result;
  }

  private void ensureCapacity() {
    if(elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
  }
}
