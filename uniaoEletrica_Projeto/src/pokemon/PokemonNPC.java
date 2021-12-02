package pokemon;

import java.util.Random;
import dados.Dado;
import mapa.Coordenadas;
import mapa.TriplaCoordenada;
import player.Player;
import tipos.Tipo;

public class PokemonNPC extends Pokemon {

    private int capMax, dificuldadeCaptura;
    private int maxTries = 2;

    public PokemonNPC(String nome, String n, TriplaCoordenada posicao, int vida, int atk, int defesa, Tipo[] tipos) {
        super(nome, n, posicao, vida, atk, defesa, tipos);
        Dado kek = new Dado(4);
        capMax = kek.jogarDados();
        dificuldadeCaptura = kek.jogarDados();
        dificuldadeCaptura += kek.jogarDados();
    }

    public void captura(Player p) {
        Random kek = new Random();
        if (p.getCoordenadas().calculaDistancia(this.getPosicaoAtual()) <= capMax) {
            int dado = kek.nextInt(6) + 1;
            dado += kek.nextInt(6) + 1;
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
