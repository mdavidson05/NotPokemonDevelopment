package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gamePanel;


    public boolean upPressed, leftPressed, downPressed, rightPressed, pausePressed,enterPressed;
    public boolean checkDrawTime = false;
    public int turn = 1;

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();

        if (gamePanel.gameState == gamePanel.titleState) {
            titleState(input);
        }
        else if (gamePanel.gameState == gamePanel.playState) {
            playState(input);
        }
        else if (gamePanel.gameState == gamePanel.pauseState) {
            pauseState(input);
        }
        else if (gamePanel.gameState == gamePanel.dialogueState) {
            dialogueState(input);
        }
        else if (gamePanel.gameState == gamePanel.characterState) {
            characterState(input);
        }
        else if (gamePanel.gameState == gamePanel.fightState){
            fightState(input);
        }
        else if (gamePanel.gameState == gamePanel.attackState){
            attackState(input);
        }
        else if (gamePanel.gameState == gamePanel.swapState){
            swapState(input);
        }
    }

    public void fightState(int input){
        if (input == KeyEvent.VK_W)
        {
            gamePanel.battle.commandNumber--;
            if(gamePanel.battle.commandNumber < 0){
                gamePanel.battle.commandNumber = 4;
            }
        }
//        if (input == KeyEvent.VK_A)
//        {
//            gamePanel.ui.commandNumber++;
//
//        }
        if (input == KeyEvent.VK_S)
        {
            gamePanel.battle.commandNumber++;
            if (gamePanel.battle.commandNumber > 3){
                gamePanel.battle.commandNumber = 0;
            }

        }
//        if (input == KeyEvent.VK_D)
//        {
//            gamePanel.ui.commandNumber++;
//            if (gamePanel.ui.commandNumber > 2){
//                gamePanel.ui.commandNumber = 0;
//            }
//
//        }
        if (input == KeyEvent.VK_SPACE)
        {
            if(gamePanel.battle.commandNumber == 0){
                //draw fight subwindow
                gamePanel.gameState = gamePanel.attackState;
            }
            if(gamePanel.battle.commandNumber == 2){
                //draw fight subwindow
                gamePanel.gameState = gamePanel.swapState;
            }
            if(gamePanel.battle.commandNumber == 3){
                gamePanel.gameState = gamePanel.playState;
            }
        }
    }

    public void attackState(int input){
        if (input == KeyEvent.VK_W)
        {
            gamePanel.battle.commandNumber--;
            if(gamePanel.battle.commandNumber < 0){
                gamePanel.battle.commandNumber = 4;
            }
        }
//        if (input == KeyEvent.VK_A)
//        {
//            gamePanel.ui.commandNumber++;
//
//        }
        if (input == KeyEvent.VK_S)
        {
            gamePanel.battle.commandNumber++;
            if (gamePanel.battle.commandNumber > 3){
                gamePanel.battle.commandNumber = 0;
            }

        }
//        if (input == KeyEvent.VK_D)
//        {
//            gamePanel.ui.commandNumber++;
//            if (gamePanel.ui.commandNumber > 2){
//                gamePanel.ui.commandNumber = 0;
//            }
//
//        }
        if (input == KeyEvent.VK_SPACE)
        {
            if(gamePanel.battle.commandNumber == 0){
                //draw fight subwindow
//                gamePanel.gameState = gamePanel.attackState;
                gamePanel.battle.attack(gamePanel.battle.commandNumber,this);
            }
            if(gamePanel.battle.commandNumber == 2){
                //draw fight subwindow
//                gamePanel.gameState = gamePanel.attackState;
                gamePanel.battle.attack(gamePanel.battle.commandNumber,this);
            }
            if(gamePanel.battle.commandNumber == 3){
                gamePanel.gameState = gamePanel.playState;
            }
        }
    }

    public void swapState(int input){
        if (input == KeyEvent.VK_W)
        {
            gamePanel.battle.commandNumber--;
            if(gamePanel.battle.commandNumber < 0){
                gamePanel.battle.commandNumber = 4;
            }
        }
//        if (input == KeyEvent.VK_A)
//        {
//            gamePanel.ui.commandNumber++;
//
//        }
        if (input == KeyEvent.VK_S)
        {
            gamePanel.battle.commandNumber++;
            if (gamePanel.battle.commandNumber > 3){
                gamePanel.battle.commandNumber = 0;
            }

        }
//        if (input == KeyEvent.VK_D)
//        {
//            gamePanel.ui.commandNumber++;
//            if (gamePanel.ui.commandNumber > 2){
//                gamePanel.ui.commandNumber = 0;
//            }
//
//        }
        if (input == KeyEvent.VK_SPACE)
        {
            if(gamePanel.battle.commandNumber == 0){
                //draw fight subwindow
//                gamePanel.gameState = gamePanel.attackState;
                gamePanel.battle.switchPokemon(gamePanel.battle.commandNumber,turn);
            }
            if(gamePanel.battle.commandNumber == 1){
                //draw fight subwindow
//                gamePanel.gameState = gamePanel.attackState;
                gamePanel.battle.switchPokemon(gamePanel.battle.commandNumber,turn);
            }
            if(gamePanel.battle.commandNumber == 2){
                //draw fight subwindow
//                gamePanel.gameState = gamePanel.attackState;
                gamePanel.battle.switchPokemon(gamePanel.battle.commandNumber,turn);
            }
            if(gamePanel.battle.commandNumber == 3){
                gamePanel.battle.switchPokemon(gamePanel.battle.commandNumber,turn);
            }
        }
    }


    public void titleState(int input){
        if (input == KeyEvent.VK_W)
        {
            gamePanel.ui.commandNumber--;
            if(gamePanel.ui.commandNumber < 0){
                gamePanel.ui.commandNumber = 2;
            }
        }
        if (input == KeyEvent.VK_S)
        {
            gamePanel.ui.commandNumber++;
            if (gamePanel.ui.commandNumber > 2){
                gamePanel.ui.commandNumber = 0;
            }

        }
        if (input == KeyEvent.VK_SPACE)
        {
            if(gamePanel.ui.commandNumber == 0){
                gamePanel.gameState = gamePanel.playState;
            }
            if(gamePanel.ui.commandNumber == 2){
                System.exit(0);
            }
        }
    }

    public void playState(int input){
            if (input == KeyEvent.VK_W)
            {
                upPressed = true;
            }
            if (input == KeyEvent.VK_A)
            {
                leftPressed = true;
            }
            if (input == KeyEvent.VK_S)
            {
                downPressed = true;
            }
            if (input == KeyEvent.VK_D)
            {
                rightPressed = true;
            }

            if (input == KeyEvent.VK_SPACE)
            {
                enterPressed = true;
            }
            if (input == KeyEvent.VK_T){
                if(checkDrawTime == false){
                    checkDrawTime = true;
                }
                else if(checkDrawTime == true){
                    checkDrawTime = false;
                }
            }
            if (input == KeyEvent.VK_P)
            {
                if(gamePanel.gameState == gamePanel.playState) {
                    gamePanel.gameState = gamePanel.pauseState;

                }
                else if(gamePanel.gameState == gamePanel.pauseState){
                    gamePanel.gameState = gamePanel.playState;
                }
//                pausePressed = true;
            }

            if (input == KeyEvent.VK_C)
            {
                gamePanel.gameState = gamePanel.characterState;
            }
        }


    public void pauseState(int input){

        gamePanel.gameState = gamePanel.pauseState;

        if (input == KeyEvent.VK_P)
        {
             if(gamePanel.gameState == gamePanel.pauseState){
                gamePanel.gameState = gamePanel.playState;
            }
        }
                }




    public void dialogueState(int input) {
        if (input == KeyEvent.VK_SPACE) {
            gamePanel.gameState = gamePanel.playState;
        }
    }


    public void characterState(int input){
        if(input == KeyEvent.VK_C){
                gamePanel.gameState = gamePanel.playState;
            }
        if(input == KeyEvent.VK_W) {
            if (gamePanel.ui.slotRow != 0) {
                gamePanel.ui.slotRow--;
            }
        }
        if(input == KeyEvent.VK_A) {
            if (gamePanel.ui.slotCoL != 0) {
                gamePanel.ui.slotCoL--;
            }
        }

            if (input == KeyEvent.VK_S) {

                if (gamePanel.ui.slotRow != 3) {
                    gamePanel.ui.slotRow++;
                }
            }

            if (input == KeyEvent.VK_D) {
                if (gamePanel.ui.slotCoL != 3) {
                    gamePanel.ui.slotCoL++;
                }
            }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();

        if (input == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if (input == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if (input == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if (input == KeyEvent.VK_D)
        {
            rightPressed = false;
        }

    }
}
