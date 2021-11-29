package transporte;

import mapa.ElementoIlha;
import mapa.TriplaCoordenada;
import player.Player;

public class Transporte extends ElementoIlha{

	public Transporte(TriplaCoordenada posicao, String icone) {
		super(posicao, icone);
	}
	
	@Override 
	public boolean operar(Player player) {
		return transportar(player);
	}
	
	public boolean transportar(Player player) {
		return true;
	}
}
