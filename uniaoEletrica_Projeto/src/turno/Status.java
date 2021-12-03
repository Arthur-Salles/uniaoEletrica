package turno;

import mapa.Mapa;
import player.Player;

public class Status {
	Player player;
	Mapa mapa;
	
	public Status(Player player, Mapa mapa) {
		this.player = player;
		this.mapa = mapa;
	}
	
	public void imprimir() {
			System.out.println(" ");
	        System.out.println(" --- Status do jogo ---\nSeus Pokemons: ");
	        player.printPokemons();
	        System.out.println("Seu inventário: ");
	        player.printItens();
	        System.out.println("Pokemons Atacaveis e Capturaveis: ");
	        player.imprimirPokemonsDisponiveisParaAtaque();
	        int n = mapa.totalPokemons();
	        System.out.printf("Existem %d pokemons restantes dentre todas ilhas\n", n);
	}
}
