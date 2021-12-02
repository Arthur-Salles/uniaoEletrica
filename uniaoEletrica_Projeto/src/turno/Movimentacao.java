package turno;

import java.util.Random;
import java.util.Scanner;

import mapa.Mapa;
import player.Player;

public class Movimentacao {
    private Scanner keyboard = new Scanner(System.in);
	private int movimentos = 0;
	private Player player;
	private Random dado = new Random();
	private Mapa mapa;
	
	public Movimentacao(Player player, Mapa mapa) {
		this.player = player;
		this.mapa = mapa;
	}
	
	public boolean start() {
		return executarMovimentos();
	}
	
	private void imprimirInstrucoes() {
		System.out.println("---FASE DE MOVIMENTACAO---");
		System.out.println("Lancando dados...");
        movimentos = dado.nextInt(12)+2;
        System.out.println("Você tem " + movimentos + " movimento(s)");
	}
	
	private boolean executarMovimentos() {
		boolean running = true;
		
		imprimirInstrucoes();
		
        while(this.movimentos > 0) {
        	clearScreen();
        	player.imprimirIlhaAtual();
            System.out.println("Você tem " + movimentos + " movimento(s)");
            System.out.println("Insira o comando: ");
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
            movimentos -=1;  
        } 
        
    	player.imprimirIlhaAtual();
        System.out.println("Você tem " + movimentos + " movimento(s)");
        
        return running;
	}
	
	public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
