package com.example.demo.effective_java._10;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Point {

    private final int x;
    private final int y;
    private static final Set<Point> unitCircle = Set.of(
            new Point(1,0), new Point(0, 1),
            new Point(-1,0), new Point(0, -1)
    );

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    @Override
    public boolean equals(Object o) {
        if(o ==null || o.getClass() != getClass())
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
    @Override
    public int hashCode(){
        return x*3333+ y*4444;
    }

    public class ColorPoint{
        private final Color color;
        private final Point point;

        public ColorPoint(int x, int y, Color color) {
            point = new Point(x, y);
            this.color = color;
        }
        public Point asPoint(){
            return point;
        }

        @Override
        public boolean equals(Object o ) {
            if(!(o instanceof ColorPoint))
                return false;
            return super.equals(o) &&
                    ((ColorPoint) o).color == color;
        }
    }

    public static class CountPoint extends Point{
        private static final AtomicInteger counter = new AtomicInteger();

        public CountPoint(int x, int y) {
            super(x, y);
        }
        public static int numberCreated() {
            return counter.get();
        }
    }

    public static boolean onUnitCircle(Point point) {
        return unitCircle.contains(point);
    }

}
