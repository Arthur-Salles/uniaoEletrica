package transporte;

import mapa.TriplaCoordenada;
import player.Player;

public class Ponte extends Transporte{

	public Ponte(TriplaCoordenada posicao) {
		super(posicao, "~");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean transportar(Player player) {
		System.out.print("Voce pode ir para as seguintes ilhas: ");
		return false;
	}
}
