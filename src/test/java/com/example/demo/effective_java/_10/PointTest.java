package com.example.demo.effective_java._10;

import org.junit.jupiter.api.Test;

import javax.persistence.SecondaryTable;
import java.awt.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void test1(){
        Point p = new Point(1, 2);
        Point.ColorPoint cp = p.new ColorPoint(1, 2, Color.RED);

        boolean equals = p.equals(cp);
        boolean equals1 = cp.equals(p);
        System.out.println(equals);
        System.out.println(equals1);
    }

    @Test
    void test2() {
        Point p = new Point(1, 0);
        Point.CountPoint pc = new Point.CountPoint(1, 2);
//        boolean b = Point.onUnitCircle(pc);
//        System.out.println(b);

        boolean b1 = Point.onUnitCircle(p);
        System.out.println(b1);

    }

    @Test
    void test3() {
        Point p = new Point(1, 0);
        Set<Point> unitCircle = Set.of(
                new Point(1,0), new Point(0, 1),
                new Point(-1,0), new Point(0, -1)
        );

        boolean contains = unitCircle.contains(p);
        System.out.println(contains);

        boolean equals = p.equals(p);
        System.out.println("point equals test : "+equals);

    }

    @Test
    void test4() {
        Set<String> strings = Set.of("test", "wow", "1");

        boolean test = strings.contains("test");
        System.out.println(test);
    }

}