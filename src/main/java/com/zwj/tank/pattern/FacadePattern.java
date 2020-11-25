package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: FacadePattern
 * @Author: zwj
 * @Description: 注释 外观模式
 *
 * 为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * @Date: 2020/11/25 18:27
 * @Version: 1.0
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.Method();
    }
}


/**
 * 外观模式的角色
 * 1. 门面角色：客户端可以调用这个角色的方法。此角色知晓相关的（一个或者多个）子系统的功能和责任。
 * 在正常情况下，本角色会将所有从客户端发来的请求委派到相应的子系统去。
 * 2. 子系统角色：可以同时有一个或者多个子系统。每个子系统都不是一个单独的类，而是一个类的集合。
 * 每个子系统都可以被刻度环直接调用，或者被门面角色调用。子系统并不知道门面的存在，对于子系统而言，
 * 门面仅仅是另外一个客户端而已。
 */

// 子系统角色
class Class1 {
    public void op1() {
        System.out.println("方法1");
    }
}
class Class2 {
    public void op2() {
        System.out.println("方法2");
    }
}
class Class3 {
    public void op3() {
        System.out.println("方法3");
    }
}

// 门面角色
class Facade {
    private Class1 one = new Class1();
    private Class2 two = new Class2();
    private Class3 three = new Class3();
    public void op1() {
        System.out.println("Facade op1()");
        one.op1();
    }
    public void op2() {
        System.out.println("Facade op2()");
        two.op2();
    }
    public void op3() {
        System.out.println("Facade op3()");
        three.op3();
    }

    public void Method() {
        System.out.println("Facade Method()");
        three.op3();
        two.op2();
        one.op1();
    }
}


/**
 * 松散耦合：门面模式松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护
 * 简单易用：门面模式让子系统更加易用，客户端不再需要了解子系统内部的实现，也不需要跟踪多个子系统内部的模块进行交互，只需要跟门面类交互就可以了
 * 更好的划分访问层次：通过合理的使用Facade，可以帮助我们更好的划分访问的层次。有些方法是对系统外的，有些方法是系统内部使用的。把需要暴露给外部的功能集中到门面中，这样既方便客户端使用，也很好地掩藏了内部的细节。
 * Jdk中的Facade：Java.lang.Class
 *
 * 外观模式和代理模式的区别
 * 代理与外观的主要区别在于，代理对象代表一个单一对象而外观对象代表一个子系统，代理的客户对象无法直接访问对象，
 * 由代理提供单独的目标对象的访问，而通常外观对象提供对子系统各元件功能的简化的共同层次的调用接口。
 * 代理是一种原来对象的代表，其他需要与这个对象打交道的操作都是和这个代表交涉的。
 *
 * 外观模式和适配器模式的区别
 * 外观与适配器都是对现存系统的封装。外观定义的新的接口，而适配器则是复用一个原有的接口，
 * 适配器是使两个已有的接口协同工作，而外观则是为现存系统提供一个更为方便的访问接口。
 * 如果硬要说外观是适配，那么适配器有用来适配对象的，而外观是用来适配整个子系统的。
 * 也就是说，外观所针对的对象的粒度更大
 *
 *
 */