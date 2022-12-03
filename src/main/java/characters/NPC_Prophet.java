package characters;

import handlers.GamePanel;
import moves.Moves;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NPC_Prophet extends Entity {

    private String text;


    public NPC_Prophet(GamePanel gamePanel) {
        super(gamePanel);
        direction = "backward";
        speed = 1;




        getNPCImage();
        setDialogue();

        canFightPlayer();
    }





    public void getNPCImage() {

        //system.getproperty("user.dir")
        forward1 = setup("NPC_Prophet/forwardLeft");
        forward2 = setup("NPC_Prophet/forwardRight");
        backwards1 = setup("NPC_Prophet/backwardLeft");
        backwards2 = setup("NPC_Prophet/backwardRight");
        left1 = setup("NPC_Prophet/leftLeft");
        left2 = setup("NPC_Prophet/leftStill");
        right1 = setup("NPC_Prophet/rightRight");
        right2 = setup("NPC_Prophet/rightStill");
        forwardStill = setup("NPC_Prophet/forwardStill");
    }

    public String getText() {
        return text;
    }

    public void setDialogue(){
        dialogues[0] = "Congratulations, you have reached \nthe end of your journey";
        dialogues[1] = "Wait what? There are no pokemon in\nthe wild? Wait... this is the edge\n of the entire universe?";
        dialogues[2] = "Yes our universe is a simulation";
        dialogues[3] = "Fuck...";
        dialogues[4] = "Indeed";

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
