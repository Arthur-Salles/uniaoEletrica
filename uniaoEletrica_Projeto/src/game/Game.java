package game;

import pokemon.ListaPokemons;
import java.util.Scanner;

import turno.Status;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;
import pokemon.Pokemon;
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
        adicionarPokemonInicialDoJogador();
        new Acao(player);
        runGame(mapa, player);
    }

    private void criarMapa() {
        mapa = new Mapa(14, 14);
        Mundo.imprimirMapasDisponiveis();
        int command = 0;
        command = keyboard.nextInt();
        if (command == 1) {
            Mundo.criarHoenn(mapa);
        } else if (command == 2) {
            Mundo.criarJohto(mapa);
        } else if (command == 3) {
            Mundo.criarKanto(mapa);
        } else if (command == 4) {
            Mundo.criarSinnoh(mapa);
        } else if (command == 5) {
            Mundo.criarTerra(mapa);
        } else if (command == 6) {
            Mundo.criarMapaAleatorio(mapa);
        }

    }

    private void adicionarPokemonInicialDoJogador() {
        Pokemon picachu = new Pokemon(ListaPokemons.Pi, new TriplaCoordenada(2, 2, 0));
        player.addPokemon(picachu);
    }

    private void runGame(Mapa mapa, Player player) {
        String command = "dhfshf";
        mapa.imprimirMapa();
        System.out.print("Digite o numero da Ilha para qual quer viajar: ");
        boolean flag = true;
        do {
            try {
                command = keyboard.nextLine();
                player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));
                travelToIsland();
                flag = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Use um comando valido!");
            }
        } while (flag);

    }

    private void travelToIsland() {
        Acao faseAcao = new Acao(player);
        Movimentacao faseMovimentacao = new Movimentacao(player, mapa);
        Status status = new Status(player, mapa);

        while (running && !(player.wonTheGame(mapa))) {
            faseMovimentacao.start();
            running = faseMovimentacao.isStillRunning();

            if (running) {
                faseAcao.start();
                running = faseAcao.isStillRunning();
            }
            status.imprimir();
        }

        gameOver();
    }

    private void gameOver() {
        System.out.println(" ");

        if (player.wonTheGame(mapa)) {
            System.out.println("YOU WIN!!!");
        } else {
            System.out.println("YOU LOST");
        }

        System.out.println("GAME OVER");
    }

    public int pokemonsTotal() {
        return mapa.totalPokemons();
    }

}
