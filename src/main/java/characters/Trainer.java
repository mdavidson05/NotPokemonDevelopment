//package characters;
//
//import items.Item;
//import pokemon.Pokemon;
//
//import java.util.ArrayList;
//
//public abstract class Trainer extends characters.Character{
//
//    ArrayList<pokemon.Pokemon> pokedex; //pokedex might need to be another class
//    protected ArrayList<pokemon.Pokemon> party = new ArrayList<>();
//    private pokemon.Pokemon stagedPokemon = null;
////    protected  BattleSlot ownedSlot; will probably need a slot for the current pokemon on field
////    protected BattleSlot enemySlot;
//
//    public Trainer(String name, double money, ArrayList<Item> items, ArrayList<pokemon.Pokemon> party, ArrayList<pokemon.Pokemon> pokedex, ArrayList<pokemon.Pokemon> party1, pokemon.Pokemon stagedPokemon, BattleSlot ownedSlot, BattleSlot enemySlot) {
//        super(name, money, items, party);
//        this.pokedex = pokedex;
//        this.party = party1;
//        this.stagedPokemon = stagedPokemon;
////        this.ownedSlot = ownedSlot;
////        this.enemySlot = enemySlot;
//    }
//
//    //add pokemons to trainer party
//    public Trainer(String name, pokemon.Pokemon[] pokemons) {
//            name = name;
//            for (pokemon.Pokemon pokemon:pokemons) {
//                party.add(pokemon);
//            }
//        }
//        public  pokemon.Pokemon getStagedPokemon(){
//            return  stagedPokemon;
//        }
//
//        public boolean canFight() {
//            for (pokemon.Pokemon pokemon:party) {
//                if(!pokemon.hasFainted())
//                    return true;
//            }
//            return false;
//        }
//
//        public boolean canSwap(){
//            for (pokemon.Pokemon pokemon:party) {
//                if(!pokemon.hasFainted() && pokemon != getStagedPokemon())
//                    return  true;
//                else{
//                    System.out.println(pokemon.name + " is fainted and can't battle now");
//                }
//            }
//            return  false;
//        }
//        public void swapPokemon(){
//            System.out.println(getStagedPokemon().name + " was recalled");
//            pokemon.Pokemon pokemonToSwapWith = sendOutFirstAvailablePokemon();
//            swapPokemon(pokemonToSwapWith);
//        }
//
//        public void swapPokemon(pokemon.Pokemon pokemonToSwapWith ){
//            if(pokemonToSwapWith == null)
//                System.out.println("swap failed");
//            else{
//                stagedPokemon = pokemonToSwapWith;//no need to add the previous staged pokemon to party again
////                ownedSlot.setPokemon(stagedPokemon);
//            }
//        }
//
//        public pokemon.Pokemon sendOutFirstAvailablePokemon(){//get first not dead pokemon that's not already sent out or return null,
//            for (pokemon.Pokemon pokemon :party) {
//                if(!pokemon.hasFainted() && stagedPokemon != pokemon) {
//                    return pokemon;
//                }
//            }
//            return  null;
//        }
//
//        public pokemon.Pokemon stageFirstAvailablePokemon(){// used for getting pokemon to send out first in battle//also stages the mon
//            pokemon.Pokemon p = sendOutFirstAvailablePokemon();
//            stagedPokemon = p;
//            System.out.println(name+"sending poke "+ p.name);
//            return stagedPokemon;
//        }
//
////        public void prepareForBattle(BattleSlot ownedSlot,BattleSlot enemySlot){
////            this.ownedSlot = ownedSlot;
////            this.enemySlot = enemySlot;
////
////            ownedSlot.setPokemon(stageFirstAvailablePokemon());
////        }
//
//        public void endBattle(){
//            stagedPokemon = null;
////            ownedSlot = null;
////            enemySlot = null;
//        }
//
//
////        public abstract ArrayList<Attack> getCommands();
////        public abstract Boolean moveHasFinished();
////        public abstract void prepTurn();
//    }