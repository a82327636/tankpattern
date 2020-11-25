package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: BridgePattern
 * @Author: zwj
 * @Description: 注释 桥接模式
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 *
 * 意图：将抽象与实现解耦。
 *  桥接模式主要应对的是由于实际的需要，某个类具有两个或者两个以上的维度变化（违反了SRP原则），
 * 如果只是用继承将无法实现这种需要，或者使得设计变得相当臃肿。
 * @Date: 2020/11/25 15:34
 * @Version: 1.0
 */

/**
 * 桥接模式所涉及的角色
 * 1. Abstraction：定义抽象接口，拥有一个Implementor类型的对象引用
 * 2. RefinedAbstraction：扩展Abstraction中的接口定义
 * 3. Implementor：是具体实现的接口，Implementor和RefinedAbstraction接口并不一定完全一致，
 *     实际上这两个接口可以完全不一样Implementor提供具体操作方法，而Abstraction提供更高层次的调用
 * 4. ConcreteImplementor：实现Implementor接口，给出具体实现
 */
public class BridgePattern {

    public static void main(String[] args) {
        Road road = new CementRoad(new Car());
        road.driveOnRoad();
    }

}

/**
 * 举个例子好了：交通工具在路上行驶，这里有两个维度的变化，首先交通工具的类型不同，其次路也分水泥路和柏油路。
 */

// 交通工具（Implementor）
interface Vehicle
{
    public void drive();
}

// 具体的交通工具（ConcreteImplementor）
class Car implements Vehicle
{
    public void drive()
    {
        System.out.print("小轿车");
    }
}
class Bus implements Vehicle
{
    public void drive()
    {
        System.out.print("大巴");
    }
}

// 抽象的路（Abstraction）
abstract class Road
{
    protected Vehicle vehicle;

    public Road(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public abstract void driveOnRoad();
}

// 具体的路
class UnpavedRoad extends Road
{
    public UnpavedRoad(Vehicle vehicle)
    {
        super(vehicle);
    }

    @Override
    public void driveOnRoad()
    {
        super.vehicle.drive();
        System.out.println("行驶在石子路");
    }
}

class CementRoad extends Road
{
    public CementRoad(Vehicle vehicle)
    {
        super(vehicle);
    }

    @Override
    public void driveOnRoad()
    {
        super.vehicle.drive();
        System.out.println("行驶在水泥路");
    }
}

/**
 * 桥接模式的应用一般在“两个非常强的变化维度”，有时候即使有两个变化的维度，
 * 但是某个方向的变化维度并不剧烈——换而言之两个变化不会导致纵横交错的结果，并不一定要使用桥接模式
 *
 * 使用场景
 *
 * 如果你不希望在抽象和实现部分采用固定的绑定关系，可以采用桥接模式，
 * 来把抽象和实现部分分开，然后在程序运行期间来动态的设置抽象部分需要用到的具体的实现，还可以动态切换具体的实现。
 *
 * 如果出现抽象部分和实现部分都应该可以扩展的情况，可以采用桥接模式，让抽象部分和实现部分可以独立的变化，
 * 从而可以灵活的进行单独扩展，而不是搅在一起，扩展一边会影响到另一边。
 *
 * 如果希望实现部分的修改，不会对客户产生影响，可以采用桥接模式，客户是面向抽象的接口在运行，实现部分的修改，
 * 可以独立于抽象部分，也就不会对客户产生影响了，也可以说对客户是透明的。
 *
 * 如果采用继承的实现方案，会导致产生很多子类，对于这种情况，可以考虑采用桥接模式，分析功能变化的原因，
 * 看看是否能分离成不同的纬度，然后通过桥接模式来分离它们，从而减少子类的数目。
 *
 * Jdk中的桥接模式：JDBC
 * JDBC连接数据库的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不动，
 * 原因就是JDBC提供了统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
 */