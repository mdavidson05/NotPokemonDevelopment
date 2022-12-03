package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Item extends SuperItem{

    public Item(){
        name = "item";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Items/Item.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
