package mapa;

import java.util.ArrayList;

public class Mapa {
	private ElementoGeografico[][] mapa;
    private ArrayList<Ilha> ilhasDisponiveis = new ArrayList<Ilha>();
	private String iconePosicoesVazias = "--";
	private int n;
	
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
			ilhasDisponiveis.add(ilha);
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

	public void imprimirIlhasDisponiveis(int n, Ilha ilhaAtual) {
		if (!ilhasDisponiveis.isEmpty()) {
			for(int i=0; i<ilhasDisponiveis.size(); i++) {
				Ilha ilha =	ilhasDisponiveis.get(i);
				if (ilha != ilhaAtual) {
					ilha.imprimirSeTemNivel(n);
				}
			}
		}
	}
	
	public Ilha getIlha (int i) {
		return ilhasDisponiveis.get(i-1);
	}

	public boolean AllIslandsAreEmpty() {
		if (!ilhasDisponiveis.isEmpty()) {
			for (int i=0; i<ilhasDisponiveis.size(); i++) {
				if (!ilhasDisponiveis.get(i).isEmpty()) { //se nao esta vazia eh mentira que todas ihas estao vazias
					return false;
				}
			}
		}
		return true;
	}

	public boolean ilhaEhValida(Integer valueOf, int nivelAtual, Ilha ilhaAtual) {
		boolean ilhaEhValida = false;
		
		if (!ilhasDisponiveis.isEmpty()) {
			if (valueOf > 0) {
				if (ilhasDisponiveis.size() >= (valueOf)){
					Ilha ilha = ilhasDisponiveis.get(valueOf-1);
					if (ilha!=ilhaAtual) {
						if (ilha.nivelEhValido(nivelAtual)){
							ilhaEhValida = true;
						}
					}
				}
			}
		}
		return ilhaEhValida;
	}
	
}
