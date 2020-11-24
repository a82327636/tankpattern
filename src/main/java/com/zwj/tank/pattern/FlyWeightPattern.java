package com.zwj.tank.pattern;

import java.util.*;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: FlyWeightPattern
 * @Author: zwj
 * @Description: 注释 享元模式 [主要就是缓存池，线程池使用]
 *
 * 在Java语言中，String类型就是使用了享元模式。String对象是final类型，对象一旦创建就不可改变。
 * 在JAVA中字符串常量都是存在常量池中的，Java会确保一个字符串常量在常量池中只有一个拷贝。譬如：
 *
 * String a = "abc";
 * String b = "abc";
 *System.out.println(a==b);
 *  输出结果：true。
 * 这就说明了a和b量引用都指向了常量池中的同一个字符串常量“abc”。
 * 这样的设计避免了在创建N多相同对象时所产生的不必要的大量的资源消耗。
 *
 *
 * 享元模式采用一个共享来避免大量拥有相同内容对象的开销。这种开销最常见、最直观的就是内存的消耗。享元对象能做到共享的关键是区分内蕴状态（Internal State）和外蕴状态（External State）。
 *  一个内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并且可以共享。
 *  一个外蕴状态是随环境的改变而改变的、不可以共享的。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态不可以影响享元对象的内蕴状态，他们是相互独立的。
 *  享元模式可以分成单纯享元模式和复合享元模式。
 *
 * @Date: 2020/11/24 18:10
 * @Version: 1.0
 */
class FlyWeightPattern {

    public static void main(String[] args) {
//        FlyWeightFactory factory = new FlyWeightFactory();
//        ConcreteFlyweight f1 = factory.factory("a");
//        ConcreteFlyweight f2 = factory.factory("b");
//        ConcreteFlyweight f3 = factory.factory("a");
//
//        f1.operation("a fly weight");
//        f2.operation("b fly weight");
//        f3.operation("c fly weight");
//
//        System.out.println(f1 == f3);
//        System.out.println(factory.getFlyWeightSize());



        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("b");

        FlyweightCompositeFactory factory = new FlyweightCompositeFactory();
        Flyweight f1 = factory.factory(list);
        Flyweight f2 = factory.factory(list);
        f1.operation("Composite Call");
        System.out.println("=======");
        System.out.println("复合享元模式是否可以共享对象："+(f1 == f2));

        String str = "a";
        Flyweight f3 = factory.factory(str);
        Flyweight f4 = factory.factory(str);
        System.out.println("单纯享元模式是否可以共享对象："+(f3 == f4));

    }

}

// 单纯享元模式

/**
 * 包含的角色:
 *
 * 抽象享元角色（Flyweight）：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 * 具体享元角色（ConcreteFlyweight)：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 * 享元工厂角色（FlyweightFactory)：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。
 * 当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个符合要求的享元对象。
 * 如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，
 * 享元工厂角色就应当创建一个合适的享元对象。
 */


//// 抽象享元角色
//interface Flyweight {
//    public void operation(String state);
//}
//
//// 具体享元角色
//class ConcreteFlyweight implements Flyweight
//{
//    private String str;
//
//    public ConcreteFlyweight(String str)
//    {
//        this.str = str;
//    }
//
//    public void operation(String state)
//    {
//        System.out.println("内蕴状态："+str);
//        System.out.println("外蕴状态："+state);
//    }
//}
//
//// 享元工厂角色
// class FlyWeightFactory
//{
//    private Map<String,ConcreteFlyweight> flyWeights = new HashMap<String, ConcreteFlyweight>();
//
//    public ConcreteFlyweight factory(String str)
//    {
//        ConcreteFlyweight flyweight = flyWeights.get(str);
//        if(null == flyweight)
//        {
//            flyweight = new ConcreteFlyweight(str);
//            flyWeights.put(str, flyweight);
//        }
//        return flyweight;
//    }
//
//    public int getFlyWeightSize()
//    {
//        return flyWeights.size();
//    }
//}


/**
 * 复合享元模式
 *  在单纯享元模式中，所有的享元对象都是单纯享元对象，也就是说都是可以直接共享的，
 * 将一些单纯享元使用合成模式加以复合，形成复合享元对象。这样的复合享元对象本身不能共享，
 * 但是它们可以分解成单纯享元对象，而后者则可以共享。
 *  包含的角色
 *
 * 抽象享元角色（Flyweight）：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 * 具体享元角色（ConcreteFlyweight)：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，
 * 必须负责为内蕴状态提供存储空间。
 * 复合享元角色（ConcreteCompositeFlyweight)：复合享元角色所代表的对象是不可以共享的，
 * 但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合。复合享元角色又称作不可共享的享元对象。
 * 享元工厂角色（FlyweightFactory)：本角色负责创建和管理享元角色。本橘色必须保证享元对象可以被系统适当地共享。
 * 当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个符合要求的享元对象。
 * 如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，
 * 享元工厂角色就应当创建一个合适的享元对象。
 * */

interface Flyweight {
    public void operation(String state);
}

// 具体享元角色
class ConcreteFlyweight implements Flyweight
{
    private String str;

    public ConcreteFlyweight(String str)
    {
        this.str = str;
    }

    public void operation(String state)
    {
        System.out.println("内蕴状态："+str);
        System.out.println("外蕴状态："+state);
    }
}

/**
 * 3 复合享元角色
 *  复合享元对象是由单纯享元对象通过复合而成的，因此提供了add()这样的聚集管理方法。
 * 由于一个复合享元对象具有不同的聚集元素，这些聚集元素在复合享元对象被创建之后加入，
 * 这本身就意味着复合享元对象的状态是会改变的，因此复合享元对象是不能共享的。
 *
 * */

class ConcreteCompositeFlyweight implements Flyweight
{
    private Map<String,Flyweight> flyWeights = new HashMap<String, Flyweight>();

    public void add(String key, Flyweight fly)
    {
        flyWeights.put(key, fly);
    }

    public void operation(String state)
    {
        Flyweight fly = null;
        for(String s:flyWeights.keySet())
        {
            fly = flyWeights.get(s);
            fly.operation(state);
        }
    }
}


//享元工厂角色提供两种不同的方法，一种用于提供单纯享元对象，另一种用于提供复合享元对象。

 class FlyweightCompositeFactory
{
    private Map<String,Flyweight> flyWeights = new HashMap<String, Flyweight>();

    public Flyweight factory(List<String> compositeStates)
    {
        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
        for(String s: compositeStates)
        {
            compositeFly.add(s, this.factory(s));
        }
        return compositeFly;
    }

    public Flyweight factory(String s)
    {
        Flyweight fly = flyWeights.get(s);
        if(fly == null)
        {
            fly = new ConcreteFlyweight(s);
            flyWeights.put(s, fly);
        }

        return fly;
    }
}


/**
 * 举个更形象点的例子，比如去饭店吃饭，菜单只有一份，而每个顾客点菜品却各不相同，
 * 但是肯定会有重复，我们用上述的享元模式尝试下模拟代码情形：
 */

class Execute1{
    public static void main(String[] args) {

          FlyweightCompositeFactory factory = new FlyweightCompositeFactory();
          List<String> menuList = Arrays.asList("鱼香肉丝","宫保鸡丁","杭椒牛柳","平锅鱼","番茄炒蛋");
          System.out.println(menuList.subList(0, 2));
        System.out.println(menuList.subList(2, 3));
          Flyweight f1 = factory.factory(menuList.subList(0, 2));
          Flyweight f2 = factory.factory(menuList.subList(2, 3));
          f1.operation("customer1的菜单");
          System.out.println("================");
         f2.operation("customer2的菜单");
    }
}


/**
 *
 * 优缺点
 * 优点：大幅度降低内存中对象的数量
 * 缺点：享元模式使得系统更加复杂。为了使对象可以共享，需要将一些状态外部化，这使得程序的逻辑复杂化。
 * 享元模式将享元对象的状态外部化，而读取外部状态使得运行时间稍微变长。
 *
 * Jdk中的享元模式
 * java.lang.Integer#valueOf(int)
 * java.lang.Boolean#valueOf(boolean)
 * java.lang.Byte#valueOf(byte)
 * java.lang.Character#valueOf(boolean)
 * */