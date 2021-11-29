package transporte;

import mapa.TriplaCoordenada;
import player.Player;

public class Portal extends Transporte{

	public Portal(TriplaCoordenada posicao) {
		super(posicao, "o");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean transportar(Player player) {
		System.out.print("Voce pode visitar as seguintes ilhas: ");
		player.imprimirIlhasVisitadas();
		System.out.println(" ");
		System.out.println("Select the Island: ");
		return false;
	}

}
