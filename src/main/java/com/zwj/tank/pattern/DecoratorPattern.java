package com.zwj.tank.pattern;

import java.math.BigDecimal;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: DecoratorPattern
 * @Author: zwj
 * @Description: 注释 装饰模式
 *
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰模式想必生成子类更为灵活。
 *  装饰模式又名包装（Wrapper）模式。装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。
 *
 * 装饰模式中的角色有：
 * 1. 抽象构件角色（Component）：给出一个抽象接口，以规范准备接受附加责任的对象。
 * 2. 具体构件角色（ConcreteComponent）：定义一个将要接收附加责任的类。
 * 3. 装饰角色（Decorator）：持有一个构件（Component）对象的实例，并定义一个与抽象构件接口一致的接口。
 * 4. 具体装饰角色（ConcreteDecorator）：负责给构件对象“贴上”附加的责任。
 *
 * 举个简单例子（类比《Head Fisrt》中的星巴克：吃杂粮煎饼，加个鸡蛋，加根火腿，加份辣条）
 *
 * @Date: 2020/11/25 14:38
 * @Version: 1.0
 */
class DecoratorPattern {

    public static void main(String[] args) {
        Pancake pancake = new CoarsePancake();
        Condiment egg = new Egg(pancake);
        Condiment ham = new Ham(egg);
        ham.sold();
        Condiment lettuce = new Lettuce(ham);
        lettuce.sold();
    }
}

// 抽象构件角色
abstract class Pancake
{
    protected String name;
    public String getName()
    {
        return this.name;
    }
    public abstract BigDecimal getPrice();
}


// 具体构件角色
class CoarsePancake extends Pancake
{
    public CoarsePancake(){
        this.name = "杂粮煎饼";
    }

    @Override
    public BigDecimal getPrice()
    {
        return new BigDecimal(5);
    }
}


// 装饰抽象角色
abstract class Condiment extends Pancake
{
    public abstract String getName();

    public void sold()
    {
        System.out.println(getName()+"："+getPrice());
    }
}

// 具体装饰角色
class Egg extends Condiment
{
    private Pancake pancake;
    public Egg(Pancake pancake)
    {
        this.pancake = pancake;
    }

    @Override
    public String getName()
    {
        return pancake.getName()+",加鸡蛋";
    }

    @Override
    public BigDecimal getPrice()
    {
        return pancake.getPrice().add(new BigDecimal(1.5));
    }
}

class Ham extends Condiment
{
    private Pancake pancake;
    public Ham(Pancake pancake)
    {
        this.pancake = pancake;
    }
    @Override
    public String getName()
    {
        return this.pancake.getName()+",加火腿";
    }

    @Override
    public BigDecimal getPrice()
    {
        return pancake.getPrice().add(new BigDecimal(2));
    }
}

class Lettuce extends Condiment
{
    private Pancake pancake;
    public Lettuce(Pancake pancake)
    {
        this.pancake = pancake;
    }
    @Override
    public String getName()
    {
        return this.pancake.getName()+",加生菜";
    }

    @Override
    public BigDecimal getPrice()
    {
        return pancake.getPrice().add(new BigDecimal(1));
    }
}


/**
 * 适用场景
 *
 * 想透明并且动态地给对象增加新的职责的时候
 * 给对象增加的职责，在未来存在增加或减少功能
 * 用继承扩展功能不太现实的情况下，应该考虑用组合的方式
 *
 * 优点：
 *
 * 通过组合而非继承的方式，实现了动态扩展对象的功能的能力。
 * 有效避免了使用继承的方式扩展对象功能而带来的灵活性差，子类无限制扩张的问题。
 * 充分利用了继承和组合的长处和短处，在灵活性和扩展性之间找到完美的平衡点。
 * 装饰者和被装饰者之间虽然都是同一类型，但是它们彼此是完全独立并可以各自独立任意改变的。
 * 遵守大部分GRAP原则和常用设计原则，高内聚、低偶合。
 * 缺点：
 *
 * 装饰链不能过长，否则会影响效率。
 * 因为所有对象都是继承于Component,所以如果Component内部结构发生改变，则不可避免地影响所有子类(装饰者和被装饰者)，也就是说，通过继承建立的关系总是脆弱地，如果基类改变，势必影响对象的内部，而通过组合建立的关系只会影响被装饰对象的外部特征。
 * 只在必要的时候使用装饰者模式，否则会提高程序的复杂性，增加系统维护难度。
 *
 *
 * Jdk中的装饰模式：由于Java I/O库需要很多性能的各种组合，如果这些性能都是用继承的方法实现的，
 * 那么每一种组合都需要一个类，这样就会造成大量性能重复的类出现。而如果采用装饰模式，那么类的数目就会大大减少，
 * 性能的重复也可以减至最少。因此装饰模式是Java I/O库的基本模式。
 *
 * - 抽象构件(Component)角色：由InputStream扮演。这是一个抽象类，为各种子类型提供统一的接口。
 * - 具体构件(ConcreteComponent)角色：由ByteArrayInputStream、FileInputStream、PipedInputStream、StringBufferInputStream等类扮演。它们实现了抽象构件角色所规定的接口。
 * - 抽象装饰(Decorator)角色：由FilterInputStream扮演。它实现了InputStream所规定的接口。
 * - 具体装饰(ConcreteDecorator)角色：由几个类扮演，分别是BufferedInputStream、DataInputStream以及两个不常用到的类LineNumberInputStream、PushbackInputStream。
 *
 * */


