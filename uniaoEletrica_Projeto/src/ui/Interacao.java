package ui;

import java.util.Random;
import java.util.Scanner;

import player.Player;
import pokemon.Pokemon;
import skills.Skills;

public class Interacao {
    private Random dado = new Random();
    private int movimento;
    private Scanner leitor = new Scanner(System.in);
    private Player p;
    private boolean movimentTurnOn = false; // trocar

    public Interacao(Player k){
        this.p = k;
    }

    private void startMovementTurn(){
        String show = "Voce tem ";
        movimento = dado.nextInt(12)+2;
        show += movimento + " movimentos";
        System.out.println(show);
    }

    public void movePlayer(){
        this.startMovementTurn();
        while(this.movimento > 0){
            System.out.println("De o numero de movimentos: ");
            int quant = leitor.nextInt();
            while(quant > movimento){
                System.out.println("Deve ser menor que o seu total");
                quant = leitor.nextInt();
            }
            System.out.println("Digite o numero para onde quer se mover: ");
            System.out.println("5 -> Cima\n1 -> Esquerda\n2 -> Baixo\n3 -> Direita");
            int sentido = leitor.nextInt();
            switch (sentido) {
                case 5:
                    p.move(quant);
                    break;
                case 1:
                    p.move(quant);
                    break;
                case 2:
                    p.move(quant);
                    break;
                case 3:
                    p.move(quant);
                    break;
                default:
                    while(sentido > 5){
                        System.out.println("Tenta denovo!");
                        sentido = leitor.nextInt();
                    } 
                    break;
            }
            this.movimento -= quant;
            if(movimento == 0){
                System.out.println("Acabou o turno de movimentação");
                movimentTurnOn = false;
            }
            else{
                System.out.println("Voce tem " + movimento + " restantes");
            }
        }
    }


    public void choosePokemon(){
        if(!movimentTurnOn){
            int k = 0;
            System.out.println("De o número para escolher o pokemon: ");
            int max = p.printPokemons();
            k = leitor.nextInt();
            while(k < 0 || k > max){
                System.out.println("De um número no intervalo correto!");
                k = leitor.nextInt();
            }
            p.setActivePokemon(k);
        }
        else{
            System.out.println("Finish movement turn first!");
        }
    }

    public int chooseItem(){
        int k = 0;
        System.out.println("De o número para escolher o item: ");
        int max = p.printItens();
        k = leitor.nextInt();
        while(k < 0 || k > max){
            System.out.println("De um numero no intervalo correto!");
            k = leitor.nextInt();
        }
        return k;
    }

    public int chooseAction(){
        System.out.println("1.Atacar\n2.Usar Habilidade\n3.Usar Item");
        int k = leitor.nextInt();
        while(k < 0 || k > 3){
            System.out.println("Um numero entre os citados pfv!");
            k = leitor.nextInt();
        }
        return k;
    }

    public void pokemonIsDead(Pokemon k){
        System.out.println(k.showInfo() + " esta morto!\nEscolha outro!");
        choosePokemon();
    }

    public void pokemonCaptured(Pokemon k){
        System.out.println(k.getNome() + " foi capturado!");
    }

    public Skills chooseSkill(Pokemon activePokemon){
        try {
            int max = activePokemon.showAllSkills();
            if(max == 0){
                throw new IndexOutOfBoundsException();
            }
            System.out.println("Digite o número da habilidade");
            int k = leitor.nextInt();
            while(k < 0 || k > max){
                System.out.println("para de tentar quebrar o jogo namoral");
                k = leitor.nextInt();
            }
            return activePokemon.getSkill(k);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nada Acontece");
            return new Skills();
        }
    }

    public void printPokemonsStatus(Pokemon a, Pokemon b){
        System.out.println(a.showInfo() + "\n" + b.showInfo());
    }

    public void printWinner(Pokemon a){
        System.out.printf("O pokemon %s ganhou a luta\n", a.getNome());
    }

}

