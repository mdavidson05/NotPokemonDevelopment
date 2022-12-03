package handlers;

import handlers.GamePanel;
import handlers.Scaling;
import moves.Moves;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Pokeball extends PokemonCreator {

    private BufferedImage drawimage = null;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    Scaling scaling = new Scaling();


    public Pokeball(GamePanel gamePanel, PokemonCreator pokemon) {

        super(pokemon.name, pokemon.hp, pokemon.level, pokemon.getPokemonTypes(), pokemon.getXp(), pokemon.isAwake(), pokemon.getID(), pokemon.getHeight(), PokemonCreator.getMoveList(), PokemonCreator.getBaseStats());
        this.gamePanel = gamePanel;
        this.pokemon = pokemon;
    }

    PokemonCreator pokemon;
    GamePanel gamePanel;


    public void setDrawimage(BufferedImage drawimage) {
        this.drawimage = drawimage;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    {
        setName("pokeball");
        try {
            BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Items/Pokeball.png"));
            setDrawimage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCollision(true);

    }

    public void draw(Graphics2D graphics2, GamePanel gamePanel) {
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenY;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


        //Dynamic rendering loop. Remember to fix the boundaries
        if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {

            graphics2.drawImage(drawimage, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}

