package characters;

import handlers.GamePanel;
import moves.Moves;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NPC_Boy extends Entity {

    private String text;


    public NPC_Boy(GamePanel gamePanel) {
        super(gamePanel);
        direction = "backward";
        speed = 1;
        party = new ArrayList<>();
        PokemonCreator pokemon1 = new PokemonCreator("Charmander", 20,1, PokemonTypes.FIRE, 5,true,1,10,moveSet, baseStats);
        pokemon1.populateStartingMoves();

        party.add(pokemon1);
        battleSlot = new ArrayList<>();



        getNPCImage();
        setDialogue();
        setBattleSlot();
        canFightPlayer();
    }





    public void getNPCImage() {

            //system.getproperty("user.dir")
            forward1 = setup("NPCs/ForwardLeft");
            forward2 = setup("NPCs/ForwardRight");
            backwards1 = setup("NPCs/BackwardLeft");
            backwards2 = setup("NPCs/BackwardRight");
            left1 = setup("NPCs/LeftLeft");
            left2 = setup("NPCs/LeftStill");
            right1 = setup("NPCs/RightRight");
            right2 = setup("NPCs/RightStill");
        forwardStill = setup("NPCs/ForwardStill");
    }

    public String getText() {
        return text;
    }

    public void setDialogue(){
        dialogues[0] = "Hello, old man";
        dialogues[1] = "I'm going to be a legend and \nbeat the elite four";
        dialogues[2] = "Think you can beat me?";
        dialogues[3] = "LETSSS GOOOO";
    }

    public void speak(){
        super.speak();

    }

    public void setAction() {

        actionCounter++;

        if (actionCounter == 120) {


            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; // pick random number
            if (randomNumber <= 25) {
                direction = "forward";
            }
            if (randomNumber > 25 && randomNumber <= 50) {
                direction = "backward";
            }
            if (randomNumber > 50 && randomNumber <= 75) {
                direction = "left";
            }
            if (randomNumber > 75 && randomNumber <= 100) {
                direction = "right";
            }

            actionCounter = 0;
        }
    }
}
