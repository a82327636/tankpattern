package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: InterpretPattern
 * @Author: zwj
 * @Description: 注释 策略模式
 * @Date: 2020/11/25 18:39
 * @Version: 1.0
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = null;
        context = new Context(new ConcreteStrategyA());
        context.doOperate();
        context = new Context(new ConcreteStrategyB());
        context.doOperate();
        context = new Context(new ConcreteStrategyC());
        context.doOperate();
    }
}


/**
 * 策略模式的角色：
 * 1. 抽象策略角色（Strategy）：策略类，通常由一个接口或者抽象类实现
 * 2. 具体策略角色（ConcreteStrategy)：包装了相关的算法和行为
 * 3. 环境角色(Context)：持有一个策略类的引用，最终给客户端调用
 */

//抽象策略角色
 interface Strategy
{
    public void operate();
}

// 具体策略角色
class ConcreteStrategyA implements Strategy
{
    public void operate()
    {
        System.out.println("初入东吴....#####");
    }
}

class ConcreteStrategyB implements Strategy
{
    public void operate()
    {
        System.out.println("乐而不返....#####");
    }
}

class ConcreteStrategyC implements Strategy
{
    public void operate()
    {
        System.out.println("腹背受敌....#####");
    }
}

// 环境角色Context

class Context
{
    private Strategy strategy;

    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void doOperate()
    {
        this.strategy.operate();
    }
}

