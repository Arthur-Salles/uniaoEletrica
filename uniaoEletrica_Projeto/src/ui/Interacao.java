package ui;

import java.util.Scanner;

import dados.Dado;
import player.Player;
import pokemon.Pokemon;
import skills.Skills;

public class Interacao {
    private Dado dado = new Dado();
    private int movimento;
    private Scanner leitor = new Scanner(System.in);
    private Player p;
    private boolean movimentTurnOn = false; // trocar

    public Interacao(Player k) {
        this.p = k;
    }

    public void choosePokemon() {
        if (!movimentTurnOn) {
            int k = 0;
            System.out.println("De o número para escolher o pokemon: ");
            int max = p.printPokemons();
            k = leitor.nextInt();
            while (k < 0 || k > max) {
                System.out.println("De um número no intervalo correto!");
                k = leitor.nextInt();
            }
            p.setActivePokemon(k);
        } else {
            System.out.println("Finish movement turn first!");
        }
    }

    public int chooseItem() {
        try {
            int max = p.printItens();
            if (max == 0) {
                throw new IndexOutOfBoundsException();
            }

            System.out.println("De o número para escolher o item: ");

            int k = leitor.nextInt();
            while (k < 0 || k > max) {
                System.out.println("De um numero no intervalo correto!");
                k = leitor.nextInt();
            }
            return k;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public int chooseAction() {
        System.out.println("1.Atacar\n2.Usar Habilidade\n3.Usar Item");
        int k = leitor.nextInt();
        while (k < 0 || k > 3) {
            System.out.println("Um numero entre os citados pfv!");
            k = leitor.nextInt();
        }
        return k;
    }

    public void pokemonIsDead(Pokemon k) {
        System.out.println(k.showInfo() + " esta morto!\nEscolha outro!");
        choosePokemon();
    }

    public void pokemonCaptured(Pokemon k) {
        System.out.println(k.getNome() + " foi capturado!");
    }

    public Skills chooseSkill(Pokemon activePokemon) {
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
            System.out.println("Nada Acontece");
            return new Skills();
        }
    }

    public void printPokemonsStatus(Pokemon a, Pokemon b) {
        System.out.println(a.showInfo() + "\n" + b.showInfo());
    }

    public void printWinner(Pokemon a) {
        System.out.printf("O pokemon %s ganhou a luta\n", a.getNome());
    }

}
