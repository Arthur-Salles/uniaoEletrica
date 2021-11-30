package mapa;

import java.util.Random;
import java.util.Scanner;

import player.Player;

public class Game {
    private Random dado = new Random();
    private int movimento;
    private Scanner keyboard = new Scanner(System.in);
    private boolean travelling = true;
    private Mapa mapa;
    Player player;
		
	public void start() {
		criarMapa();		
		runGame(mapa, player);
	}
	
	private void criarMapa() {
		mapa = new Mapa(10, 10);
		
		criarIlha(10, 5, new Coordenadas(0,0), "I1");
		criarIlha(8, 5, new Coordenadas(7,7), "I2");
		criarIlha(8, 3, new Coordenadas(9,9), "I3");
		
		player = new Player(new TriplaCoordenada(0,0,0));
	}
	
	private void criarIlha(int i, int k, Coordenadas c, String icone) {
		Ilha ilha = new Ilha(i, i, k, c, icone);
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
        movimento = dado.nextInt(12)+2;
        
        while(this.movimento > 0) {
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
            
            movimento -=1;
        }        
	}	
}
