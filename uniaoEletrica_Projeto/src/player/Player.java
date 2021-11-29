package player;
import java.util.ArrayList;
import mapa.Coordenadas;
import mapa.ElementoIlha;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoIlha{
	TriplaCoordenada posicaoAnterior;

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

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

}
