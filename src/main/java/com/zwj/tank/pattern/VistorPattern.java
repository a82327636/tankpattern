package com.zwj.tank.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: VistorPattern
 * @Author: zwj
 * @Description: 注释 访问者模式
 * 访问者模式表示一个作用于某对象结构中的各元素的操作，它使你可以在不改变各元素类的前提下定义作用于这些元素的新操作。
 * @Date: 2020/11/25 18:17
 * @Version: 1.0
 */
public class VistorPattern {

    public static void main(String[] args) {
        List<Element> list = ObjectStructure.getList();
        for(Element e:list){
            e.accept(new Visitor());
        }
    }
}

/**
 * 访问者模式的角色：
 * 1. 访问者角色（Visitor）：抽象类或者接口，声明访问者可以访问那些元素，
 * 具体到程序中就是visit方法中的参数定义哪些对象是可以被访问的。
 * 2. 具体访问者角色（Concrete Visitor）：实现每个访问者角色（Visitor）声明的操作。
 * 3. 元素角色（Element）：抽象类或者接口，定义一个Accept操作，声明接收哪一类访问者访问。
 * 抽象元素角色一般有两类方法，一部分是本身的业务逻辑，另外就是允许接收哪类访问者来访问。
 * 4. 具体元素角色（Concrete Element）：实现由元素角色提供的Accept操作。
 * 5. 对象结构角色（Object Structure）：这是使用访问者模式必备的角色。它要具备一下特征：
 * 能枚举它的元素；可以提供一个高层的接口以允许该访问者访问它的元素；可以是一个复合（组合）或是一个集合，
 * 如一个列表或一个无序集合。
 */


//访问者角色
interface IVistor
{
    public void visit(ConcreteElement1 e1);
    public void visit(ConcreteElement2 e2);
}

// 元素角色
abstract class Element
{
    public abstract void accept(IVistor visitor);
    public abstract void doSomething();
}

//具体访问者角色
class Visitor implements IVistor
{

    public void visit(ConcreteElement1 e1)
    {
        e1.doSomething();
    }

    public void visit(ConcreteElement2 e2)
    {
        e2.doSomething();
    }
}
// 具体元素角色
class ConcreteElement1 extends Element
{
    @Override
    public void accept(IVistor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public void doSomething()
    {
        System.out.println("Element1");
    }
}
class ConcreteElement2 extends Element
{
    @Override
    public void accept(IVistor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public void doSomething()
    {
        System.out.println("Element2");
    }
}

//对象结构角色
class ObjectStructure
{
    public static List<Element> getList()
    {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for(int i=0;i<10;i++)
        {
            int a = ran.nextInt(100);
            if(a>50)
                list.add(new ConcreteElement1());
            else
                list.add(new ConcreteElement2());
        }
        return list;
    }
}


/**
 * 优缺点
 * 优点
 * 1. 符合单一职责原则：凡是适用访问者模式的场景中，元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作，使用访问者模式一方面符合单一职责原则，另一方面，因为被封装的操作通常来说都是易变的，所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展。
 * 2. 扩展性好：元素类可以通过接受不同的访问者来实现对不通操作的扩展。
 * 缺点：
 * 1. 增加新的元素类比较困难。在访问者类中，每一个元素类都有它对应的处理方法，也就是说，每增加一个元素类都需要修改访问者类，修改起来相当麻烦。也就是说，在元素类数目不确定的情况下，应该慎用访问者模式。
 */