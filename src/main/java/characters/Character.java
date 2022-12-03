package characters;

import items.Item;
import pokemon.Pokemon;

import java.util.ArrayList;

public abstract class Character {

    public String name;
    private double money;
    ArrayList<Item> items;
    ArrayList<Pokemon> party;

    public Character(String name, double money, ArrayList<Item> items, ArrayList<Pokemon> party) {
        this.name = name;
        this.money = money;
        this.items = items;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Pokemon> getParty() {
        return party;
    }

}
