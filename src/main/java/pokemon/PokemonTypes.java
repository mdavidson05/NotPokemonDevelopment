package pokemon;

import moves.Moves;

import java.util.ArrayList;
import java.util.HashMap;

public enum PokemonTypes {

    FIRE(1),
    WATER(2),
    GRASS(3),;

    private final int typeID;
//    private final HashMap<PokemonTypes, ArrayList<Moves>> startingMoves;

    PokemonTypes(int typeID) {
        this.typeID = typeID;
    }

//    PokemonTypes(HashMap<PokemonTypes, ArrayList<Moves>> startingMoves) {
        //n pokemonTypes.startingmoves.get(PokemonType.FIRE)
//        this.startingMoves = startingMoves;
//    }



    public int getTypeID() {
        return typeID;
    }



//    PokemonTypes[] pokemonTypes = PokemonTypes.values();

}