package turno;

import java.util.Scanner;
import dados.Dado;
import mapa.Mapa;
import player.Player;
import tela.TelaPrincipal;

public class Movimentacao {
    private Scanner keyboard = new Scanner(System.in);
    private int movimentos = 0;
    private Player player;
    private Dado dado = new Dado(2, 6);
    private Mapa mapa;
    private TelaPrincipal tela = new TelaPrincipal();

    public Movimentacao(Player player, Mapa mapa) {
        this.player = player;
        this.mapa = mapa;
    }

    public boolean start() {
        return executarMovimentos();
    }

    private void imprimirInstrucoes() {
        String instrucoes1 = "\u001b[H\u001b[12B\u001b[34C                                        \u001b[H\u001b[12B\u001b[34C";
        System.out.println(instrucoes1 + "---FASE DE MOVIMENTACAO---");
        String instrucoes2 = "\u001b[H\u001b[13B\u001b[34C                                        \u001b[H\u001b[13B\u001b[34C";
        System.out.println(instrucoes2 + "Lancando dados...");
        movimentos = dado.jogarDados();
        String movimentos = "\u001b[H\u001b[17B\u001b[1C                               \u001b[H\u001b[17B\u001b[1C";
        System.out.println(movimentos + "Você tem " + movimentos + " movimento(s)");
    }

    private boolean executarMovimentos() {
        boolean running = true;
        String movimento = "\u001b[H\u001b[17B\u001b[1C                               \u001b[H\u001b[17B\u001b[1C";

        imprimirInstrucoes();

        while (this.movimentos > 0) {
            player.imprimirIlhaAtual();

            System.out.println(movimento + "Você tem " + movimentos + " movimento(s)");
            System.out.println(tela.ultimaLinha() + "Insira o comando: ");
            int command = keyboard.nextInt();

            if (command == 99) {
                running = false;
            } else if (command == 5) {
                running = player.moverCima(mapa);
            } else if (command == 1) {
                running = player.moverEsquerda(mapa);
            } else if (command == 2) {
                running = player.moverBaixo(mapa);
            } else if (command == 3) {
                running = player.moverDireita(mapa);
            }
            movimentos -= 1;
        }

        player.imprimirIlhaAtual();
        System.out.println(movimento + "Você tem " + movimentos + " movimento(s)");

        return running;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
