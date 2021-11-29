package player;
import java.util.ArrayList;
import mapa.Coordenadas;
import mapa.ElementoIlha;
import mapa.Ilha;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoIlha{
	TriplaCoordenada posicaoAnterior;
    private ArrayList<Ilha> ilhasVisitadas = new ArrayList<Ilha>();
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    boolean podeVisitarQualquerIlha = false;

    public Player(TriplaCoordenada posicao){
        super(posicao, "P");
    	posicaoAnterior = posicao;
    }

    public void addPokemon(PokemonNPC k){
        return;
    }

    public void move(int spaces){
        // faz os boundries checks
        return;
    }

    public Coordenadas getCoordenadas(){
        return super.getPosicaoAtual();
    }

	public void moverCima() {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(-1, 0, 0);	
	}

	public void moverEsquerda() {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(0, -1, 0);		
	}

	public void moverBaixo() {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(1, 0, 0);		
	}

	public void moverDireita() {
		posicaoAnterior = super.getPosicaoAtual();
		super.mudarPosicao(0, 1, 0);		
	}

	public TriplaCoordenada getPosicaoAnterior() {
		return posicaoAnterior;
	}

	public void adicionarIlhaVisitada(Ilha ilha) {
		ilhasVisitadas.add(ilha);
	}

	public void imprimirIlhasVisitadas() {
		ilhasVisitadas.forEach((k) -> k.imprimirIcone());
	}
	
	public void alterarPermissaoParaViajar() {
		if (podeVisitarQualquerIlha) {
			podeVisitarQualquerIlha = false;
		}else {
			podeVisitarQualquerIlha = true;
		}
	}
	
	public void zerarPosicao() {
		super.zerarPosicao();
	}
	
	public boolean podeVisitarQualquerIlha() {
		return podeVisitarQualquerIlha;
	}
	
	public boolean jaVisitouIlha(Ilha ilha) {
		boolean jaVisitouIlha = false;
		if (ilhasVisitadas.contains(ilha)) {
			jaVisitouIlha = true;
		}
		return jaVisitouIlha;
	}

}
