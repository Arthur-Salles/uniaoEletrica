package ui;

import java.util.Random;
import java.util.Scanner;

import player.Player;


public class Interacao {
    private Random dado = new Random();
    private int movimento;
    private Scanner leitor = new Scanner(System.in);
    private Player p;

    public Interacao(Player k){
        this.p = k;
    }


    private void startMovementTurn(){
        String show = "Voce tem ";
        movimento = dado.nextInt(12)+2;
        show += movimento;
        System.out.println(show);
    }

    public void movePlayer(){
        this.startMovementTurn();
        while(this.movimento > 0){
            System.out.println("Digite o numero para onde quer se mover: ");
            String mov = "5 -> cima\n1 -> Esquerda\n2 -> Baixo\n3 -> Direita";
            System.out.println(mov);
            int sentido = leitor.nextInt();
            System.out.println("De o numero de movimentos: ");
            int quant = leitor.nextInt();
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
            }
            this.movimento -= quant;
        }
    }
}

