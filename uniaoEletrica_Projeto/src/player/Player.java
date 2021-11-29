package player; // dps fazer os pacotes serem todos referentes a pasta global

import java.util.ArrayList;

import itens.Item;
import mapa.ElementoGeografico;
import mapa.Coordenadas;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoGeografico{ // falta o extends pra definir o grid etc

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private ArrayList<Item> itens = new ArrayList<Item>();
    private Pokemon activePokemon = pokemons.get(0);


    public Player(Coordenadas posicao){
        super(posicao, "P");
    }

    public void addPokemon(PokemonNPC k){
        pokemons.add(k);
    }

    public void move(int spaces){
        // faz os boundries checks
        return;
    }

    public Coordenadas getCoordenadas(){ // no aguardo de definir a herança
        return super.getPosicaoAtual();
    }

    public int printPokemons(){
        for(int i = 0; i < pokemons.size(); i++){
            System.out.println(i+ ": " + pokemons.get(i).showInfo());
        }
        return pokemons.size();
    }

    public void setActivePokemon(int k){
        this.activePokemon = pokemons.get(k);
    }

}
