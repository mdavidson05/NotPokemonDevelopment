package handlers;

import java.awt.*;

public class EventHandler {
    GamePanel gamePanel;
//    Rectangle eventHitBox;
//    int eventHitboxDefaultX, eventHitboxDefaultY;
    EventHitbox eventHitbox[][];
    TileManager tileManager;

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;



    public EventHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        eventHitbox = new EventHitbox[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        int col = 0;
        int row = 0;
        while (col< gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
            eventHitbox[col][row] = new EventHitbox();
            eventHitbox[col][row].x = 4;
            eventHitbox[col][row].y = 7;
            eventHitbox[col][row].width = 16; //highlight how this was small in presentation
            eventHitbox[col][row].height = 16;
            eventHitbox[col][row].eventHitboxDefaultX  = eventHitbox[col][row].x;
            eventHitbox[col][row].eventHitboxDefaultY  = eventHitbox[col][row].y;

            col++;
            if(col == gamePanel.maxWorldCol){
                col = 0;
                row++;
            }
        }


    }

    public void checkEvent() {
        //check player is 1 tile away
        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX); //needed to make abs as was using  anegative number
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gamePanel.tileSize) {
            canTouchEvent = true;
        }
// Cannot allow overlap of a destination tile and a teleport tile

        if (canTouchEvent == true) {
            //new bark to noak lab and back
            if (hit(0, 6, 4, "any") == true) {
//                System.out.println("hit");
                teleport(1, 12, 13);
            } else if (hit(1, 7, 15, "any") == true) {
                System.out.println("hit");
                teleport(0, 6, 5);
            } else if (hit(1, 8, 15, "any") == true) {
                System.out.println("hit");
                teleport(0, 6, 5);
            } else if (hit(1, 9, 15, "any") == true) {
                System.out.println("hit");
                teleport(0, 6, 5);
            }
            // new bark to route 1
            else if (hit(0, 1, 9, "any") == true) {
                System.out.println("a");
                teleport(2, 17, 9);
            } else if (hit(0, 1, 8, "any") == true) {
                System.out.println("b");
                teleport(2, 17, 9);

                //route 1 to sandland
            } else if (hit(2, 2, 10, "any") == true) {
                System.out.println("1");
                teleport(3, 3, 8);

            } else if (hit(2, 2, 9, "any") == true) {
                System.out.println("2");
                teleport(3, 4, 10);
//            } else if (hit(2, 0, 10, "any") == true) {
//                System.out.println("3");
//                teleport(3, 8, 10);

                //route 1 to new bark town
            } else if (hit(2, 18, 9, "any") == true) {
                System.out.println("4");
                teleport(0, 2, 9);

            } else if (hit(2, 18, 8, "any") == true) {
                System.out.println("5");
                teleport(0, 2, 10);
                //sandland to route 1
            } else if (hit(3, 17, 10, "any") == true) {
                System.out.println("back to route1");
                teleport(2, 3, 9);
            }
        }
    }

    public boolean hit(int map, int col, int row, String direction) {
        boolean hit = false;
        gamePanel.player.playerHitbox.x = gamePanel.player.worldX + gamePanel.player.playerHitbox.x;
        gamePanel.player.playerHitbox.y = gamePanel.player.worldY + gamePanel.player.playerHitbox.y;
        eventHitbox[col][row].x = col * gamePanel.tileSize + eventHitbox[col][row].x;
        eventHitbox[col][row].y = row * gamePanel.tileSize + eventHitbox[col][row].y;
//        System.out.println(eventHitbox[col][row]);
//        System.out.println(gamePanel.player.playerHitbox);

        if (gamePanel.player.playerHitbox.intersects(eventHitbox[col][row])) {
            if (gamePanel.player.direction.contentEquals(direction) || direction.contentEquals("any")) ;
            hit = true;
//            System.out.println("hit");

            previousEventX = gamePanel.player.worldX;
            previousEventY = gamePanel.player.worldY;
        }
        gamePanel.player.playerHitbox.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.playerHitbox.y = gamePanel.player.solidAreaDefaultY;

        eventHitbox[col][row].x = eventHitbox[col][row].eventHitboxDefaultX;
        eventHitbox[col][row].y = eventHitbox[col][row].eventHitboxDefaultY;

        return hit;

    }

    public void teleport(int map, int col, int row) {
        gamePanel.currentMap = map;
        gamePanel.player.worldX = gamePanel.tileSize*col;
        gamePanel.player.worldY = gamePanel.tileSize*row;
        previousEventX = gamePanel.player.worldX;
        previousEventY = gamePanel.player.worldY;
        canTouchEvent = false;
    }

}
