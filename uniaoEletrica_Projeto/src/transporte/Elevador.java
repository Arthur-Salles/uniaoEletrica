package transporte;

import mapa.TriplaCoordenada;
import player.Player;

public class Elevador extends Transporte{

	public Elevador(TriplaCoordenada posicao) {
		super(posicao, "||");
	}
	
	@Override
	public boolean transportar(Player player) {
		System.out.print("Voce pode ir para os seguintes niveis: ");
		
		return false;
	}

}
