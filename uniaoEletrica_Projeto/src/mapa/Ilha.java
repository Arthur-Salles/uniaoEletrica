package mapa;
import pokemon.Tipo;

public class Ilha extends ElementoGeografico{
	private static String iconeIlha = "I";
	private ElementoIlha[][][] ilha;
	private String iconePosicoesVazias = "-";
	private Tipo ilhaTipo;
	
	public Ilha(int i, int j, int k, Coordenadas posicaoNoMundo, String icone) {
		super(posicaoNoMundo, icone);
		ilha = new ElementoIlha[i][j][k];
		
		for(int c=0; c<k; c++) {
			for(int a=0; a < i; a++) {
				for (int b=0; b < j; b++) {
					ilha[a][b][c] = new ElementoIlha(new TriplaCoordenada(a, b, c), iconePosicoesVazias);
				}
			}
		}
	}
	
	public boolean adicionarObjeto(ElementoIlha obj, TriplaCoordenada coord) {
		boolean foiMovido = false;

		if (verificarSeEstaDentroDoMapa(obj)) {
			this.ilha[coord.getX()][coord.getY()][coord.getZ()] = obj;
			foiMovido = true;
		}

		return foiMovido;
	}
	
	private void removerElemento(TriplaCoordenada posicaoAntiga) {
		int linha = posicaoAntiga.getX();
		int coluna = posicaoAntiga.getY();
		int nivel = posicaoAntiga.getZ();
		ilha[linha][coluna][nivel] = new ElementoIlha(new TriplaCoordenada(linha, coluna, nivel), iconePosicoesVazias);
	}
	
	public boolean moverElemento(ElementoIlha obj, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
				
		removerElemento(posicaoAntiga);

		return adicionarObjeto(obj, posicaoNova);
	}
		
	protected boolean verificarSeEstaDentroDoMapa(ElementoIlha obj){
		boolean estaDentro = false;
		Coordenadas coord = obj.getPosicaoAtual();
		
		if (coord.verificarSeEstaDentroDoMapa(ilha.length, ilha[0].length)) {
			if (obj.getNivel() <= ilha[0][0].length){
				estaDentro = true;
			}
		}

		return estaDentro;
	}

	public void imprimirIlha(int nivel) {
		for (int i=0; i<ilha.length; i++){
			for (int j=0; j<ilha[0].length; j++) {
				ilha[i][j][nivel].imprimirIcone();
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
	}

	
	
}
