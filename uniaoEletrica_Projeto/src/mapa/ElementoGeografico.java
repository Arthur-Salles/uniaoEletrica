package mapa;

public class ElementoGeografico extends Elemento {
	private Coordenadas posicaoAtual;

	
	public ElementoGeografico(Coordenadas posicao, String icone) {
		super(icone);
		this.posicaoAtual = posicao;
	}

	
}
