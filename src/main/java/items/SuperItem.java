package items;

import handlers.GamePanel;
import handlers.Scaling;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperItem {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    Scaling scaling = new Scaling();



    public void draw(Graphics2D graphics2, GamePanel gamePanel) {
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenY;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


        //Dynamic rendering loop. Remember to fix the boundaries
        if(worldX + gamePanel.tileSize >gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

            graphics2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
//should be screenX and Screen Y instead of 0, 0
        }
    }
}
