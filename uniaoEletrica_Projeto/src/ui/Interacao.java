package ui;

import java.util.Random;
import java.util.Scanner;

import player.Player;


public class Interacao {
    private Random dado = new Random();
    private int movimento;
    private Scanner leitor = new Scanner(System.in);
    private Player p;
    private boolean movimentTurnOn = true;

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
}

