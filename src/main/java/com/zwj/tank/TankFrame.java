package com.zwj.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ProjectName: tankpattern
 * @Package: PACKAGE_NAME
 * @ClassName: com.zwj.tank.TankFrame
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/23 10:58
 * @Version: 1.0
 */
public class TankFrame extends Frame {

    int x = 200,y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;


    public TankFrame(){

        setSize(800,600);
        setResizable(true);
        setVisible(true);
        setTitle("tank war");

        this.addKeyListener(new MykeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g){
        //System.out.println("paint");
        g.fillRect(x,y,50,50);
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

        //x += 10;
        //y += 10;
    }


    // 键盘监听
    class MykeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    //x -= 10;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    //y -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    //x += 10;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                   // y += 10;
                    break;
                default:
                    break;

            }

            setMainTankDir();
        }


        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;

            }
            setMainTankDir();
        }


        private void setMainTankDir() {
            if(bL) dir = Dir.LEFT;
            if(bU) dir = Dir.UP;
            if(bR) dir = Dir.RIGHT;
            if(bD) dir = Dir.DOWN;
        }
    }

}
