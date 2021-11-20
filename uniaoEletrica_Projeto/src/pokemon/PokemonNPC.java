package pokemon;

import java.util.Random;

import mapa.Coordenadas;
import player.Player;

public class PokemonNPC extends Pokemon{

    private int capMax, dificuldadeCaptura;

    public PokemonNPC(String n, Tipo[] types, Coordenadas posicao, int vida, int atk, int defesa) {
        super(n, types, posicao, vida, atk, defesa);
        Random kek = new Random();
        capMax = kek.nextInt(4) + 1;
        dificuldadeCaptura = kek.nextInt(4) + 1;
        dificuldadeCaptura += kek.nextInt(4) + 1;
    }

    public void captura(Player p){
        Random kek = new Random();
        if(p.getCoordenadas().calculaDistancia(this.getPosicaoAtual()) <= capMax){
            int dado = kek.nextInt(6) + 1;
            dado += kek.nextInt(6) + 1;
            if(dado > dificuldadeCaptura){
                p.addPokemon(this);
            }
        }
    }
    
}
