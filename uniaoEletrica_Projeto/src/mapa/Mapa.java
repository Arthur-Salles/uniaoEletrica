package mapa;

public class Mapa {
	private ElementoGeografico[][] mapa;
	String iconePosicoesVazias = "--";
	
	public Mapa (int i, int j) {
		mapa = new ElementoGeografico[i][j];
		
		for(int a=0; a < i; a++) {
			for (int b=0; b < j; b++) {
				mapa[a][b] = new ElementoGeografico(new Coordenadas(a, b), iconePosicoesVazias);
			}
		}		
	}
	
	public boolean adicionarIlha(Ilha ilha, Coordenadas coord) {
		boolean foiAdicionado = false;

		if (ilha.estaDentroDoMapa(mapa.length, mapa[0].length)) {
			this.mapa[coord.getX()][coord.getY()] = ilha;
			foiAdicionado = true;
		}
		
		return foiAdicionado;
	}

	public void imprimirMapa() {
		for (int i=0; i<mapa.length; i++){
			for (int j=0; j<mapa[0].length; j++) {
				mapa[i][j].imprimirIcone();
			}
			System.out.println(" ");
		}
		
	}
	
}
