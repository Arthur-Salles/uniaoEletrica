package player;
import java.util.ArrayList;
import mapa.Coordenadas;
import mapa.ElementoIlha;
import mapa.Ilha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoIlha{
	private TriplaCoordenada posicaoAnterior;
    private ArrayList<Ilha> ilhasVisitadas = new ArrayList<Ilha>();
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private Ilha ilhaAtual;
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private ArrayList<Item> itens = new ArrayList<Item>();
    private Pokemon activePokemon;


    public Player(TriplaCoordenada posicao){
        super(posicao, "P");
    	posicaoAnterior = posicao;
    }

    public void addPokemon(PokemonNPC k){
        pokemons.add(k);
    }

	public boolean moverCima(Mapa mapa) {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(-1, 0, 0);
		return ilhaAtual.moverPlayer(this, mapa, posicaoAnterior, super.getPosicaoAtual());
	}

	public boolean moverEsquerda(Mapa mapa) {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(0, -1, 0);	
		return ilhaAtual.moverPlayer(this, mapa, posicaoAnterior, super.getPosicaoAtual());
	}

	public boolean moverBaixo(Mapa mapa) {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(1, 0, 0);	
		return ilhaAtual.moverPlayer(this, mapa, posicaoAnterior, super.getPosicaoAtual());
	}

	public boolean moverDireita(Mapa mapa) {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(0, 1, 0);	
		return ilhaAtual.moverPlayer(this, mapa, posicaoAnterior, super.getPosicaoAtual());
	}

	public TriplaCoordenada getPosicaoAnterior() {
		return posicaoAnterior;
	}

	public void viajarParaIlha(Ilha ilha) {
		ilhaAtual = ilha;
		zerarPosicao();
		ilha.adicionarObjeto(this, super.getPosicaoAtual());
		if (!ilhasVisitadas.contains(ilha)) {
			ilhasVisitadas.add(ilha);
		}
	}

	public void imprimirIlhasVisitadas() {
		ilhasVisitadas.forEach((k) -> k.imprimirIcone(" "));
	}
	
	protected void zerarPosicao() {
		super.zerarPosicao();
	}
	
	public boolean jaVisitouIlha(Ilha ilha) {
		boolean jaVisitouIlha = false;
		if (ilhasVisitadas.contains(ilha)) {
			jaVisitouIlha = true;
		}
		return jaVisitouIlha;
	}

	public void imprimirIlhaAtual() {
		int nivel = super.getNivel();
		ilhaAtual.imprimirIlha(nivel);
		System.out.println("Nivel " + nivel);
	}
	
	public void mudarDeNivel(int n) {
		posicaoAnterior = super.getPosicaoAtual();
		zerarPosicao();
		super.mudarDeNivel(0, 0, n);
		ilhaAtual.adicionarObjeto(this, super.getPosicaoAtual());
	}

	public void imprimirNiveisDisponiveis() {
		ilhaAtual.imprimirNiveisDisponiveis(super.getNivel());
	}
    
    public int printPokemons(){
        for(int i = 0; i < pokemons.size(); i++){
            System.out.println(i+ ": " + pokemons.get(i).showInfo());
        }
        return pokemons.size();
    }

    public void setActivePokemon(int k){
        this.activePokemon = pokemons.get(k);
    }

}
