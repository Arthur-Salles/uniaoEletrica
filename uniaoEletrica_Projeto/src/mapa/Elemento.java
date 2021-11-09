package mapa;

public class Elemento {
	private String icone;

	public Elemento(String icone) {
		this.icone = icone;
	}

	protected void mudarPosicao(int a, int b) {
		posicaoAtual = posicaoAtual.mudarPosicao(a, b);
	}
	
	protected Coordenadas getPosicaoAtual() {
		return posicaoAtual;
	}
	protected String getIcone() {
		return icone;
	}
	
	public boolean estaDentroDoMapa(int a, int b) {
		return posicaoAtual.verificarSeEstaDentroDoMapa(a, b);
	} 
}
