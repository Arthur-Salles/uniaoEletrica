package game;

import pokemon.ListaPokemons;
import java.util.Scanner;
import mapa.Coordenadas;
import mapa.Ilha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;
import pokemon.Pokemon;
import tipos.Tipo;
import turno.Acao;
import turno.Movimentacao;

public class Game {
    private Scanner keyboard = new Scanner(System.in);
    private boolean running = true;
    private Mapa mapa;
    private Player player;

    public void start() {
        criarMapa();
        player = new Player(new TriplaCoordenada(0, 0, 0));
        criarPokemons();
        new Acao(player);

        runGame(mapa, player);
    }

    private void criarMapa() {
        mapa = new Mapa(10, 10);

        criarIlha(10, 5, new Coordenadas(0, 0), "I1", Tipo.WATER);
        criarIlha(8, 5, new Coordenadas(7, 7), "I2", Tipo.ELECTRIC);
        criarIlha(8, 3, new Coordenadas(9, 9), "I3", Tipo.FIRE);
    }

    private void criarPokemons() {
        Pokemon leonardo = new Pokemon(ListaPokemons.Iv, new TriplaCoordenada(2, 2, 0));

        player.addPokemon(leonardo);

    }

    private void criarIlha(int i, int k, Coordenadas c, String icone, Tipo tipo) {
        Ilha ilha = new Ilha(i, i, k, c, icone, tipo);
        mapa.adicionarIlha(ilha, c);
    }

    private void runGame(Mapa mapa, Player player) {
        mapa.imprimirMapa();
        System.out.print("Digite o numero da Ilha para qual quer viajar: ");

        String command = keyboard.nextLine();
        player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));
        travelToIsland();
    }

    private void travelToIsland() {
        Acao faseAcao = new Acao(player);
        Movimentacao faseMovimentacao = new Movimentacao(player, mapa);

        while (running) {
            if (!faseMovimentacao.start()) {
                running = false;
                // se perdeu, running = false

            } else {
                if (!faseAcao.start()) {
                    running = false;
                }
                // se perdeu running = false
            }
        }

        System.out.print("GAME OVER");
    }
}
