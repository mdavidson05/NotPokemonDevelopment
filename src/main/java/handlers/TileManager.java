package handlers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    public int[][][] mapTileNumber;
    String mapPath;
    //NewBarkTown
    //320x288
    //320/16 x 288/16 = 20x18px
    //IF player xpositions and ypositinon == correct number load map2

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[50]; // will expand when developing more areas
        mapTileNumber = new int [gamePanel.maxMap][gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("Maps/NewBarkTownMap.txt", 0);
        loadMap("Maps/OakLab.txt",1);
        loadMap("Maps/Route1.txt",2);
        loadMap("Maps/SandTown.txt",3);

    }
    public void getTileImage() {
            setup(0, "tree", true);
            setup(1, "Roof", true);
            setup(2, "Grass", false);
            setup(3, "window BR", true);
            setup(4, "window BL", true);
            setup(5, "Building", true);
            setup(6, "Sign", true);
            setup(7, "Door", false);
            setup(8, "Sand", false);
            setup(9, "water", true);
            setup(10, "healingmachineTL", true);
            setup(11, "bin", true);
            setup(12, "bookcase", true);
            setup(13, "carpet", false);
            setup(14, "computerdesk", true);
            setup(15, "floor", false);
            setup(16, "tableBR", true);
            setup(17, "tableM", true);
            setup(18, "tableTL", true);
            setup(19, "tableTR", true);
            setup(20, "tableTM", true);
            setup(21, "tableBL", true);
            setup(22, "healingmachineTR", true);
            setup(23, "healingmachineBL", true);
            setup(24, "healingmachineBR", true);
            setup(25, "bollard", true);
            setup(26, "hedge", true);
            setup(27, "Charmander", true);
            setup(28, "Squirtle", true);
            setup(29, "Bulbasaur", true);







//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }

    }
    public void setup(int index, String imagePath, boolean collision){
        Scaling scaling = new Scaling();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/"+imagePath+".png"));
            tile[index].image = scaling.scaleImage(tile[index].image, gamePanel.tileSize, gamePanel.tileSize);
            tile[index].collision = collision;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setImagePath(String mapPath) {
        this.mapPath = mapPath;
    }

    public void loadMap(String mapPath, int map) {

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row= 0;

            while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
                String line = br.readLine();

                while(col < gamePanel.maxWorldCol) {
                    String numbers[] = line.split(" ");
//                    char numbers[] = line.toCharArray();



                    int num = Integer.parseInt(String.valueOf(numbers[col]));

                    mapTileNumber[map][col][row] = num;
                    col++;
                }
                if(col == gamePanel.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D graphics2){
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gamePanel.maxScreenCol && worldRow < gamePanel.maxScreenRow){

            int tileNumber = mapTileNumber[gamePanel.currentMap][worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenY;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


            //Dynamic rendering loop. Remember to fix the boundaries
            if(worldX + gamePanel.tileSize >gamePanel.player.worldX - gamePanel.player.screenX &&
            worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
            worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
            worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

                graphics2.drawImage(tile[tileNumber].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
//should be screenX and Screen Y instead of 0, 0
            }

            worldCol++;


            if (worldCol == gamePanel.maxScreenCol) {
                worldCol = 0;
                worldRow++;

            }
        }
//        graphics2.drawImage(tile[0].image, 0, 0, gamePanel.screenWidth,gamePanel.screenHeight, null);
    }
}
