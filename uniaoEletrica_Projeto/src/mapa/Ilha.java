package mapa;
<<<<<<< HEAD
import java.util.Random;

import itens.Fruta;
import itens.*;
=======
import java.util.ArrayList;

>>>>>>> 7083886827c15ea7f7a9b6b95e1a3f6f03c9666f
import player.Player;
import pokemon.Pokemon;
import pokemon.Tipo;
import transporte.Elevador;
import transporte.Ponte;
import transporte.Portal;

public class Ilha extends ElementoGeografico{
	private ElementoIlha[][][] ilha;
	private String iconePosicoesVazias = "-";
	private Tipo ilhaTipo;
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> pokemonsParaCaptura = new ArrayList<Pokemon>();

	
	public Ilha(int i, int j, int k, Coordenadas posicaoNoMundo, String icone) {
		super(posicaoNoMundo, icone);
		ilha = new ElementoIlha[i][j][k];
		
		for(int c=0; c<k; c++) {
			for(int a=0; a < i; a++) {
				for (int b=0; b < j; b++) {
					ilha[a][b][c] = new ElementoIlha(new TriplaCoordenada(a, b, c), iconePosicoesVazias);
				}
			}
			adicionarTR(i, j, c);
			adicionarFrutas(i,j,c);
			adicionarPontes(i, j, c);
			adicionarPortal(i, j, c);
			adicionarElevador(i, j,c);
		}
	}
	
	private void adicionarElevador(int i, int j, int c) {
		Elevador elevador = new Elevador(new TriplaCoordenada(3, 3, c));
		adicionarObjeto(elevador, elevador.getPosicaoAtual());

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

	private void adicionarFrutas(int i, int j, int k) {
		Random kek = new Random();
		int nI = (i > 0) ? i : 1;
		int nJ = (j > 0) ? j : 1;
		int nK = (k > 0) ? k : 1;
		Fruta f = new Fruta(new TriplaCoordenada(kek.nextInt(nI), kek.nextInt(nJ), kek.nextInt(nK)), "F");
		adicionarObjeto(f, f.getPosicaoAtual());
	}

	private void adicionarTR(int i, int j, int k){
		Random kek = new Random();
		int nI = (i > 0) ? i : 1;
		int nJ = (j > 0) ? j : 1;
		int nK = (k > 0) ? k : 1;
		TR tk = new TR(new TriplaCoordenada(kek.nextInt(nI), kek.nextInt(nJ), kek.nextInt(nK)), "TR");
		adicionarObjeto(tk, tk.getPosicaoAtual());
	}

	
	public boolean adicionarObjeto(ElementoIlha obj, TriplaCoordenada coord) {
		boolean foiMovido = false;

		if (verificarSeEstaDentroDoMapa(coord)) {
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

	private void updateElemento(TriplaCoordenada posicaoAntiga){
		int linha = posicaoAntiga.getX();
		int coluna = posicaoAntiga.getY();
		int nivel = posicaoAntiga.getZ();
		ilha[linha][coluna][nivel] = new ElementoIlha(new TriplaCoordenada(linha, coluna, nivel), "P");
	}
	
	public boolean moverPlayer(Player player, Mapa mapa, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
		int i = posicaoNova.getX();
		int j = posicaoNova.getY();
		int k = posicaoNova.getZ();
		boolean viajou = false;
		
		if (posicaoNova.verificarSeEstaDentroDoMapa(ilha.length, ilha[0].length)) {
			ilha[i][j][k].operar(player, mapa);
			if (ilha[i][j][k].ehTransporte()) {
				viajou = true;
				removerElemento(posicaoAntiga);
			}
			else if(ilha[i][j][k].ehItem()){
				Item kek = (Item) ilha[i][j][k];
				updateElemento(posicaoNova);
				removerElemento(posicaoAntiga);
				player.addItem(kek);
			}
			else {
				removerElemento(posicaoAntiga);
				viajou = adicionarObjeto(player, posicaoNova);
			}
		}
		return viajou;
	}
	
	public boolean moverElemento(Player player, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
		removerElemento(posicaoAntiga);

		return adicionarObjeto(player, posicaoNova);
	}
		
	protected boolean verificarSeEstaDentroDoMapa(TriplaCoordenada coord){
		boolean estaDentro = false;
		
		if (coord.verificarSeEstaDentroDoMapa(ilha.length, ilha[0].length)) {
			if (coord.getZ() <= ilha[0][0].length && coord.getZ() >= 0){
				estaDentro = true;
			}
		}

		return estaDentro;
	}

	public void imprimirIlha(int nivel) {
		System.out.println(" ----- " + super.getIcone() + " ----- ");
		for (int i=0; i<ilha.length; i++){
			for (int j=0; j<ilha[0].length; j++) {
				ilha[i][j][nivel].imprimirIcone();
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
	}

	public void imprimirNiveisDisponiveis(int nivelAtual) {
		for (int i=0; i<ilha[0][0].length; i++) {
			if(i!=nivelAtual) {
				System.out.print(" "+ i);
			}
		}
		System.out.println(" ");
	}

	public void imprimirSeTemNivel(int n) {
		if (ilha[0][0].length>=n) {
			super.imprimirIcone(" ");
		}
	}
	
	public void obterPokemonsParaCaptura(TriplaCoordenada coordPlayer) {
	    this.pokemonsParaCaptura = new ArrayList<Pokemon>();
		
	    pokemons.forEach((k) -> verificarPodeSerCapturado(k, coordPlayer));   
		
	}
	
	
	private void verificarPodeSerCapturado(Pokemon k, TriplaCoordenada coordPlayer) {
		if (k.verificarDistanciaD(coordPlayer)) {
			this.pokemonsParaCaptura.add(k);
		}
	}

	public int imprimirPokemonsDisponiveisParaAtaque(TriplaCoordenada coordPlayer) {
		obterPokemonsParaCaptura(coordPlayer);
		if(pokemonsParaCaptura.size() == 0){
            System.out.println("Nao há itens");
        }
        for(int i = 0; i < pokemonsParaCaptura.size(); i++){
            System.out.println("(" + i+ ")" + pokemonsParaCaptura.get(i).showInfo());
        }
        return pokemonsParaCaptura.size();			
	}

	public Pokemon getPokemonParaCombate(int k) {
		Pokemon pokemon = pokemonsParaCaptura.get(k);
		return pokemon;
	}

	public void adicionarPokemon(Pokemon pikachu, TriplaCoordenada posicaoAtual) {
		adicionarObjeto(pikachu, posicaoAtual);
		pokemons.add(pikachu);
	}

	public void removerPokemon(Pokemon k) {
		TriplaCoordenada c = k.getPosicaoAtual();
		int x = c.getX();
		int y = c.getY();
		int z = c.getZ();
		ilha[x][y][z] = new ElementoIlha(new TriplaCoordenada(x, y, z), iconePosicoesVazias);
		pokemons.remove(k);
		pokemonsParaCaptura.remove(k);
	}
	
}
