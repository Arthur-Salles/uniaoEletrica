package mapa;
import player.Player;
import pokemon.Tipo;
import transporte.Ponte;
import transporte.Portal;

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
			adicionarPontes(i, j, c);
			adicionarPortal(i, j, c);
		}
	}
	
	private void adicionarPortal(int i, int j, int c) {
		Portal portal = new Portal(new TriplaCoordenada(i/2, j/2, c));
		adicionarObjeto(portal, portal.getPosicaoAtual());

	}

	private void adicionarPontes(int i, int j, int k) {
		Ponte ponte1 = new Ponte(new TriplaCoordenada(i/2, j-1, k));
		Ponte ponte2 = new Ponte(new TriplaCoordenada(i/2, 0, k));
		Ponte ponte3 = new Ponte(new TriplaCoordenada(i-1, j/2, k));
		Ponte ponte4= new Ponte(new TriplaCoordenada(0, j/2, k));

		adicionarObjeto(ponte1, ponte1.getPosicaoAtual());
		adicionarObjeto(ponte2, ponte2.getPosicaoAtual());
		adicionarObjeto(ponte3, ponte3.getPosicaoAtual());
		adicionarObjeto(ponte4, ponte4.getPosicaoAtual());
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
	
	public boolean moverPlayer(Player player, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
		int i = posicaoNova.getX();
		int j = posicaoNova.getY();
		int k = posicaoNova.getZ();
		boolean running = false;
		
		if (ilha[i][j][k].operar(player)) {
			running = true;
			removerElemento(posicaoAntiga);
			running = adicionarObjeto(player, posicaoNova);
		}else {
			removerElemento(posicaoAntiga);
			running = false;
		}	

		return running;
	}
	
	public boolean moverElemento(Player player, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
		removerElemento(posicaoAntiga);

		return adicionarObjeto(player, posicaoNova);
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
