package com.zwj.tank;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank
 * @ClassName: Generic
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/25 17:18
 * @Version: 1.0
 */
public class Generic {

    public static void main(String[] args) {
//        Fruit fruit = new Fruit();
//        System.out.println("_________________");
//        Apple apple = new Apple();
//        System.out.println("_________________");
//        RedApple redApple = new RedApple();
//        System.out.println("_________________");
//        System.out.println(fruit.getClass().getSuperclass());
//        System.out.println(apple.getClass().getSuperclass());
//        System.out.println(redApple.getClass().getSuperclass());


        Fruit[] fruit = new Fruit[]{new RedApple()};
        System.out.println("_________________");
        Apple[] apple = new Apple[]{};
        System.out.println("_________________");
        RedApple[] redApple = new RedApple[]{};
        System.out.println("_________________");
        System.out.println(fruit.getClass().getSuperclass());
        System.out.println(apple.getClass().getSuperclass());
        System.out.println(redApple.getClass().getSuperclass());
    }
}


class Fruit{
    public Fruit(){
        System.out.println("fruit");
    }
}

class Apple extends Fruit{
    public Apple(){
        System.out.println("Apple");
    }
}

class RedApple extends Apple{
    public RedApple(){
        System.out.println("RedApple");
    }
}
