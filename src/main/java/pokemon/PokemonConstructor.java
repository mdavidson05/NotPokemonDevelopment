package pokemon;

import handlers.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public enum PokemonConstructor {

    CHARMANDER(1, 2, 15),
    CHARMELION(2, 3, 40),
    CHARIZARD(3, 200, 101),
    SQUIRTLE(4, 5, 15),
    WHARTORTLE(5, 6, 40),
    BLASTOISE(6, 201, 101),
    BULBASAUR(7, 8, 15),
    IVYSAUR(8, 9, 40),
    VENOSAUR(9, 202, 101),;


    private final int pokeID;
    //enum class
    private final int evolvesIntoID;
    private final int evolvesAtLevel;
    public int worldX, worldY;
    public BufferedImage image;



    PokemonConstructor(int pokeID, int evolvesIntoID, int evolvesAtLevel) {
        this.pokeID = pokeID;
        this.evolvesIntoID = evolvesIntoID;

        this.evolvesAtLevel = evolvesAtLevel;
    }

    public int getPokeID() {
        return pokeID;
    }

    public int getEvolvesIntoID() {
        return evolvesIntoID;
    }

    public int getEvolvesAtLevel() {
        return evolvesAtLevel;
    }

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

//    public Handlers.PokemonTypes[] getPokemonTypes() {
//        return pokemonTypes;
//    }

//    PokemonConstructor[] pokemon = PokemonConstructor.values();

}