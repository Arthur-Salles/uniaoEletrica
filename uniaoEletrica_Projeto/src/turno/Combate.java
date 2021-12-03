package turno;

import java.util.Scanner;

import player.Player;
import pokemon.Pokemon;

import skills.Skills;

public class Combate {

    private Player jogador;
    private Pokemon nonPlayer;
    private Pokemon activePokemon;
    private Acao combatUi;
    private boolean priority;
    private Scanner leitor = new Scanner(System.in);

    // constructor with player priority
    public Combate(Player jogador, Pokemon pokemonAdv, boolean priority) {
        this.jogador = jogador;
        this.nonPlayer = pokemonAdv;
        this.combatUi = new Acao(jogador);
        this.setupActivePokemon();
        this.priority = priority;

    }

    public boolean start() {
        if (priority) { // deve ter um jeito melhor de fazer isso kkk
            return this.engageFightPlayerPriority();
        } else {
            return this.engageFightNPCPriority();
        }
    }

    private void setupActivePokemon() {
        if (jogador.getActivePokemon() == null) {
            jogador.setActivePokemon(0);
        }
        this.activePokemon = jogador.getActivePokemon();
    }

    private void playerTurn() {
        switch (chooseAction()) {
            case 1:
                activePokemon.attack(nonPlayer);
                break;
            case 2:
                Skills habilidadeDoPokemonPlayer = chooseSkill(activePokemon);
                habilidadeDoPokemonPlayer.activeEffect(activePokemon, nonPlayer);
                habilidadeDoPokemonPlayer.passiveEffect(activePokemon, nonPlayer);
                break;
            case 3:
                try {
                    int itemSelector = combatUi.chooseItem();
                    jogador.consumeItem(itemSelector);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nada acontece");
                }
                break;
        }
    }

    private void adversaryTurn() {
        emitAttackWarning(nonPlayer);
        nonPlayer.attack(activePokemon);
        printPokemonsStatus(this.activePokemon, nonPlayer);
    }

    private boolean checkWinners() {
        boolean isWinner = false;

        if (activePokemon.isDead()) {
            isWinner = false;
            printWinner(nonPlayer);
            pokemonIsDead(activePokemon);
        } else if (nonPlayer.isDead()) {
            isWinner = true;
            printWinner(activePokemon);
            jogador.addPokemon(nonPlayer);
            jogador.removerPokemonIlha(nonPlayer);
            pokemonCaptured(nonPlayer);
        }

        return isWinner;
    }

    private boolean engageFightPlayerPriority() {

        System.out.printf("%s VERSUS %s\n", activePokemon.getNome(), nonPlayer.getNome());

        while (!activePokemon.isDead() && !nonPlayer.isDead()) {
            playerTurn();
            adversaryTurn();
        }
        return checkWinners();

    }

    private boolean engageFightNPCPriority() {
        System.out.printf("%s VERSUS %s\n", activePokemon.getNome(), nonPlayer.getNome());

        while (!activePokemon.isDead() && !nonPlayer.isDead()) {
            adversaryTurn();
            playerTurn();
        }

        return checkWinners();
    }

    private Skills chooseSkill(Pokemon activePokemon) {
        try {
            int max = activePokemon.showAllSkills();
            if (max == 0) {
                throw new IndexOutOfBoundsException();
            }
            System.out.println("Digite o número da habilidade");
            int k = leitor.nextInt();
            while (k < 0 || k > max) {
                System.out.println("para de tentar quebrar o jogo namoral");
                k = leitor.nextInt();
            }
            return activePokemon.getSkill(k);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nao há habilidades disponiveis");
            return new Skills();
        }
    }

    private int chooseAction() {
        System.out.println("(1) Atacar\n(2) Usar Habilidade\n(3) Usar Item");
        int k = leitor.nextInt();
        while (k < 0 || k > 3) {
            System.out.println("Um numero entre os citados pfv!");
            k = leitor.nextInt();
        }
        return k;
    }

    private void pokemonIsDead(Pokemon k) {
        jogador.perdeuPokemon(k);
        if (jogador.temPokemons()) {
            System.out.println(k.showInfo() + " esta morto!\nEscolha outro!");
            Acao acao = new Acao(jogador);
            acao.choosePokemon();
        } else {
            System.out.println(k.showInfo() + " esta morto!\nVoce nao tem outros pokemons!");
            jogador.gameOver();
        }
    }

    private void pokemonCaptured(Pokemon k) {
        System.out.println(k.getNome() + " foi capturado!");
    }

    private void printPokemonsStatus(Pokemon a, Pokemon b) {
        System.out.println(a.showInfo() + "\n" + b.showInfo());
    }

    private void printWinner(Pokemon a) {
        System.out.printf("O pokemon %s ganhou a luta\n", a.getNome());
    }

    private void emitAttackWarning(Pokemon k) {
        System.out.println(k.getNome() + " te atacou!");
    }

}