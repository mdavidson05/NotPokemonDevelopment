package moves;

import pokemon.PokemonTypes;

import java.util.ArrayList;
import java.util.HashMap;

public class StartingMoves {

    public static final HashMap<PokemonTypes, ArrayList<Moves>>  lookup = getStartingMoves();

    private static final HashMap<PokemonTypes, ArrayList<Moves>> getStartingMoves(){
            // new up all
            // firemove1...
            ArrayList fireStartingMove = new ArrayList();
            ArrayList waterStartingMove = new ArrayList();
            ArrayList grassStartingMove = new ArrayList();

            //create moves
            Moves fireMove1 = new Moves("scratch",1,5,"normal",1,1,"normal");
            Moves fireMove2 = new Moves("tail whip",1,0,"normal",1,1,"normal");
            Moves fireMove3 = new Moves("ember", 1,10,"fire",1,1,"fire");
            Moves fireMove4 = new Moves("swift", 1,8,"normal",1,1,"normal");

            Moves waterMove1 = new Moves("scratch",1,5,"normal",1,1,"normal");
            Moves waterMove2 = new Moves("tail whip",1,0,"normal",1,1,"normal");
            Moves waterMove3 = new Moves("bubble", 1,10,"water",1,1,"water");
            Moves waterMove4 = new Moves("swift", 1,8,"normal",1,1,"normal");

            Moves grassMove1 = new Moves("scratch",1,5,"normal",1,1,"normal");
            Moves grassMove2 = new Moves("tail whip",1,0,"normal",1,1,"normal");
            Moves grassMove3 = new Moves("vine whip", 1,10,"grass",1,1,"grass");
            Moves grassMove4 = new Moves("swift", 1,8,"normal",1,1,"normal");

//        public void addMoves(Moves) {
            fireStartingMove.add(fireMove1);
            fireStartingMove.add(fireMove2);
            fireStartingMove.add(fireMove3);
            fireStartingMove.add(fireMove4);

            waterStartingMove.add(waterMove1);
            waterStartingMove.add(waterMove2);
            waterStartingMove.add(waterMove3);
            waterStartingMove.add(waterMove4);

            grassStartingMove.add(grassMove1);
            grassStartingMove.add(grassMove2);
            grassStartingMove.add(grassMove3);
            grassStartingMove.add(grassMove4);

            HashMap<PokemonTypes, ArrayList<Moves>> startingMoves = new HashMap<>();
            startingMoves.put(PokemonTypes.FIRE, fireStartingMove);
            startingMoves.put(PokemonTypes.WATER, waterStartingMove);
            startingMoves.put(PokemonTypes.GRASS, grassStartingMove);


            return startingMoves;


}}
