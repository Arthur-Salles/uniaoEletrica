package turno;

import mapa.Mapa;
import player.Player;

public class Turno {
	Player player;
	Mapa mapa;
	Acao faseAcao;
    Movimentacao faseMovimentacao;
    
    public Turno(Player player, Mapa mapa) {
    	this.player = player;
    	this.mapa = mapa;
    	faseAcao = new Acao(player);
    	faseMovimentacao = new Movimentacao(player, mapa);
    }
    
    public void start() {    	
    	faseMovimentacao.start();
        faseAcao.start();
    }

}
