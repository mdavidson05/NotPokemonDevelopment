package handlers;

import characters.NPC_Boy;
import characters.NPC_ProfOak;
import characters.NPC_Prophet;

public class ItemSetter {

    GamePanel gamePanel;

    public ItemSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setItem() {
        //int mapNumber = 0
//        gamePanel.item[mapNumber][0] = new Item();
//        gamePanel.item[0].worldX = 8 * gamePanel.tileSize;
//        gamePanel.item[0].worldY = 10 * gamePanel.tileSize;
//
//        gamePanel.item[1] = new Item();
//        gamePanel.item[1].worldX = 11 * gamePanel.tileSize;
//        gamePanel.item[1].worldY = 10 * gamePanel.tileSize;
//
//        gamePanel.item[2] = new Door();
//        gamePanel.item[2].worldX = 3 * gamePanel.tileSize;
//        gamePanel.item[2].worldY = 5 * gamePanel.tileSize;
//
//        gamePanel.item[3] = new Door();
//        gamePanel.item[3].worldX = 5 * gamePanel.tileSize;
//        gamePanel.item[3].worldY = 15 * gamePanel.tileSize;
//
//        gamePanel.item[4] = new Pokeball();
//        gamePanel.item[4].worldX = 6 * gamePanel.tileSize;
//        gamePanel.item[4].worldY = 10 * gamePanel.tileSize;
//
//        gamePanel.item[5] = new Pokeball();
//        gamePanel.item[5].worldX = 6 * gamePanel.tileSize;
//        gamePanel.item[5].worldY = 11 * gamePanel.tileSize;
//
//        gamePanel.item[6] = new Pokeball();
//        gamePanel.item[6].worldX = 6 * gamePanel.tileSize;
//        gamePanel.item[6].worldY = 12 * gamePanel.tileSize;

//        int mapNumber =1;
//        gamePanel.item[mapNumber][0] = new Pokeball();
//        gamePanel.item[mapNumber][0].worldX = 16 * gamePanel.tileSize;
//        gamePanel.item[mapNumber][0].worldY =  * gamePanel.tileSize;


    }

    public void setNPC(){
        int mapNumber = 0;
        gamePanel.npc[mapNumber][0] = new NPC_Boy(gamePanel);
        gamePanel.npc[mapNumber][0].worldX = gamePanel.tileSize*10;
        gamePanel.npc[mapNumber][0].worldY = gamePanel.tileSize*10;
        //if same NPC appears in multiple maps
        mapNumber = 1;
        gamePanel.npc[mapNumber][0] = new NPC_ProfOak(gamePanel);
        gamePanel.npc[mapNumber][0].worldX = gamePanel.tileSize*10;
        gamePanel.npc[mapNumber][0].worldY = gamePanel.tileSize*10;
        mapNumber = 3;
        gamePanel.npc[mapNumber][0] = new NPC_Prophet(gamePanel);
        gamePanel.npc[mapNumber][0].worldX = gamePanel.tileSize*10;
        gamePanel.npc[mapNumber][0].worldY = gamePanel.tileSize*10;

    }
}
