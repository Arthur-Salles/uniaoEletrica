package pokemon;

import dados.Dado;
import mapa.Coordenadas;
import mapa.TriplaCoordenada;
import player.Player;

public class PokemonNPC extends Pokemon {

    private int capMax, dificuldadeCaptura;
    private int maxTries = 2;

    public PokemonNPC(String n, Tipo[] types, TriplaCoordenada posicao, int vida, int atk, int defesa) {
        super(n, types, posicao, vida, atk, defesa);
        Dado kek = new Dado(4);
        capMax = kek.jogarDados();
        dificuldadeCaptura = kek.jogarDados();
        dificuldadeCaptura += kek.jogarDados();
    }

    public void captura(Player p) {
        Dado kek = new Dado(6, 2);
        if (p.getCoordenadas().calculaDistancia(this.getPosicaoAtual()) <= capMax) {
            int dado = kek.jogarDados();
            if (dado > dificuldadeCaptura) {
                p.addPokemon(this);
            } else {
                maxTries -= 1;
            }
        }
        if (maxTries == 0) {
            // engage combat
            return;
        }
    }

}
