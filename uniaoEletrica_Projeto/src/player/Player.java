package player; // dps fazer os pacotes serem todos referentes a pasta global

import java.security.Policy;
import java.util.ArrayList;

import itens.Item;
import mapa.Coordenadas;
import mapa.ElementoIlha;
import mapa.Ilha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import pokemon.PokemonNPC;

public class Player extends ElementoIlha {
    private TriplaCoordenada posicaoAnterior;
    private ArrayList<Ilha> ilhasVisitadas = new ArrayList<Ilha>();
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private Ilha ilhaAtual;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private Pokemon activePokemon;
    private boolean gameOver = false;

    public Player(TriplaCoordenada posicao){
        super(posicao, "P ");
    	posicaoAnterior = posicao;
    }

    public void addPokemon(Pokemon k){
        if(pokemons.isEmpty()){
            pokemons.add(k);
            setActivePokemon(0);
        }else {
            pokemons.add(k);
        }
    }

    public void addItem(Item k) {
        itens.add(k);
		System.out.println(k.toString() + " foi adicionado!");
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

    public void viajarParaIlha(Ilha ilha) { /// entrando na ilha
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

    public int printPokemons() {
        if (pokemons.size() == 0) {
            System.out.println("Nao há itens");
        }

        for(int i = 0; i < pokemons.size(); i++){
            System.out.println("("+ i+") " + pokemons.get(i).showInfo());
        }
        return pokemons.size();
    }

    public void setActivePokemon(int k) {
        this.activePokemon = pokemons.get(k);
    }

    public int printItens() {
        if (itens.size() == 0) {
            System.out.println("Não há itens");
        }

        for (int i = 0; i < itens.size(); i++){
            System.out.println("(" + i + ") " + itens.get(i).toString());
        }
        return itens.size();
    }

    public void consumeItem(int k) {
        Item using = this.itens.get(k);
        using.use(activePokemon);
        itens.remove(using);
    }

    public void deleteItem(int k) {
        itens.remove(k);
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public Item getItem(int k) {
        return this.itens.get(k);
    }

    public Coordenadas getCoordenadas() {
        return super.getPosicaoAtual();
    }

	public int imprimirPokemonsDisponiveisParaAtaque() {
		return ilhaAtual.imprimirPokemonsDisponiveisParaAtaque(super.getPosicaoAtual());
	}

	public Pokemon getPokemonParaCombate(int k) {
		return ilhaAtual.getPokemonParaCombate(k);	
	}

	public void removerPokemonIlha(Pokemon nonPlayer) {
		ilhaAtual.removerPokemon(nonPlayer);
	}

	public void perdeuPokemon(Pokemon k) {
		pokemons.remove(k);	
	}

	public boolean temPokemons() {
		boolean temPokemons = true;
		
		if (pokemons.isEmpty()) {
			temPokemons = false;
		}
		return temPokemons;
	}

	public void gameOver() {
		gameOver = true;		
	}

	public boolean isDead() {
		return gameOver;
	}

	public void regenerarPokemons() {
		pokemons.forEach((k) -> k.regenerate());
		
	}

}
