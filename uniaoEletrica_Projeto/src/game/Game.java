package game;

import pokemon.ListaPokemons;
import java.util.Scanner;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;
import pokemon.Pokemon;
import turno.Turno;

public class Game {
    private Scanner keyboard = new Scanner(System.in);
    private Mapa mapa;
    private Player player;
    private Status status;
    private Turno turno;

    public void start() {
        criarMapa();
        player = new Player(new TriplaCoordenada(0, 0, 0));
        adicionarPokemonInicialDoJogador();
        status = new Status(player, mapa);
        turno = new Turno(player, mapa);
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
        Pokemon pikachu = new Pokemon(ListaPokemons.Pi, new TriplaCoordenada(2, 2, 0));
        player.addPokemon(pikachu);
    }

    private void runGame(Mapa mapa, Player player) {
        
        chooseIsland();

        while (!(player.lostTheGame() && !(player.wonTheGame(mapa)))) {
            turno.start();
            status.imprimir();
        }
        status.gameOver();

    }

    private void chooseIsland() {
    	String command = " ";
        mapa.imprimirMapa();
        System.out.print("Digite o numero da Ilha para qual quer viajar: ");
        boolean flag = true;
        
        do {
            try {
                command = keyboard.nextLine();
                player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));
                flag = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Use um comando valido!");
            }
        } while (flag);
        
    }

}
