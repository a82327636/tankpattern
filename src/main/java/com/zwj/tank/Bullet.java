package com.zwj.tank;

import sun.misc.Cache;

import java.awt.*;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank
 * @ClassName: Bullet
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/23 15:26
 * @Version: 1.0
 */
public class Bullet {

    private static final int SPEED = 5;
    private static int WIDTH = 30,HEIGHT = 30;
    private int x,y;
    private Dir dir;
    private TankFrame tf;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT); // 绘画圆形
        g.setColor(c);
        move();
    }


    private void move() {
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }
}
