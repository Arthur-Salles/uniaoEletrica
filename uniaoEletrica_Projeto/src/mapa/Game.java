package mapa;

import java.util.Random;
import java.util.Scanner;

import itens.Fruta;
import itens.TR;
import player.Player;
import pokemon.Combate;
import pokemon.ListaPokemons;
import pokemon.Pokemon;
import tipos.Tipo;
import ui.Interacao;

public class Game {
    private Random dado = new Random();
    private int movimento;
    private Scanner keyboard = new Scanner(System.in);
    private boolean travelling = true;
    private Mapa mapa;
    Player player;
    Interacao ui;

    public void start() {
        criarMapa();
        player = new Player(new TriplaCoordenada(0, 0, 0));
        runGame(mapa, player);

        ui = new Interacao(player);
    }

    private void criarMapa() {
        mapa = new Mapa(10, 10);

        criarIlha(10, 5, new Coordenadas(0, 0), "I1");
        criarIlha(8, 5, new Coordenadas(7, 7), "I2");
        criarIlha(8, 3, new Coordenadas(9, 9), "I3");
    }

    private void criarCombate(Pokemon pikachu) {
        Combate rinhaDeAnimal = new Combate(player, pikachu);

    }

    private void criarPokemons() {
        TR t1 = new TR();

        Pokemon pikachu = new Pokemon(ListaPokemons.Be.getName(), ListaPokemons.Be.toString(),
                new TriplaCoordenada(2, 2, 0), 20, 15, 7, ListaPokemons.Be.getTipos());
        Pokemon leonardo = new Pokemon(ListaPokemons.Iv.getName(), ListaPokemons.Iv.toString(),
                new TriplaCoordenada(2, 2, 0), 20, 15, 7, ListaPokemons.Iv.getTipos());

        leonardo.addSkillWithTR(t1);
        player.addItem(new Fruta());

        // player.addPokemon(pikachu);
        player.addPokemon(leonardo);
        // player.addPokemon(pikachu);
        // player.setActivePokemon(0);
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
        travelToIsland(player, mapa);
    }

    private void travelToIsland(Player player, Mapa mapa) {

        while (travelling) {
            executarMovimentosPlayer();
        }

        System.out.print("GAME OVER");
    }

    private void executarMovimentosPlayer() {
        System.out.println("Lancando dados...");
        movimento = dado.nextInt(12) + 2;

        while (this.movimento > 0) {
            player.imprimirIlhaAtual();
            System.out.println("Você tem " + movimento + " movimento(s)");
            System.out.print("Insira o comando: ");
            String command = keyboard.nextLine();

            if (command.compareTo("quit") == 0) {
                travelling = false;
            } else if (command.compareTo("w") == 0) {
                travelling = player.moverCima(mapa);
            } else if (command.compareTo("a") == 0) {
                travelling = player.moverEsquerda(mapa);
            } else if (command.compareTo("s") == 0) {
                travelling = player.moverBaixo(mapa);
            } else if (command.compareTo("d") == 0) {
                travelling = player.moverDireita(mapa);
            }

            movimento -= 1;
        }
    }
}
