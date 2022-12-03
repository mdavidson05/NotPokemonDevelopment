package pokemon;

import moves.Moves;
import moves.StartingMoves;

import java.util.ArrayList;

public abstract class Pokemon {

    public String name;
    public int hp;
    public int level;
    PokemonTypes pokemonTypes;
    private int xp;
    private boolean awake;
    private boolean fightIsWon;

    public Pokemon(String name, int hp, int level, PokemonTypes pokemonTypes, int xp, boolean awake) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.pokemonTypes = pokemonTypes;
        this.xp = xp;
        this.awake = awake;
    }

    public boolean checkHasFainted(){
        if(hp<=0){
            this.awake = false;
        }
        return this.awake;
    }

    public boolean checkHasWon(ArrayList<PokemonCreator> party){
        fightIsWon = false;
        int faintCounter =0;
        for(int i = 0; i < party.size(); i++){
            if(party.get(i).hp <= 0){
                faintCounter++;
            }
        }
        if(faintCounter == party.size()){
            fightIsWon = true;
        }
        return fightIsWon;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PokemonTypes getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(PokemonTypes pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public boolean isAwake() {
        return awake;
    }

    public void setAwake(boolean awake) {
        this.awake = awake;
    }

}