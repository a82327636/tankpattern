package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: StatePattern
 * @Author: zwj
 * @Description: 注释 状态模式
 * 案例
 * 以酒店订房为例，房间的状态有：空闲、预订、入住。那么空闲房间的状态可以转变为：预订、入住。
 * 已预订状态房间的状态可以转变为：入住、取消预订。已入住房间的状态可以转变为：退房
 * @Date: 2020/11/24 17:41
 * @Version: 1.0
 *
 * 优缺点
 * 优点：
 * 1. 封装了转换规则。
 * 2. 枚举可能的状态，在枚举状态之前需要确定状态种类。
 * 3. 将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为。
 * 4. 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
 * 缺点：
 * 1. 状态模式的使用必然会增加系统类的对象的个数
 * 2. 状态模式的结构与实现都较为复杂，如果使用不当讲导致程序结构和代码的混乱。
 * 3. 状态模式对“开闭原则”的支持并不太好，对于可以切换状态的状态模式，增加新的状态类需要修改那些负责状态转换的源代码，否则无法切换到新增状态；而且修改某个状态类的行为也需修改对应类的源代码。
 *
 * 适用场景
 * 1. 对象的行为依赖于它的状态（属性）并且可以根据它的状态而改变它的相关行为
 * 2. 代码中包含大量与对象状态相关的条件语句
 *
 * JDK中的状态模式：
 * java.util.Iterator
 * javax.faces.lifecycle.LifeCycle#execute()
 */

// 状态模式
class StatePattern {
    public static void main(String[] args) {
        Room[] rooms = new Room[2];

        for(int i=0;i<rooms.length;i++)
        {
            rooms[i] = new Room();
        }

        rooms[0].bookRoom();
        rooms[0].checkInRoom();
        rooms[0].bookRoom();
        System.out.println(rooms[0]);
        System.out.println("-------------");

        rooms[1].checkInRoom();
        rooms[1].bookRoom();
        rooms[1].checkOutRoom();
        rooms[1].bookRoom();
        System.out.println(rooms[1]);
    }
}



// 状态接口
interface State{
    public void bookRoom(); // 预订
    public void unsubscribeRoom(); // 注销
    public void checkInRoom(); // 入住
    public void checkOutRoom(); // 退房
}

// 环境角色
class Room{
    private State freeTimeState; // 空闲
    private State checkInState; // 已经入住
    private State bookedState; // 已经预订

    private State state;


    public Room(){
        freeTimeState = new FreeTimeState(this);
        checkInState = new CheckInState(this);
        bookedState = new BookedInState(this);
        state = freeTimeState;
    }

    public void bookRoom()
    {
        state.bookRoom();
    }
    public void unsubscribeRoom()
    {
        state.unsubscribeRoom();
    }
    public void checkInRoom()
    {
        state.checkInRoom();
    }
    public void checkOutRoom()
    {
        state.checkOutRoom();
    }

    public String toString()
    {
        return "该房间的状态是:"+getState().getClass().getName();
    }

    public State getFreeTimeState() {
        return freeTimeState;
    }

    public void setFreeTimeState(State freeTimeState) {
        this.freeTimeState = freeTimeState;
    }

    public State getCheckInState() {
        return checkInState;
    }

    public void setCheckInState(State checkInState) {
        this.checkInState = checkInState;
    }

    public State getBookedState() {
        return bookedState;
    }

    public void setBookedState(State bookedState) {
        this.bookedState = bookedState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

// 房间状态（空闲状态）
class FreeTimeState implements State{

    private Room hotelManagement;
    public FreeTimeState(Room hotelManagement)
    {
        this.hotelManagement = hotelManagement;
    }

    public void bookRoom() {
        System.out.println("预订成功！");
        this.hotelManagement.setState(this.hotelManagement.getBookedState());
    }


    public void unsubscribeRoom() {

    }


    public void checkInRoom() {
        System.out.println("入住成功");
        this.hotelManagement.setState(this.hotelManagement.getCheckInState());
    }


    public void checkOutRoom() {

    }
}


// 房间状态（入住状态）
class CheckInState implements State{

    private Room hotelManagement;

    public CheckInState(Room hotelManagement)
    {
        this.hotelManagement = hotelManagement;
    }

    public void bookRoom() {
        System.out.println("改房间已经入住了！");
    }


    public void unsubscribeRoom() {

    }


    public void checkInRoom() {
        System.out.println("改房间已经入住了！");
    }

    public void checkOutRoom() {
        System.out.println("退房成功！");
        this.hotelManagement.setState(this.hotelManagement.getFreeTimeState());
    }
}


// 房间状态（预订状态）
class BookedInState implements State{

    private Room hotelManagement;

    public BookedInState(Room hotelManagement)
    {
        this.hotelManagement = hotelManagement;
    }

    public void bookRoom() {
        System.out.println("改房间已预订！");
    }


    public void unsubscribeRoom() {
        System.out.println("成功退订！");
        this.hotelManagement.setState(this.hotelManagement.getFreeTimeState());
    }


    public void checkInRoom() {
        System.out.println("入住成功！");
        this.hotelManagement.setState(this.hotelManagement.getCheckInState());
    }

    public void checkOutRoom() {

    }
}

