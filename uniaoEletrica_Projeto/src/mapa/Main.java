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
		
		Ilha ilha1 = new Ilha(10, 10, 5, new Coordenadas(0,0), "I1");
		Ilha ilha2 = new Ilha(8, 8, 5, new Coordenadas(7,7), "I2");
		Mapa mapa = new Mapa(10, 10);
		mapa.adicionarIlha(ilha1, new Coordenadas(0,0));
		mapa.adicionarIlha(ilha2, new Coordenadas(7,7));
		Player player = new Player(new TriplaCoordenada(0,0,0));
		ilha1.adicionarObjeto(player, new TriplaCoordenada(0,0,0));
		
		runGame(mapa, player, ilha1, ilha2);
		//travelToIsland(player, ilha);
	}
	
	public static void runGame(Mapa mapa, Player player, Ilha ilha1, Ilha ilha2) {

        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        boolean travelling = false;
        
        mapa.imprimirMapa();
        System.out.print("Select an Island: ");
        player.alterarPermissaoParaViajar();
        
        while (running) {
        	String command = keyboard.nextLine();
        	
	        if (command.compareTo("I1") == 0){
	        	if (player.jaVisitouIlha(ilha1) || player.podeVisitarQualquerIlha()) {
	        		player.zerarPosicao();
	        		ilha1.adicionarObjeto(player, player.getPosicaoAtual());
	        		player.adicionarIlhaVisitada(ilha1);
		        	travelToIsland(player, ilha1);
	        	}
	        }else if (command.compareTo("I2") == 0){
	        	if (player.jaVisitouIlha(ilha2) || player.podeVisitarQualquerIlha()) {
	        		player.zerarPosicao();
	        		ilha2.adicionarObjeto(player, player.getPosicaoAtual());
	        		player.adicionarIlhaVisitada(ilha2);
		        	travelToIsland(player, ilha2);
	        	}
	        }
	        else if (command.compareTo("quit") == 0) {
	        	running = true;
            }  
	    }
    }
	
	public static void travelToIsland(Player player, Ilha ilha) {

        Scanner keyboard = new Scanner(System.in);
        boolean travelling = true;
               
        while (travelling) {
        	ilha.imprimirIlha(player.getNivel());
            System.out.print("Enter the command: ");
            String command = keyboard.nextLine();
            
            if (command.compareTo("quit") == 0) {
            	travelling = false;
            } else if (command.compareTo("w") == 0) {
                player.moverCima();
                travelling = ilha.moverPlayer(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("a") == 0) {
                player.moverEsquerda();
                travelling = ilha.moverPlayer(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("s") == 0) {
                player.moverBaixo();
                travelling = ilha.moverPlayer(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            } else if (command.compareTo("d") == 0) {
                player.moverDireita();
                travelling = ilha.moverPlayer(player, player.getPosicaoAnterior(), player.getPosicaoAtual());
            }
    	}	
        
    }
	
}
