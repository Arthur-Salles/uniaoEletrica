package player;

import java.util.ArrayList;

import mapa.Coordenadas;
import mapa.ElementoGeografico;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoGeografico{

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    public Player(Coordenadas posicao){
        super(posicao, "P");
    }

    public void addPokemon(PokemonNPC k){
        return;
    }

    public void move(int spaces){
        // faz os boundries checks
        return;
    }

    public Coordenadas getCoordenadas(){
        return super.getPosicaoAtual();
    }

}
