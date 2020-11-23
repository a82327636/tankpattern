import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ProjectName: tankpattern
 * @Package: PACKAGE_NAME
 * @ClassName: TankFrame
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/23 10:58
 * @Version: 1.0
 */
public class TankFrame extends Frame {

    public TankFrame(){

        setSize(800,600);
        setResizable(true);
        setVisible(true);
        setTitle("tank war");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g){
        // System.out.println("paint");
        g.fillRect(200,200,50,50);
    }


}
