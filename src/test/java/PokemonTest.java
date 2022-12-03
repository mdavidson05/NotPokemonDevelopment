import moves.Moves;
import org.junit.Before;
import org.junit.Test;
import pokemon.Pokemon;
import pokemon.PokemonCreator;
import pokemon.PokemonTypes;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PokemonTest {

    PokemonCreator pokemonCreator;
    PokemonCreator pokemon1;


    @Before
    public void before(){
        ArrayList<Moves> moveSet = new ArrayList<>();
        ArrayList baseStats= new ArrayList();
        pokemon1 = new PokemonCreator("Charmander", 50, 1, PokemonTypes.WATER, 0, true, 1,10, moveSet, baseStats);
    }

    @Test
    public void checkPokemonHasName(){
        assertEquals("Charmander", pokemon1.getName());
    }

    @Test
    public void checkPokemonStartingMoves(){
        pokemon1.populateStartingMoves();
        assertEquals(4, pokemon1.getMoveList());
    }

}
