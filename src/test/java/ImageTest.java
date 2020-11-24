import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

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
            BufferedImage bufferedImage = ImageIO.read(new File("D:/008.jpg"));
            assertNotNull(bufferedImage);
        } catch (Exception e) {
            fail("shibai le");
        }
    }
}
