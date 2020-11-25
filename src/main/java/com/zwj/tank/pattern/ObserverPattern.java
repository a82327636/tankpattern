package com.zwj.tank.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: ObserverPattern
 * @Author: zwj
 * @Description: 注释 观察者模式
 *
 * 定义对象见的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新
 * @Date: 2020/11/25 18:08
 * @Version: 1.0
 */
public class ObserverPattern {

    public static void main(String[] args) {
        // 推模式
//        ConcreteSubject subject = new ConcreteSubject();
//        Observer observer = new ConcreteObserver();
//        subject.attach(observer);
//        subject.setState("new State");

        // 拉模式
        ConcreteSubject2 subject = new ConcreteSubject2();
        Observer2 observer = new ConcreteObserver2();
        subject.attach(observer);
        subject.setState("new State");
    }
}

/**
 * 观察者模式的角色
 * 1. 抽象主题角色(Subject)：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。
 * 抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
 * 2. 具体主题角色(ConcreteSubject)：在具体主题内部状态改变时，给所有登记过的观察者发出通知。
 * 具体主题角色通常用一个子类实现。
 * 3. 抽象观察者角色（Observer）：为所有的管擦着定义一个接口，在得到主题的通知更新自己。
 * 4. 具体观察者角色(ConcreteObserver)：该角色实现抽象观察者角色所要求的更新接口，
 * 以便使本身的状态和主题的状态相协调。通常用一个子类实现。如果需要，具体观察者角色可以保持一个指向具体主题角色的引用。
 */

//抽象观察者角色（Observer）:
interface Observer
{
    public void update(String str);
}


//抽象主题角色(Subject)
abstract class Subject
{
    private List<Observer> list = new ArrayList<Observer>();

    public void attach(Observer observer)
    {
        list.add(observer);
    }

    public void detach(Observer observer)
    {
        list.remove(observer);
    }

    public void notifyObservers(String str)
    {
        int len = list.size();
        for(int i=0;i<len;i++)
        {
            list.get(i).update(str);
        }
    }
}

//具体主题角色(ConcreteSubject)
class ConcreteSubject extends Subject
{
    private String subjectState;

    public String getState(){
        return subjectState;
    }

    public void setState(String newState)
    {
        this.subjectState = newState;
        System.out.println("主题状态为： "+subjectState);
        this.notifyObservers(subjectState);
    }
}


//具体观察者角色(ConcreteObserver)
class ConcreteObserver implements Observer
{
    private String observerState;

    public void update(String state)
    {
        observerState = state;
        System.out.println("状态为: "+observerState);
    }
}


/**
 * 推模型和拉模型
 * 在观察者模式中，又分为推模型和拉模型两种方式。
 * 1. 推模型：主题对象向观察者推送主题的详细信息，不管观察者是否需要，推送的信息通常是主题对象的全部或部分数据。
 * 2. 拉模型：主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取，
 * 相当于是观察者从主题对象中拉数据。一般这种模型的实现中，会把主题对象自身通过update()方法传递给观察者，
 * 这样在观察者需要获取数据的时候，就可以通过这个引用来获取了。
 */

/**
 * 将上面的代码修改一下，变为拉模型案例：
 * 1 抽象观察者角色Observer2，通常是把主题对象当做参数传递
 */

 interface Observer2
{
    public void update(Subject2 subject);
}

//具体观察者角色
class ConcreteObserver2 implements Observer2
{
    private String observerState;
    public void update(Subject2 subject)
    {
        observerState = ((ConcreteSubject2)subject).getState();
        System.out.println("状态为: "+observerState);
    }
}

abstract class Subject2
{
    private List<Observer2> list = new ArrayList<Observer2>();

    public void attach(Observer2 observer)
    {
        list.add(observer);
    }

    public void detach(Observer2 observer)
    {
        list.remove(observer);
    }

    public void notifyObservers()
    {
        int len = list.size();
        for(int i=0;i<len;i++)
        {
            list.get(i).update(this);
        }
    }
}

// 具体主题角色
class ConcreteSubject2 extends Subject2
{
    private String subjectState;

    public String getState(){
        return subjectState;
    }
    public void setState(String newState)
    {
        this.subjectState = newState;
        System.out.println("主题状态为： "+subjectState);
        this.notifyObservers();
    }
}

/**
 * 优缺点
 * 优点：
 * 1. Subject和Observer之间是松耦合的，分别可以各自独立改变。
 * 2. Subject在发送广播通知的时候，无需指定具体的Observer,Observer可以自己决定是否要订阅Subject的通知。
 * 缺点：
 * 1. 松耦合导致代码关系不明显，有时可能难以理解
 * 2. 如果一个Subject被大量Observer订阅的话，在广播通知的时候可能会有效率问题。
 *
 * 适用场景
 * 1. 对一个对象状态的更新，需要其他对象同步更新，而且其他对象的数量动态改变。
 * 2. 对象仅需要将自己的更新通知给其他对象而不需要知道其他对象的细节。
 *
 * JDK中的观察者模式：
 * java.util.EventListener
 * javax.servlet.http.HttpSessionBindingListener
 * javax.servlet.http.HttpSessionAttributeListener
 * javax.faces.event.PhaseListener
 */