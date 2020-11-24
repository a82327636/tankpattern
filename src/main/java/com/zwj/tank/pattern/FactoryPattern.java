package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: FactoryPattern
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/24 13:51
 * @Version: 1.0
 */
//// 简单工厂
//class FactoryPattern {
//    public void operation(int i){
//        if(i == 0){
//            new Operation1().call();
//        }else if(i == 1){
//            new Operation2().call();
//        }
//    }
//}
//
//interface OperationInterFace{
//    public void call();
//}
//
//class Operation1 implements OperationInterFace{
//    public void call(){
//        System.out.println("i am operation1");
//    }
//}
//
//class Operation2 implements OperationInterFace{
//    public void call(){
//        System.out.println("i am operation2");
//    }
//}



// 工厂方法

//interface FactoryInterface{
//    public OperationInterFace operation();
//}
//
//class FactoryPattern1 implements FactoryInterface{
//    public OperationInterFace operation(){
//        return new Operation1();
//    }
//}
//
//class FactoryPattern2 implements FactoryInterface{
//    public OperationInterFace operation(){
//        return new Operation2();
//    }
//}
//
//interface OperationInterFace{
//    public void call();
//}
//
//class Operation1 implements OperationInterFace{
//    public void call(){
//        System.out.println("i am operation1");
//    }
//}
//
//class Operation2 implements OperationInterFace{
//    public void call(){
//        System.out.println("i am operation2");
//    }
//}

// 抽象工厂方法
interface FactoryInterface{
    public OperationInterFace operation();
    public OperationInterFace1 operation1();
}

class FactoryPattern1 implements FactoryInterface{
    public OperationInterFace operation(){
        return new Operation1();
    }
    public OperationInterFace1 operation1(){
        return new Operation11();
    }
}

class FactoryPattern2 implements FactoryInterface{
    public OperationInterFace operation(){
        return new Operation2();
    }
    public OperationInterFace1 operation1(){
        return new Operation21();
    }
}

interface OperationInterFace{
    public void call();
}

interface OperationInterFace1{
    public void call1();
}

class Operation1 implements OperationInterFace{
    public void call(){
        System.out.println("i am operation1");
    }
}

class Operation11 implements OperationInterFace1{
    public void call1(){
        System.out.println("i am call1");
    }
}

class Operation2 implements OperationInterFace{
    public void call(){
        System.out.println("i am operation2");
    }
}

class Operation21 implements OperationInterFace1{
    public void call1(){
        System.out.println("i am call2");
    }
}

class Exceute{
    public static void main(String[] args) {
        // 简单工厂
//        FactoryPattern factoryPattern = new FactoryPattern();
//        factoryPattern.operation(0);


        // 工厂方法
//        FactoryInterface factoryInterface = new FactoryPattern1();
//        factoryInterface.operation().call();
//        FactoryInterface factoryInterface1 = new FactoryPattern2();
//        factoryInterface1.operation().call();

        // 抽象工厂
        FactoryInterface factoryInterface = new FactoryPattern1();
        factoryInterface.operation().call();
        factoryInterface.operation1().call1();
        FactoryInterface factoryInterface1 = new FactoryPattern2();
        factoryInterface1.operation().call();
        factoryInterface1.operation1().call1();
    }
}
