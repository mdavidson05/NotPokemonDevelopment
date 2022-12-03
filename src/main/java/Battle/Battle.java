package Battle;

import characters.Entity;
import handlers.GamePanel;
import handlers.KeyHandler;
import moves.Moves;
import pokemon.PokemonCreator;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;



public class Battle {
    public int playerTurn = 1;
    private Entity player;
    private Entity npc;
    private Graphics2D graphics2;
    private GamePanel gamePanel;
    public int commandNumber = 0;
    private KeyHandler keyHandler;
    public Battle(Entity player, Entity npc, GamePanel gamePanel) {
        this.player = player;
        this.npc = npc;
        this.gamePanel = gamePanel;

    }

    public void attack(int index, KeyHandler keyHandler) {
        PokemonCreator playerPokemon = player.battleSlot.get(0);
        PokemonCreator npcPokemon = npc.battleSlot.get(0);


        if (playerTurn == 1) {
            Moves attack = playerPokemon.getMoveList().get(index);
            int move = attack.getBasePower();
            npcPokemon.setHp(npcPokemon.hp - move);
            if (npcPokemon.checkHasFainted() == false) {
                int randomIndex = randomSwap(1, npc.party.size());
                keyHandler.setTurn(2);
                switchPokemon(randomIndex, 2);
            }
            if(player.checkHasWon(npc.party) == true){
                gamePanel.gameState = gamePanel.playState;
                gamePanel.update(graphics2);
//                gamePanel.ui.drawCharacterScreen();
            } else{changePlayerTurn(playerTurn);}



            }

        if (playerTurn == 2 && gamePanel.gameState != gamePanel.fightState) {
            ArrayList<Moves> attack = npcPokemon.getMoveList();
            int moveIndex = randomAttack(npcPokemon, 0, 3);
            Moves move = attack.get(moveIndex);
            int moveDamage = move.getBasePower();
            playerPokemon.setHp(playerPokemon.hp - moveDamage);
            if (npcPokemon.checkHasFainted() == true) {
//                int randomIndex = randomSwap(1, npc.party.size());
                keyHandler.setTurn(1);

//                switchPokemon(randomIndex,1);
                if(npc.checkHasWon(player.party) == true){
                    gamePanel.setGameState(gamePanel.playState);
                }
            }

        }
        if(npc.checkHasWon(player.party) == false) {
            gamePanel.gameState = gamePanel.fightState;
        }

        changePlayerTurn(playerTurn);

    }

    public int randomAttack(PokemonCreator pokemon, int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

    public int randomSwap(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

    public void setPlayerTurn(int player){
        playerTurn = player;

    }

//
    public void changePlayerTurn(int playerTurn){
        if(playerTurn ==1){
            setPlayerTurn(2);
        }
        else if(playerTurn ==2){
            setPlayerTurn(1);
        }
    }
//    public void applyItem(){
//        selected = selectPokemon()
//                item = selectItem()
//                item.effect*pokemon.hp
//
//    }
//
    public void switchPokemon(int selected, int turn) {
        if (turn == 1) {
            if (playerTurn == 1) {
                PokemonCreator withdrawnPokemon = player.battleSlot.remove(0);
                PokemonCreator newPokemon = player.party.get(selected);
                player.battleSlot.add(newPokemon);
                player.party.add(withdrawnPokemon);
                changePlayerTurn(playerTurn);
                gamePanel.gameState = gamePanel.fightState;

            }
        }
        if (turn == 2) {
            if (playerTurn == 2) {
                if (npc.party.size() < selected) {
                    int newIndex = randomSwap(1, npc.party.size());
                    PokemonCreator withdrawnPokemon = npc.battleSlot.remove(0);
                    PokemonCreator newPokemon = npc.party.get(newIndex);
                    npc.battleSlot.add(newPokemon);
                    npc.party.add(withdrawnPokemon);
                    changePlayerTurn(playerTurn);
                }


            }
        }
    }
//
//    public void run(){
//        graphics.dispose();
//    }

    public void drawFightScreen(Graphics2D graphics2){
        graphics2.setColor(Color.black);
        graphics2.fillRect(0,0, gamePanel.screenWidth, gamePanel.screenHeight);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "Fight";
        int x = getXforCenterText(text, gamePanel, graphics2);
        int y = gamePanel.tileSize*3;

        //shadow
        graphics2.setColor(Color.gray);
        graphics2.drawString(text, x+5, y+5);

        graphics2.setColor(Color.white);
        graphics2.drawString(text,x,y);

        //Player1 stats
        x = gamePanel.tileSize;
        y = gamePanel.tileSize;
        graphics2.fillRoundRect(0,0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int playerHPNumber = player.battleSlot.get(0).hp;
        String playerName = player.battleSlot.get(0).name;
        int playerXPLevel = player.battleSlot.get(0).level;
        String playerLevel = String.valueOf(playerXPLevel);
        String hp = String.valueOf(playerHPNumber);
        graphics2.drawString(playerName,x,y);
        graphics2.drawString("hp: "+ hp,x,y+24);
        graphics2.drawString("lvl: "+playerLevel,x,y+48);

        //Player2 stats
        x = gamePanel.screenWidth - gamePanel.tileSize*4;
        y = gamePanel.tileSize;
        graphics2.setColor(Color.white);
        graphics2.fillRoundRect(gamePanel.screenWidth - gamePanel.tileSize*5, 0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int npcHPNumber = npc.battleSlot.get(0).hp;
        String npcName = npc.battleSlot.get(0).name;
        String npcHP = String.valueOf(npcHPNumber);
        graphics2.drawString(npcName, x, y);
        graphics2.drawString("hp: "+ npcHP,x,y+24);


        //Menu
        text = "Fight";
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        graphics2.setColor(Color.white);
        x = getXforCenterText(text, gamePanel, graphics2);
        y += gamePanel.tileSize*4;
        graphics2.drawString(text, x, y);
//        graphics2.drawString(">", x - gamePanel.tileSize, y);

        if(commandNumber == 0){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

        text = "USE ITEM";
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(text, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(text, x, y);
        if(commandNumber == 1){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

        text = "SWAP";
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(text, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(text, x, y);
        if(commandNumber == 2){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

        text = "RUN";
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(text, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(text, x, y);
        if(commandNumber == 3){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }
    }

    public int getXforCenterText(String text, GamePanel gamePanel, Graphics2D graphics2){
        int length = (int)graphics2.getFontMetrics().getStringBounds(text, graphics2).getWidth();
        int x = gamePanel.screenWidth/2 - length/2;
        return x;
    }

    public void drawAttackScreen(Graphics2D graphics2) {
        graphics2.setColor(Color.black);
        graphics2.fillRect(0,0, gamePanel.screenWidth, gamePanel.screenHeight);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 96F));
        String title = "Fight";
        int x = getXforCenterText(title, gamePanel, graphics2);
        int y = gamePanel.tileSize*3;

        //shadow
        graphics2.setColor(Color.gray);
        graphics2.drawString(title, x+5, y+5);

        graphics2.setColor(Color.white);
        graphics2.drawString(title,x,y);

        //Player1 stats
        x = gamePanel.tileSize;
        y = gamePanel.tileSize;
        graphics2.fillRoundRect(0,0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int playerHPNumber = player.battleSlot.get(0).hp;
        String playerName = player.battleSlot.get(0).name;
        int playerXPLevel = player.battleSlot.get(0).level;
        String playerLevel = String.valueOf(playerXPLevel);
        String hp = String.valueOf(playerHPNumber);
        graphics2.drawString(playerName,x,y);
        graphics2.drawString("hp: "+ hp,x,y+24);
        graphics2.drawString("lvl: "+playerLevel,x,y+48);

        //Player2 stats
        x = gamePanel.screenWidth - gamePanel.tileSize*4;
        y = gamePanel.tileSize;
        graphics2.setColor(Color.white);
        graphics2.fillRoundRect(gamePanel.screenWidth - gamePanel.tileSize*5, 0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int npcHPNumber = npc.battleSlot.get(0).hp;
        String npcName = npc.battleSlot.get(0).name;
        String npcHP = String.valueOf(npcHPNumber);
        graphics2.drawString(npcName, x, y);
        graphics2.drawString("hp: "+ npcHP,x,y+24);

        //Fight Screen
        x = gamePanel.screenWidth/2 - (gamePanel.tileSize*2)/2;
        y = gamePanel.screenHeight/4;
        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
//        graphics2.drawString((player.hp.toString()));

        //Menu
        ArrayList<Moves> pokemonMoves = player.battleSlot.get(0).getMoveList();
        Moves moves = pokemonMoves.get(0);
        String move = moves.getName();
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        graphics2.setColor(Color.white);
        x = getXforCenterText(move, gamePanel, graphics2);
        y += gamePanel.tileSize*4;
        graphics2.drawString(move, x, y);
//        graphics2.drawString(">", x - gamePanel.tileSize, y);

        if(commandNumber == 0){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }
        Moves moves1 = pokemonMoves.get(1);
        String move1 = moves1.getName();
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(move1, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(move1, x, y);
        if(commandNumber == 1){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

        Moves moves2 = pokemonMoves.get(2);
        String move2 = moves2.getName();
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(move2, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(move2, x, y);
        if(commandNumber == 2){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

        Moves moves3 = pokemonMoves.get(3);
        String move3 = moves3.getName();
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenterText(move3, gamePanel, graphics2);
        y += gamePanel.tileSize;
        graphics2.drawString(move3, x, y);
        if(commandNumber == 3){
            graphics2.drawString(">", x - gamePanel.tileSize, y);
        }

    }

    public void drawSwapScreen(Graphics2D graphics2) {
        graphics2.setColor(Color.black);
        graphics2.fillRect(0,0, gamePanel.screenWidth, gamePanel.screenHeight);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        String title = "SWAP POKEMON";
        int x = getXforCenterText(title, gamePanel, graphics2);
        int y = gamePanel.tileSize*3;

        //shadow
        graphics2.setColor(Color.gray);
        graphics2.drawString(title, x+5, y+5);

        graphics2.setColor(Color.white);
        graphics2.drawString(title,x,y);

        //Player1 stats
        x = gamePanel.tileSize;
        y = gamePanel.tileSize;
        graphics2.fillRoundRect(0,0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int playerHPNumber = player.battleSlot.get(0).hp;
        String playerName = player.battleSlot.get(0).name;
        int playerXPLevel = player.battleSlot.get(0).level;
        String playerLevel = String.valueOf(playerXPLevel);
        String hp = String.valueOf(playerHPNumber);
        graphics2.drawString(playerName,x,y);
        graphics2.drawString("hp: "+ hp,x,y+24);
        graphics2.drawString("lvl: "+playerLevel,x,y+48);

        //Player2 stats
        x = gamePanel.screenWidth - gamePanel.tileSize*4;
        y = gamePanel.tileSize;
        graphics2.setColor(Color.white);
        graphics2.fillRoundRect(gamePanel.screenWidth - gamePanel.tileSize*5, 0, gamePanel.screenWidth/4, gamePanel.screenHeight/4,10,10);
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 24F));
        graphics2.setColor(Color.black);
//        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
        int npcHPNumber = npc.battleSlot.get(0).hp;
        String npcName = npc.battleSlot.get(0).name;
        String npcHP = String.valueOf(npcHPNumber);
        graphics2.drawString(npcName, x, y);
        graphics2.drawString("hp: "+ npcHP,x,y+24);

        //Fight Screen
        x = gamePanel.screenWidth/2 - (gamePanel.tileSize*2)/2;
        y = gamePanel.screenHeight/4;
        graphics2.drawImage(gamePanel.player.backwards1,x,y, gamePanel.tileSize*2, gamePanel.tileSize *2, null);
//        graphics2.drawString((player.hp.toString()));

        //Menu
        String pokemonName = player.party.get(0).name;
        int pokemonHPNum = player.party.get(0).hp;
        String pokemonHP = String.valueOf(pokemonHPNum);
        String displayInfo = pokemonName + " hp: " + pokemonHP;
        graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
        graphics2.setColor(Color.white);
        x = getXforCenterText(displayInfo, gamePanel, graphics2);
        y += gamePanel.tileSize*4;
        graphics2.drawString(displayInfo, x, y);
//        graphics2.drawString(">", x - gamePanel.tileSize, y);
        if(player.party.size() >1) {
            if (commandNumber == 0) {
                graphics2.drawString(">", x - gamePanel.tileSize, y);
            }
            String pokemonName1 = player.party.get(1).name;
            int pokemonHPNum1 = player.party.get(1).hp;
            String pokemonHP1 = String.valueOf(pokemonHPNum1);
            String displayInfo1 = pokemonName1 + " hp: " + pokemonHP1;
            graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
            x = getXforCenterText(displayInfo1, gamePanel, graphics2);
            y += gamePanel.tileSize;
            graphics2.drawString(displayInfo1, x, y);
            if (commandNumber == 1) {
                graphics2.drawString(">", x - gamePanel.tileSize, y);
            }
            if(player.party.size() >2) {
                String pokemonName2 = player.party.get(2).name;
                int pokemonHPNum2 = player.party.get(2).hp;
                String pokemonHP2 = String.valueOf(pokemonHPNum2);
                String displayInfo2 = pokemonName2 + " hp: " + pokemonHP2;
                graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
                x = getXforCenterText(displayInfo2, gamePanel, graphics2);
                y += gamePanel.tileSize;
                graphics2.drawString(displayInfo2, x, y);
                if (commandNumber == 2) {
                    graphics2.drawString(">", x - gamePanel.tileSize, y);
                }
                if (player.party.size() > 3) {
                    String pokemonName3 = player.party.get(3).name;
                    int pokemonHPNum3 = player.party.get(3).hp;
                    String pokemonHP3 = String.valueOf(pokemonHPNum3);
                    String displayInfo3 = pokemonName3 + " hp: " + pokemonHP3;
                    graphics2.setFont(graphics2.getFont().deriveFont(Font.BOLD, 48F));
                    x = getXforCenterText(displayInfo3, gamePanel, graphics2);
                    y += gamePanel.tileSize;
                    graphics2.drawString(displayInfo3, x, y);
                    if (commandNumber == 3) {
                        graphics2.drawString(">", x - gamePanel.tileSize, y);
                    }
                }
            }}
    }

    public Entity getPlayer() {
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public Entity getNpc() {
        return npc;
    }

    public void setNpc(Entity npc) {
        this.npc = npc;
    }
}