package characters;

import handlers.*;
import handlers.Pokeball;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {

    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;
    public boolean inFight;
    public int standCounter = 0;
    public int hasItem = 0;
    public int hasPokeball = 0;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int inventorySize = 20;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(gamePanel);
        this.keyHandler = keyHandler;
        battleSlot = new ArrayList<>();
        party = new ArrayList<>();

        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        screenY = gamePanel.screenHeight/2 - (gamePanel.tileSize/2);
        playerHitbox = new Rectangle(8,16,32, 32); //need to adjust when resizing
        solidAreaDefaultX = playerHitbox.x;
        solidAreaDefaultY = playerHitbox.y;
        inFight = false;




        setDefaultValues();
        getPlayerImage();




    }

    public void setDefaultValues() {
        //set speed and starting position of player on map
        worldX = gamePanel.tileSize+(screenX)/2;
        worldY = gamePanel.tileSize+(screenY)/2;
        speed = 4;
        direction = "backward";
        setItems();
//        PokemonCreator pokemon1 = new PokemonCreator("Charmander", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);
//        PokemonCreator pokemon2 = new PokemonCreator("Charmeleon", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);
//        PokemonCreator pokemon3 = new PokemonCreator("Charizard", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);
//        PokemonCreator pokemon4 = new PokemonCreator("Blastoise", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);


//        pokemon4.populateStartingMoves();

//        party.add(pokemon1);
//        party.add(pokemon2);
//        party.add(pokemon3);
//        party.add(pokemon4);

        setBattleSlot();
    }

    public PokemonCreator getStartingPokemon(int index){
        PokemonCreator selected = null;
        if(index == 0){
            PokemonCreator charmander = new PokemonCreator("Charmander", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);
            charmander.populateStartingMoves();
            selected = charmander;
        }
        if(index == 1){
            PokemonCreator squirtle = new PokemonCreator("Squirtle", 20,1, PokemonTypes.WATER, 5,true,2,10,moveSet, baseStats);
            squirtle.populateStartingMoves();

            selected = squirtle;
        }
        if(index == 2){
            PokemonCreator bulbasaur = new PokemonCreator("Bulbasaur", 20,1, PokemonTypes.GRASS, 5,true,3,10,moveSet, baseStats);
            bulbasaur.populateStartingMoves();

            selected=  bulbasaur;
        }
        if(index == 3){
            PokemonCreator charizard = new PokemonCreator("Charizard", 100,1, PokemonTypes.FIRE, 5,true,4,50,moveSet, baseStats);
            charizard.populateStartingMoves();

            selected=  charizard;
        }
        return selected;
    }

    public void setItems(){
//        inventory.add(potion);
    }

    public void getPlayerImage() {
//        try {
            //system.getproperty("user.dir")
//            forward1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Forward_Left.png"));
//            forward2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Forward_Right.png"));
//            backwards1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Backward_Left.png"));
//            backwards2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Backward_Right.png"));
//            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Left_Left.png"));
//            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Left_Still.png"));
//            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Right_Right.png"));
//            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Character_Moves/Right_Still.png"));
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }

        forward1 = setup("Character_Moves/Forward_Left");
        forward2 = setup("Character_Moves/Forward_Right");
        backwards1 = setup("Character_Moves/Backward_Left");
        backwards2 = setup("Character_Moves/Backward_Right");
        left1 = setup("Character_Moves/Left_Left");
        left2 = setup("Character_Moves/Left_Still");
        right1 = setup("Character_Moves/Right_Right");
        right2 = setup("Character_Moves/Right_Still");
        forwardStill = setup("Character_Moves/Forward_Still");



    }



    public void update() { //gets called 60x per second as in game loop

        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true) {

            if (keyHandler.upPressed == true) {
                direction = "forward";

            } else if (keyHandler.leftPressed == true) {
                direction = "left";

            } else if (keyHandler.downPressed == true) {
                direction = "backward";

            } else if (keyHandler.rightPressed == true) {
                direction = "right";

            }
            collisionOn = false;

            //CHECK OBJECT COLLISION
            int itemIndex = gamePanel.collisionCheck.checkItem(this, true);
            pickUpItem(itemIndex);

            //PickUp pokemon collision
            int pokemonIndex = gamePanel.collisionCheck.checkPokeball(this, true);
            pickUpPokeball(pokemonIndex);

            //Test tile collision
            gamePanel.collisionCheck.checkTile(this);

            //Check NPC collision
            int npcIndex = gamePanel.collisionCheck.checkEntity(this, gamePanel.npc);
//            if(gamePanel.npc instanceof NPC_Boy == true)
            interactNPC(npcIndex);

            //check Event
            gamePanel.eventHandler.checkEvent();

            //If Collision is flase, player can move
            if (collisionOn == false) {
                switch (direction) {
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
//            System.out.println(worldY);
//
//            if (worldY > 290){
//
//                inFight = true;
//            }


            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        } else {
            standCounter++;
            if (standCounter == 20) {
                spriteNumber = 1;
                standCounter = 0;
            }
        }
    }

    private void interactNPC(int npcIndex) {
        if (npcIndex != 999) {
            if (keyHandler.enterPressed == true) {
                gamePanel.gameState = gamePanel.dialogueState;
                gamePanel.npc[gamePanel.currentMap][npcIndex].speak();
                if (gamePanel.npc[gamePanel.currentMap][npcIndex] instanceof NPC_Boy) {
                    gamePanel.ui.setNpcType(2);
                }
                if (gamePanel.npc[gamePanel.currentMap][npcIndex] instanceof NPC_ProfOak) {
                    gamePanel.ui.setNpcType(1);
                }
                gamePanel.keyHandler.enterPressed = false;
            }
        }
    }

    public void pickUpItem(int index){
        if (index != 999){
            String itemName = gamePanel.item[gamePanel.currentMap][index].name;

            switch(itemName){
                case "item":
                    hasItem ++;
                    gamePanel.item[gamePanel.currentMap][index] = null;
                    System.out.println("item: "+ hasItem); // line is not printing. Ask for help
                    break;
                case "pokeball":
                    Pokeball starter = gamePanel.pokeball[gamePanel.currentMap][index];
                    gamePanel.player.party.add(starter);
//                    gamePanel.player.party.add(gamePanel.item[gamePanel.currentMap][index])
                    gamePanel.item[gamePanel.currentMap][index] = null;
//                    System.out.println("Pokeball: "+ hasPokeball);

            }
        }
    }
    public void pickUpPokeball(int index){
        if (index != 999){
            String pokeballName = gamePanel.pokeball[gamePanel.currentMap][index].name;

            switch(pokeballName){
                case "pokeball":
                    Pokeball starter = gamePanel.pokeball[gamePanel.currentMap][index];
                    gamePanel.player.party.add(starter);
                    if(gamePanel.player.party.size() <= 1 ) {
                        PokemonCreator selectedStarter = gamePanel.player.party.get(0);
                        battleSlot.add(selectedStarter);
                    }
                    gamePanel.pokeball[gamePanel.currentMap][index] = null;
                    System.out.println("Pokeball: "+ hasPokeball);

            }
        }
    }

    public void draw(Graphics2D graphics2){

//        graphics2.setColor(Color.white);
//        graphics2.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize);
        BufferedImage image = null;
        image = forwardStill;
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


    }

