package mapa;

import player.Player;

public class ElementoIlha extends Elemento{
	private TriplaCoordenada posicaoAtual;
	
	public ElementoIlha(TriplaCoordenada posicao, String icone) {
		super(icone);
		this.posicaoAtual = posicao;
	}

	public int getNivel() {
		return posicaoAtual.getZ();
	}

	protected void mudarPosicao(int a, int b, int c) {
		posicaoAtual = posicaoAtual.mudarPosicao(a, b, c);
	}
	
	protected TriplaCoordenada getPosicaoAtual() {
		return posicaoAtual;
	}

	public boolean estaDentroDoMapa(int a, int b, int c) {
		return posicaoAtual.verificarSeEstaDentroDoMapa(a, b, c);
	} 
	
	public void transportar(Player player, Mapa mapa) {
		
	}
	
	protected void zerarPosicao() {
		posicaoAtual.zerarPosicao();
	}

	public boolean ehTransporte() {
		return false;
	}

	public boolean ehItem(){
		return false;
	}

	public void mudarDeNivel(int i, int j, int n) {
		posicaoAtual.mudarDeNivel(n);		
	}

}
