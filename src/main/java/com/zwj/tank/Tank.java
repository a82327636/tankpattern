package com.zwj.tank;

import java.awt.*;
import java.util.Random;

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
    public static int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();

    private Random random = new Random();

    private boolean moving = false;
    private boolean liveing = true;

    private Group group = Group.BAD;
    private TankFrame tf;

    public Tank(int x, int y, Dir dir, Group group,TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }


    public void paint(Graphics g){
        if(!liveing){
            tf.tanks.remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
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

        if(random.nextInt(10)>8){ // 移动之后，随机打子弹
            this.fire();
        }
    }




    public void fire() {
        int bulletX = this.x + Tank.WIDTH/2 - Bullet.WIDTH;
        int bulletY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bulletX,bulletY,this.dir,this.tf,this.group));
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.liveing = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
