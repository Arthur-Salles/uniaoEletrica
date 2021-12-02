package game;

import java.util.Random;
import java.util.Scanner;
import action.Acao;
import itens.Fruta;
import mapa.Coordenadas;
import mapa.Ilha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;
import pokemon.Pokemon;
import pokemon.Tipo;

public class Game {
    private Random dado = new Random();
    private int movimento;
    private Scanner keyboard = new Scanner(System.in);
    private boolean running = true;
    private Mapa mapa;
    private Player player;
    private Acao ui;
		
    private boolean movimentando = false; 
    
	public void start() {
		criarMapa();	
		player = new Player(new TriplaCoordenada(0,0,0));
		criarPokemons();
		ui = new Acao(player);		

		runGame(mapa, player);
	}
	
	private void criarMapa() {
		mapa = new Mapa(10, 10);
		
		criarIlha(10, 5, new Coordenadas(0,0), "I1");
		criarIlha(8, 5, new Coordenadas(7,7), "I2");
		criarIlha(8, 3, new Coordenadas(9,9), "I3");
	}
	
	private void criarPokemons() {

        Tipo[] kek = {Tipo.WATER};
        Tipo[] kek1 = {Tipo.WATER, Tipo.WATER};
		
	
		Pokemon pikachu = new Pokemon("R", kek , new TriplaCoordenada(2, 2, 0), 20, 15, 7);
        Pokemon leonardo = new Pokemon("L", kek1, new TriplaCoordenada(2, 2, 0), 30, 20, 5);

        player.addPokemon(leonardo);

        mapa.getIlha(1).adicionarPokemon(pikachu, pikachu.getPosicaoAtual());
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
			movimentando = true;
		
			while (running && !player.isDead()) {
				if (movimentando) {
					executarMovimentosPlayer();
				}else {
					executarAcao();
				}
			}	
        
        	System.out.print("GAME OVER");
	}
	
	private void executarAcao() {
		System.out.println("---FASE DE ACAO---");
		System.out.println("(1) Escolher um pokemon");
		System.out.println("(2) Usar um item do inventario");
		System.out.println("(3) Atacar um pokemon presente na ilha");
		System.out.println("(4) Tentar a captura de um pokemon presente na ilha ");
		System.out.println("(5) Encerrar fase de ação");
		System.out.println("Digite o numero da acao desejada: ");

		switch (keyboard.nextInt()){
		case 1:
			ui.choosePokemon(); 
			break;
		case 2:
			ui.chooseItem();
			break;
		case 3:
			ui.attackPokemon();
			break;
		case 4:
			ui.capturePokemon();
			break;
		default:
			break;
		}	
		movimentando = true;

	}
	
	private void executarMovimentosPlayer() {
		System.out.println("---FASE DE MOVIMENTACAO---");
		System.out.println("Lancando dados...");
        movimento = dado.nextInt(12)+2;
        System.out.println("Você tem " + movimento + " movimento(s)");

        
        while(this.movimento > 0) {
        	player.imprimirIlhaAtual();
            System.out.println("Você tem " + movimento + " movimento(s)");
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
            movimento -=1;  
        } 
        
    	player.imprimirIlhaAtual();
        System.out.println("Você tem " + movimento + " movimento(s)");
        movimentando = false;
	}	
}
