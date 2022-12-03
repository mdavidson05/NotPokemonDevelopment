package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends SuperItem{

    {
        name = "door";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/Door.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
