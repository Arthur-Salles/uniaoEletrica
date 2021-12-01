package pokemon;

import java.util.Random;

import mapa.Coordenadas;
import mapa.TriplaCoordenada;
import player.Player;

public class PokemonNPC extends Pokemon{

    private int capMax, dificuldadeCaptura;
    private int maxTries = 2;

    public PokemonNPC(String n, Tipo[] types, TriplaCoordenada posicao, int vida, int atk, int defesa) {
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
            else{
                maxTries -= 1;
            }
        }
        if(maxTries == 0){
            // engage combat
            return;
        }
    }
    
}
