package transporte;

import mapa.ElementoIlha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Transporte extends ElementoIlha{

	public Transporte(TriplaCoordenada posicao, String icone) {
		super(posicao, icone);
	}
	
	
	@Override 
	protected void operar(Player player, Mapa mapa) {
		transportar(player, mapa);
	}
	
	public void transportar(Player player, Mapa mapa) {
	             	
	}
	
	@Override
	public boolean ehTransporte() {
		return true;
	}
}
