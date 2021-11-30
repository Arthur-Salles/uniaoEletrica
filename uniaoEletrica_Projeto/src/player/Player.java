package player; // dps fazer os pacotes serem todos referentes a pasta global

import java.security.Policy;
import java.util.ArrayList;

import itens.Item;
import mapa.ElementoGeografico;
import mapa.Coordenadas;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoGeografico{ // falta o extends pra definir o grid etc

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private ArrayList<Item> itens = new ArrayList<Item>();
    private Pokemon activePokemon;


    public Player(Coordenadas posicao){
        super(posicao, "P");
    }

    public void addPokemon(Pokemon k){
        pokemons.add(k);
        if(pokemons.size() == 0){
            setActivePokemon(0);
        }
    }

    public void addItem(Item k){
        itens.add(k);
    }

    public void move(int spaces){
        // faz os boundries checks
        return;
    }

    public Coordenadas getCoordenadas(){ // no aguardo de definir a herança
        return super.getPosicaoAtual();
    }

    public int printPokemons(){
        if(pokemons.size() == 0){
            System.out.println("Nao há itens");
        }
        for(int i = 0; i < pokemons.size(); i++){
            System.out.println(i+ ": " + pokemons.get(i).showInfo());
        }
        return pokemons.size();
    }

    public void setActivePokemon(int k){
        this.activePokemon = pokemons.get(k);
    }

    public int printItens(){
        if(itens.size() == 0){
            System.out.println("Não há itens");
        }
        for (int i = 0; i < itens.size(); i++){
            System.out.println(i + ": " + itens.get(i).render());
        }
        return itens.size();
    }

    public void consumeItem(int k){
        Item using = this.itens.get(k);
        using.use(activePokemon);
        itens.remove(using);
    }
    public void deleteItem(int k){
        itens.remove(k);
    }

    public Pokemon getActivePokemon(){
        return activePokemon;
    }

    public Item getItem(int k){
        return this.itens.get(k);
    }
    
}
