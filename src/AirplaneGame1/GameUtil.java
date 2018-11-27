package AirplaneGame1;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

public class GameUtil {
    private GameUtil(){}
    public static Image getImage(String path){
        BufferedImage image = null;
        try{
            URL url = GameUtil.class.getClassLoader().getResource(path);
            image = ImageIO.read(url);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
