package com.zwj.tank.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: IteratorPattern
 * @Author: zwj
 * @Description: 注释 迭代器模式
 *
 * 提供一种方法顺序访问一个聚合对象中各个元素，而又不需暴露该对象的内部表示。又称游标（Cursor）模式。
 *
 * @Date: 2020/11/25 18:35
 * @Version: 1.0
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("zzh");
        ag.add("jj");
        ag.add("qq");
        Iterator it = ag.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}


/**
 * 迭代器模式角色组成：
 * 1. 抽象容器角色（Aggregate）：负责提供创建具体迭代器角色的接口，一般是一个接口，提供一个iterator()方法，例如java中的Collection接口，List接口，Set接口等。
 * 2. 具体容器角色（ConcreteAggregate）：就是实现抽象容器的具体实现类，比如List接口的有序列表实现ArrayList，List接口的链表实现LinkedList,Set接口的哈希列表的实现HashSet等。
 * 3. 抽象迭代器角色（Iterator）：负责定义访问和遍历元素的接口。
 * 4. 具体迭代器角色（ConcreteIterator）：实现迭代器接口，并要记录遍历中的当前位置。
 */

//Iterator
 interface Iterator
{
    public Object next();
    public boolean hasNext();
}

 //ConcreteIterator
class ConcreteIterator implements Iterator
{
    private List<Object> list = Collections.emptyList();
    private int current = 0;

    public ConcreteIterator(List<Object> list)
    {
        this.list = list;
    }

    public Object next()
    {
        Object obj = null;
        if(this.hasNext())
        {
            obj = this.list.get(current++);
        }
        return obj;
    }

    public boolean hasNext()
    {
        if(current == list.size())
        {
            return false;
        }
        return true;
    }
}

//Aggregate
interface Aggregate
{
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator iterator();
}

//ConcreteAggregate
 class ConcreteAggregate implements Aggregate
{
    private List<Object> list = new ArrayList<Object>();

    public void add(Object obj)
    {
        list.add(obj);
    }

    public void remove(Object obj)
    {
        list.remove(obj);
    }

    public Iterator iterator()
    {
        return new ConcreteIterator(list);
    }
}

/**
 * 优缺点
 * 优点：
 *
 * 简化了遍历方式，对于对象集合的遍历，还是比较麻烦的，对于数组或者有序列表，我们尚可以通过游标来取得，
 * 但用户需要在对集合了解很清楚的前提下，自行遍历对象，但是对于hash表来说，用户遍历起来就比较麻烦了。
 * 而引人了迭代器方法后，用户用起来就简单的多了。
 * 可以提供多种遍历方式，比如说对有序列表，我们可以根据需要提供正序遍历，倒序遍历两种迭代器，
 * 用户用起来只需要得到我们实现好的迭代器，就可以方便的对集合进行遍历了。
 * 封装性良好，用户只需要得到迭代器就可以遍历，而对于遍历算法则不用去关心。
 * 缺点：
 *
 * 对于比较简单的遍历（像数组或者有序列表），使用迭代器方式遍历较为繁琐，比如ArrayList
 * ，用for循环的方式遍历会更好一点，详细可以参考《Java集合框架：ArrayList》
 * 适用场景
 *  迭代器模式是与集合共生共死的，一般来说，我们只要实现一个集合，就需要同时提供这个集合的迭代器，
 * 就像Java中的Collection,List,Set,Map等，这些集合都有自己的迭代器。假如我们要实现一个这样的新的容器，
 * 当然也需要引入迭代器模式，给我们的容器实现一个迭代器。但是，由于容器与迭代器的关系太密切了，
 * 所以大多数语言在实现容器的时候都给提供了迭代器，并且这些语言提供的容器和迭代器在绝大多数情况下就可以满足我们
 * 的需要，所以现在需要我们自己取实践迭代器模式的场景还是比较少见的，我们只需要使用语言中已有的容器和迭代器就可以了
 * 。
 */