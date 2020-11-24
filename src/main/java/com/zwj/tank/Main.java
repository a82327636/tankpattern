package com.zwj.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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


        // 初始化地方坦克
        for(int i = 0;i<5;i++){
            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,tankFrame));
        }

        while(true){
            Thread.sleep(50l);
            tankFrame.repaint();
        }
    }




}
