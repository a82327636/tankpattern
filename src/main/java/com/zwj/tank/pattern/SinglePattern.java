package com.zwj.tank.pattern;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank.pattern
 * @ClassName: SingleParrtern
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/24 11:23
 * @Version: 1.0
 */
// 恶汉式
class SinglePattern {

    private static SinglePattern singlePattern = new SinglePattern();

    private SinglePattern(){
        System.out.println("SinglePattern execute");
    }

    public static SinglePattern getSinglePatternInstance(){
        System.out.println("getSinglePatternInstance execute");
        return singlePattern;
    }

}

// 懒汉式
class SinglePattern1 {
    private static SinglePattern1 singlePattern1 = null;
    private SinglePattern1(){
        System.out.println("SinglePattern1 execute");
    }
    public static SinglePattern1 getSinglePattern1Instance(){
        System.out.println("getSinglePatternInstance execute");
        if(singlePattern1==null){
            singlePattern1 = new SinglePattern1();
        }
        return singlePattern1;
    }
}


// 双重检索
class SinglePattern2 {

    private volatile static SinglePattern2 singlePattern2 = null; // volatile的应用是避免重排序下，对象只new了一半，分配了内存地址但是没有执行完初始化
    private SinglePattern2(){
        System.out.println("SinglePattern2 execute");
    }
    public static SinglePattern2 getSinglePattern2Instance(){
        System.out.println("getSinglePatternInstance execute");
        if(singlePattern2==null){
            synchronized (SinglePattern2.class){
                if(singlePattern2==null){
                    singlePattern2 = new SinglePattern2();
                }
            }

        }
        return singlePattern2;
    }

}



// 静态内部类
class SinglePatternInside {

    public static int count = 0;

    public static class Inside{
        private static SinglePatternInside singlePatternInside = new SinglePatternInside();
        private Inside(){
            System.out.println("内部构造方法");
        }
    }
    private SinglePatternInside(){
        if(count > 0){ // 使用反射可以进入私有的构造函数
            System.out.println("单例被破坏啦");
        }
        System.out.println("外部构造方法");

    }

    public static SinglePatternInside getSinglePatternInside(){
      return Inside.singlePatternInside;
    }

}


enum SingelPatternEnum{
    INSTANCE ;
    public String getInstance(){
        return INSTANCE.toString();
    }
}

class Execute{
    public static void main(String[] args) {

         // SinglePattern singlePattern = new SinglePattern(); 将构造函数私有，就不能使用new

//        SinglePattern singlePattern = SinglePattern.getSinglePatternInstance();
//        SinglePattern singlePattern1 = SinglePattern.getSinglePatternInstance();
//        System.out.println(singlePattern == singlePattern1);



//        SinglePattern1 singlePattern = SinglePattern1.getSinglePattern1Instance();
//        SinglePattern1 singlePattern1 = SinglePattern1.getSinglePattern1Instance();
//        System.out.println(singlePattern == singlePattern1);


//        SinglePattern2 singlePattern = SinglePattern2.getSinglePattern2Instance();
//        SinglePattern2 singlePattern1 = SinglePattern2.getSinglePattern2Instance();
//        System.out.println(singlePattern == singlePattern1);


//        SinglePatternInside singlePattern = SinglePatternInside.getSinglePatternInside();
//        SinglePatternInside singlePattern1 = SinglePatternInside.getSinglePatternInside();
//        System.out.println(singlePattern == singlePattern1);


        SingelPatternEnum singlePattern = SingelPatternEnum.INSTANCE;
        SingelPatternEnum singlePattern1 = SingelPatternEnum.INSTANCE;
        System.out.println(singlePattern == singlePattern1);
    }

}
