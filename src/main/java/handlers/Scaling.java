package handlers;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Scaling {
    public BufferedImage scaleImage(BufferedImage original, int width, int height){
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D graphics2 = scaledImage.createGraphics();
        graphics2.drawImage(original, 0, 0, width, height, null);
        graphics2.dispose();
        return scaledImage;
    }
}
