package com.zwj.tank;

import java.awt.*;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank
 * @ClassName: Tank
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/23 14:58
 * @Version: 1.0
 */
public class Tank {

    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;

    private TankFrame tf;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50); // 绘画正方形
        g.setColor(c);
        move();
    }


    private void move() {
        if(!moving) return;

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
    }


    public void fire() {
      tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}
