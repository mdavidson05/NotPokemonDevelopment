package characters;

//import Battle.BattleMechanics;
import handlers.GamePanel;
import handlers.Scaling;
import moves.Moves;
import pokemon.PokemonConstructor;
import pokemon.PokemonCreator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Entity {
    //Motion
    public int worldX,worldY;
    public int speed;

    //Animation
    GamePanel gamePanel;
    public BufferedImage forward1, forward2, backwards1, backwards2, left1, left2, right1, right2,forwardStill,backwardStill; //Buffered Image describes an image that contains data we can access
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle playerHitbox = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public boolean collisionOn = false;
    public int standCounter = 0;
    public int actionCounter =0;
    String dialogues[] = new String[20];
    int dialogueindex = 0;
    public ArrayList<PokemonCreator> party = new ArrayList<>();
    public ArrayList<Moves> moveSet = new ArrayList<>();
    public ArrayList baseStats = new ArrayList<>();
    PokemonCreator pokemonCreator;
    private boolean canFight = false;
    public ArrayList<PokemonCreator> battleSlot = new ArrayList<>();
    private boolean fightIsWon;


    public Entity(GamePanel gamePanel){
        this.gamePanel=gamePanel;
//        battleSlot.add();
    }

//    public Moves selectedMove(){
//        //need to figure out player input
//        //user input == int selected
//        //selected = moveSet.get(input)
//        //return selected
//    }

//    public Moves randomMove(){
//        //need to figure out player input
//        //user input == int selected
//        //selected = moveSet.get(input)
//        //return selected
//    }

    public boolean canFightPlayer(){
        if(party.size() >=1 && checkHasWon(party) == false){
            canFight = true;
        }else{canFight = false;}

        return canFight;

    }


    public boolean checkHasWon(ArrayList<PokemonCreator> party){
        fightIsWon = false;
        int faintCounter =0;
        for(int i = 0; i < party.size(); i++){
            if(party.get(i).hp <= 0){
                faintCounter++;
            }
            }
        if(faintCounter == party.size()){
            fightIsWon = true;
        }
        return fightIsWon;
        }

    public void setBattleSlot(){
        if(party.size() >0){
        battleSlot.add(party.get(0));
    }}

//    public PokemonCreator selectPokemon(){
//        //need to figure out player input
//        //user input == int selected
//        //selected = party.get(input)
//        //return selected
//    }

    public void setAction(){

    }
    public void speak(){

        if(dialogues[dialogueindex] == null){
            dialogueindex = 0;
        }
        gamePanel.ui.currentDialogue = dialogues[dialogueindex];
        dialogueindex ++;

        switch(gamePanel.player.direction){
            case "forward":
                direction = "backward";
                break;
            case "backward":
                direction = "forward";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;

        }
    }

    public void update(){
        setAction();

        collisionOn = false;
        gamePanel.collisionCheck.checkTile(this);
        gamePanel.collisionCheck.checkItem(this, false);
        gamePanel.collisionCheck.checkPlayer(this);

        if(collisionOn == false) {
            switch(direction){
                case "forward":
                    worldY -= speed;
                    break;
                case "backward":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }


        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
        else {
            standCounter++;
            if (standCounter == 20) {
                spriteNumber = 1;
                standCounter = 0;
            }
        }
    }



    public BufferedImage setup(String imagePath){
        Scaling scaling = new Scaling();
        BufferedImage scaledImage = null;

        try{
            scaledImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath+".png"));
            scaledImage = scaling.scaleImage(scaledImage, gamePanel.tileSize, gamePanel.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }
        return scaledImage;
    }

    public void draw(Graphics2D graphics2){
        BufferedImage image = null;
//        image = forwardStill;

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenY;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


        //Dynamic rendering loop. Remember to fix the boundaries
        if(worldX + gamePanel.tileSize >gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

            switch(direction) {
                case "forward":
                    if(spriteNumber == 1){
                        image = forward1;
                    }
                    if(spriteNumber ==2){
                        image = forward2;
                    }
                    break;
                case "backward": {
                    if(spriteNumber == 1){
                        image = backwards1;
                    }
                    if(spriteNumber ==2){
                        image = backwards2;
                    }
                    break;
                }
                case "left": {
                    if(spriteNumber == 1){
                        image = left1;
                    }
                    if(spriteNumber ==2){
                        image = left2;
                    }
                    break;
                }
                case "right": {
                    if(spriteNumber == 1){
                        image = right1;
                    }
                    if(spriteNumber ==2){
                        image = right2;
                    }
                    break;
                }
            }

            graphics2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}}
