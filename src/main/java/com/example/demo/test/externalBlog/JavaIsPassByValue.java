package com.example.demo.test.externalBlog;

public class JavaIsPassByValue {

    private String color;

    public JavaIsPassByValue(){}

    public JavaIsPassByValue(String c){
        this.color=c;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

class Test{
    public static void main(String[] args) {

        JavaIsPassByValue red = new JavaIsPassByValue("Red"); //memory reference 50
        JavaIsPassByValue blue = new JavaIsPassByValue("Blue"); //memory reference 100

        swapTwo(red, blue);
        System.out.println("red color="+red.getColor());
        System.out.println("blue color="+blue.getColor());

        foo(blue);
        System.out.println("blue color="+blue.getColor());

    }

    private static void foo(JavaIsPassByValue balloon) { //baloon=100
        balloon.setColor("Red"); //baloon=100
        balloon = new JavaIsPassByValue("Green"); //baloon=200
        balloon.setColor("Blue"); //baloon = 200
    }

    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1=o2;
        o2=temp;
    }


    public static void swapTwo(JavaIsPassByValue o1, JavaIsPassByValue o2){
        JavaIsPassByValue temp = o1;
        o1=o2;
        o2=temp;
    }
}

