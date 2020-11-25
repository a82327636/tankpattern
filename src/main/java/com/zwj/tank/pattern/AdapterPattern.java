package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: AdapterPattern
 * @Author: zwj
 * @Description: 注释 适配器模式
 *
 *  适配器模式：将一个类的接口转换成客户希望的另外一个接口。
 *      适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *  适配器模式有类适配器模式和对象适配器模式两种不同的形式。
 *
 * @Date: 2020/11/25 15:22
 * @Version: 1.0
 */


/**
 * 默认适配器
 *  当你想实现一个接口但又不想实现接口中所有的方法，只想去实现一部分方法时，就用到了默认适配器模式。
 *    它的方法时在接口和具体实现类中添加一个抽象类，而用抽象类是实现目标接口的所有方法。
 *    而具体的实现类只需要覆盖其需要完成的方法即可。
 */
public class AdapterPattern {

    public static void main(String[] args) {
        // 类适配器
        Target adapter = new Adapter();
        adapter.request();

        // 对象适配器
        Target adapter1 = new ObjectAdapter(new Adaptee());
        adapter1.request();
    }

}

/**
 * 类适配器
 *  类适配器模式把适配的类的API转换成目标类的API
 *
 * 适配器模式所涉及的角色：
 *
 * 目标角色（Target）： 这就是所期待得到的接口。
 * 源角色（Adaptee）：需要适配的接口
 * 适配器角色（Adapter）：适配器类是本模式的核心。适配器把源接口转换成目标接口。
 *  显然，这一角色不可以是接口，而必须是具体类。
 */

// 目标角色
interface Target
{
    public void request();
}

// 源角色
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("被适配的类Adaptee");
    }
}

// 适配器角色（类适配器决定了Target不能为类，只能为接口，因为java不支持多继承的关系）
class Adapter extends Adaptee implements Target
{
    public void request()
    {
        super.specificRequest();
    }
}


/**
 * 对象适配器
 * 举个简单例子
 * 目标角色（同上，这里的目标角色Target可以为类）
 * 源角色（同上）
 * 适配器角色
 */

class ObjectAdapter implements Target
{
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    public void request()
    {
        this.adaptee.specificRequest();
    }
}


/**
 Jdk中的适配器模式
 java.util.Arrays#asList()
 java.io.InputStreamReader(InputStream)
 java.io.OutputStreamWriter(OutputStream)

 总结
  优点：更好的复用性：系统需要使用现有的类，而此类的接口不符合系统的需要。
 那么通过适配器模式就可以让这些功能得到更好的复用。更好的扩展性：在实现适配器功能的时候，
 可以调用自己开发的功能，从而自然地扩展系统的功能。
  缺点：过多的使用适配器，会让系统非常零乱，不易整体进行把握。
 如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。

 适用场景

 你想使用一个已经存在的类，而它的接口不符合你的需求
 你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类协同工作。
 （仅使用与对象Adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。
 */


