package com.zwj.tank;


/**
 * @ProjectName: tankpattern
 * @Package: PACKAGE_NAME
 * @ClassName: com.zwj.tank.Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/23 10:31
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();


        // 初始化敌人坦克
        for(int i = 0;i<5;i++){
            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tankFrame));
        }

        while(true){
            Thread.sleep(50l);
            tankFrame.repaint();
        }
    }




}
