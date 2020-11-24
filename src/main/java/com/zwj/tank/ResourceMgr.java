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

    static{
        try {
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_down.png"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_left.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_up.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("config/images/tank_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
