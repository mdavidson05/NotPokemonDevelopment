package handlers;

public class StartingPokemonSetter {

    GamePanel gamePanel;

    public StartingPokemonSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setPokemon() {
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

        int mapNumber =1;
        gamePanel.pokeball[mapNumber][0] = new Pokeball(gamePanel, gamePanel.player.getStartingPokemon(0));
        gamePanel.pokeball[mapNumber][0].worldX = 16 * gamePanel.tileSize;
        gamePanel.pokeball[mapNumber][0].worldY = 4 * gamePanel.tileSize;

        gamePanel.pokeball[mapNumber][1] = new Pokeball(gamePanel, gamePanel.player.getStartingPokemon(1));
        gamePanel.pokeball[mapNumber][1].worldX = 15 * gamePanel.tileSize;
        gamePanel.pokeball[mapNumber][1].worldY = 4 * gamePanel.tileSize;

        gamePanel.pokeball[mapNumber][2] = new Pokeball(gamePanel, gamePanel.player.getStartingPokemon(2));
        gamePanel.pokeball[mapNumber][2].worldX = 17 * gamePanel.tileSize;
        gamePanel.pokeball[mapNumber][2].worldY = 4 * gamePanel.tileSize;

        mapNumber =3;
        gamePanel.pokeball[mapNumber][3] = new Pokeball(gamePanel, gamePanel.player.getStartingPokemon(3));
        gamePanel.pokeball[mapNumber][3].worldX = 16 * gamePanel.tileSize;
        gamePanel.pokeball[mapNumber][3].worldY = 4 * gamePanel.tileSize;


    }

}
