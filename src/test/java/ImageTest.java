import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

import static jdk.nashorn.internal.objects.Global.print;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;


/**
 * @ProjectName: tankpattern
 * @Package: PACKAGE_NAME
 * @ClassName: ImageTest
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/11/24 9:01
 * @Version: 1.0
 */
public class ImageTest {

    @Test
    public void test() {
        // fail("shibai le");
        // assertNotNull(new Object());

        try {
            //BufferedImage bufferedImage = ImageIO.read(new File("config/008.jpg"));
            //assertNotNull(bufferedImage);

            BufferedImage bufferedImage1= ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("config/008.jpg"));
            assertNotNull(bufferedImage1);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
