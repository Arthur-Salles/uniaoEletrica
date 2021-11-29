package mapa;

public class ElementoGeografico extends Elemento {
	private Coordenadas posicaoAtual;
	
	public ElementoGeografico(Coordenadas posicao, String icone) {
		super(icone);
		this.posicaoAtual = posicao;
	}
	
	protected void mudarPosicao(int a, int b) {
		posicaoAtual = posicaoAtual.mudarPosicao(a, b);
	}
	
	protected Coordenadas getPosicaoAtual() {
		return posicaoAtual;
	}

	public boolean estaDentroDoMapa(int a, int b) {
		return posicaoAtual.verificarSeEstaDentroDoMapa(a, b);
	}


}
