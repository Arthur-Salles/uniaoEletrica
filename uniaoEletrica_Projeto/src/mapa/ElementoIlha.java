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
	
	private void mover(int i, int j, int k){
		posicaoAtual = posicaoAtual.mudarPosicao(i, j, k);
	}

	public boolean operar(Player player) {
		return true;
	}
	
	public void zerarPosicao() {
		posicaoAtual.zerarPosicao();
	}

}
