package mapa;

public class ElementoIlha extends Elemento{
	private TriplaCoordenada posicaoAtual;
	private int nivel;
	
	public ElementoIlha(TriplaCoordenada posicao, String icone, int nivel) {
		super(icone);
		this.posicaoAtual = posicao;
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	protected void mudarPosicao(int a, int b, int c) {
		posicaoAtual = posicaoAtual.mudarPosicao(a, b, c);
	}
	
	protected Coordenadas getPosicaoAtual() {
		return posicaoAtual;
	}

	public boolean estaDentroDoMapa(int a, int b, int c) {
		return posicaoAtual.verificarSeEstaDentroDoMapa(a, b, c);
	} 
	
}
