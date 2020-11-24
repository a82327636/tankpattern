package com.zwj.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ProjectName: tankpattern
 * @Package: com.zwj.tank
 * @ClassName: ResourceMgr
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/24 9:21
 * @Version: 1.0
 */
public class ResourceMgr {

    public static BufferedImage tankL,tankU,tankR,tankD;

    public static BufferedImage bulletL,bulletU,bulletR,bulletD;



    static{
        try {
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_down.png"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_left.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_up.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_right.png"));


            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/bullet.png"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/bullet.png"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/bullet.png"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/bullet.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
