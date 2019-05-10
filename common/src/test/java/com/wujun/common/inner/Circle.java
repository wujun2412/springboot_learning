package com.wujun.common.inner;

/**
 * @author wujun
 * @description
 * @date 19/5/5.
 */
public class Circle {
    private double radius = 0;

    public static int count =1;

    public Circle(double radius) {
        this.radius = radius;
    }

    //内部类
    class Draw{
        public int count =2;

        public void drawShape(){
            System.out.println(radius);
            System.out.println(count);
            System.out.println("outter:"+ Circle.this.count);
        }
    }


    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Circle.Draw draw = circle.new Draw();
        draw.drawShape();
    }
}
