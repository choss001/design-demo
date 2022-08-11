package com.example.demo.effective_java._28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Item28 {
    public static void main(String[] args) {

    }

    public class Chooser{
        private final Object[] choiceArray;

        public Chooser(Collection choices) {
            choiceArray = choices.toArray();
        }

        public Object choose(){
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }

    public class ChooserFirstAttempt<T> {
        private final T[] choiceArray;

        public ChooserFirstAttempt(Collection<T> choices) {
            choiceArray = (T[])choices.toArray();
        }

        public Object choose(){
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }
}

