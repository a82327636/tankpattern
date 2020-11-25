package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: TemplatePattern
 * @Author: zwj
 * @Description: 注释 （模板方法模式）
 * @Date: 2020/11/25 15:06
 * @Version: 1.0
 */

/**
 * 模板方法模式：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。TemplateMethod使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。一次性的实现一个算法的不变部分，并将可变的行为留给子类来实现。
 *
 *  模板方法的关键是：子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑。
 *  模板方法模式中的方法可以分为两大类：模板方法和基本方法。
 *
 * 1 模板方法
 *  一个模板方法是定义在抽象类中的，把基本操作方法组合在一起形成一个总算法或一个总行为的方法。
 *  一个抽象类可以有任意多个模板方法，而不限于一个。每一个模板方法都可以调用任意多个具体方法。
 *
 * 2 基本方法
 *  基本方法又可以分为三种：抽象方法（Abstract Method）、具体方法(Concrete Method)和钩子方法(Hook Method)。
 *  抽象方法：一个抽象方法由抽象类声明，由具体子类实现。
 *  具体方法：一个具体方法由抽象类声明并实现，而子类并不实现或置换。
 *  钩子方法：一个钩子方法由抽象类声明并实现，而子类会加以扩展。通常抽象类给出的实现是一个空实现，作为方法的默认实现。
 * 这种空的钩子方法叫做“Do Nothing Hook”。钩子方法的名字应当以do开始，这是熟悉设计模式的Java开发人员的标准做法。
 * 譬如HttpServlet类中，也遵从这一命名规则：doGet, doPost等。 在HttpServlet中模板方法由service()方法担任，
 * 基本方法由doPost(),doGet()等方法担任。
 */

class TemplatePattern {

    public static void main(String[] args) {
        ConcreteTemplate concreteTemplate = new ConcreteTemplate();
        concreteTemplate.templateMethod();
    }

}


// AbstractClass
abstract class AbstractTemplate
{

    final Integer i = 12;

    public void templateMethod(){
        abstractMethod();
        doHookMethod();
        concreteMethod();
    }

    protected abstract void abstractMethod();
    protected void doHookMethod(){}
    protected final void concreteMethod(){
        System.out.println("invoke concreteMethod");
    }
}

//ConcreteClass

 class ConcreteTemplate extends AbstractTemplate
{
    @Override
    protected void abstractMethod()
    {
        System.out.println("ConcreteTemplate-abstractMethod");
    }

    @Override
    public void doHookMethod()
    {
        System.out.println("ConcreteTemplate-doHookMethod");
    }
}