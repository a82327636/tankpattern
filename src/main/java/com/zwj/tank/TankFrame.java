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


    Tank tank = new Tank(200,200,Dir.DOWN);
    Bullet bullet = new Bullet(300,300,Dir.DOWN);
    static final int GAME_WIDTH = 800,GAME_HEIGHT=600;


    public TankFrame(){

        setSize(GAME_WIDTH,GAME_HEIGHT);
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


    Image offScreemImage = null;

    // 双缓存解决闪烁问题
    @Override
    public void update(Graphics g){
        if(offScreemImage == null){
            offScreemImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreemImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreemImage,0,0,null);
    }


    @Override
    public void paint(Graphics g){
        //System.out.println("paint");
        tank.paint(g);
        bullet.paint(g);
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
            if(!bL && !bU && !bR && !bD){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(bL) tank.setDir(Dir.LEFT);
                if(bU) tank.setDir(Dir.UP);
                if(bR) tank.setDir(Dir.RIGHT);
                if(bD) tank.setDir(Dir.DOWN);
            }
        }
    }

}
