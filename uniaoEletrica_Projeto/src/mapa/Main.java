package mapa;
import java.util.Scanner;
import skills.*;
import ui.*;

import player.Player;

public class Main {

	public static void main(String[] args) {
		// so para testar
        // Player l = new Player(new Coordenadas(2, 9));

        // Interacao ui = new Interacao(l);
        // ui.movePlayer();
        //TR t1 = new TR();
        //t1.generateSkill();
		
		Ilha ilha = new Ilha(10, 10, 5, new Coordenadas(0,0), "I1");
		Mapa mapa = new Mapa(10, 10);
		mapa.adicionarIlha(ilha, new Coordenadas(0,0));
		Player player = new Player(new TriplaCoordenada(0,0,0));
		ilha.adicionarObjeto(player, new TriplaCoordenada(0,0,0));
		
		runGame(mapa, player, ilha);
	}
	public static void runGame(Mapa mapa, Player player, Ilha ilha) {

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        
        mapa.imprimirMapa();
        System.out.print("Select an Island: ");
        
        if (keyboard.nextLine().compareTo("I1") == 0){
        		        
        ilha.imprimirIlha(player.getNivel());
        while (running) {
            System.out.print("Enter the command: ");
            String command = keyboard.nextLine();
            
            if (command.compareTo("quit") == 0) {
                running = false;
            } else if (command.compareTo("w") == 0) {
                player.moverCima();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("a") == 0) {
                player.moverEsquerda();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("s") == 0) {
                player.moverBaixo();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("d") == 0) {
                player.moverDireita();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            }
            ilha.imprimirIlha(player.getNivel());
        }
        	System.out.println("game over");
        }
    }
	
	public static void runGame(Player player, Ilha ilha) {

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        
        ilha.imprimirIlha(player.getNivel());
        while (running) {
            System.out.print("Enter the command: ");
            String command = keyboard.nextLine();
            
            if (command.compareTo("quit") == 0) {
                running = false;
            } else if (command.compareTo("w") == 0) {
                player.moverCima();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("a") == 0) {
                player.moverEsquerda();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("s") == 0) {
                player.moverBaixo();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("d") == 0) {
                player.moverDireita();
                running = ilha.moverElemento(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            }
            ilha.imprimirIlha(player.getNivel());
        }
        System.out.println("game over");
    }
	
}
