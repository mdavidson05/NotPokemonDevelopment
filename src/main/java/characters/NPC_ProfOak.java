package characters;

import handlers.GamePanel;
import moves.Moves;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NPC_ProfOak extends Entity {

    private String text;


    public NPC_ProfOak(GamePanel gamePanel) {
        super(gamePanel);
        direction = "backward";
        speed = 1;




        getNPCImage();
        setDialogue();

        canFightPlayer();
    }





    public void getNPCImage() {

        //system.getproperty("user.dir")
        forward1 = setup("NPC_ProfOak/forwardLeft");
        forward2 = setup("NPC_ProfOak/forwardRight");
        backwards1 = setup("NPC_ProfOak/backwardLeft");
        backwards2 = setup("NPC_ProfOak/backwardRight");
        left1 = setup("NPC_ProfOak/leftLeft");
        left2 = setup("NPC_ProfOak/leftStill");
        right1 = setup("NPC_ProfOak/rightRight");
        right2 = setup("NPC_ProfOak/rightStill");
        forwardStill = setup("NPC_ProfOak/forwardStill");
    }

    public String getText() {
        return text;
    }

    public void setDialogue(){
        dialogues[0] = "Nice to see you Max, why don't \nyou grab a pokemon from the table!";
        dialogues[1] = "You're going to be a legend and \nbeat the elite four";
        dialogues[2] = "You can go now";
        dialogues[3] = "Dude... leave me alone";
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
