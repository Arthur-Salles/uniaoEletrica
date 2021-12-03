package turno;

import java.util.InputMismatchException;
import java.util.Scanner;
import dados.Dado;
import mapa.Mapa;
import player.Player;

public class Movimentacao {
    private Scanner keyboard = new Scanner(System.in);
	private int movimentos = 0;
	private Player player;
	private Dado dado = new Dado(2, 6);
	private Mapa mapa;
	private boolean isStillRunning = true;
	
	public Movimentacao(Player player, Mapa mapa) {
		this.player = player;
		this.mapa = mapa;
	}
	
	public boolean isStillRunning() {
		return isStillRunning && !player.isDead();
	}
	
	public void start() {
		isStillRunning = executarMovimentos();
	}
	
	private void imprimirInstrucoes() {
		System.out.println("---FASE DE MOVIMENTACAO---");
		System.out.println("Lancando dados...");
        movimentos = dado.jogarDados();
        System.out.println("Você tem " + movimentos + " movimento(s)");
        System.out.println("Utilize:\n(1) Esquerda\n(2) Baixo\n(3) Direita\n(5) Cima");
	}
	
	private boolean executarMovimentos() {
		boolean running = true;
		
		imprimirInstrucoes();
		
        while(this.movimentos > 0) {
        	player.imprimirIlhaAtual();
            System.out.println("Você tem " + movimentos + " movimento(s)");
            int command = 0;
            do{
                try{
                    System.out.println("Insira o comando: ");
                    command = keyboard.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Por favor para de tentar quebrar o codigo\nDigite um NUMERO:\n");
                    movimentos += 1;
                }
                keyboard.nextLine(); // limpa o buffer
            }while(Character.isAlphabetic(command) && running);

            if (command == 99) {
            	running = false;
            } else if (command == 5) {
                 player.moverCima(mapa);
            } else if (command == 1) {
                player.moverEsquerda(mapa);
            } else if (command == 2) {
                player.moverBaixo(mapa);
            } else if (command == 3) {
                player.moverDireita(mapa);
            }
            else{
                System.out.println("Nao quis digitar certo vai perder movimento");
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
