package ui;

import java.util.Random;
import java.util.Scanner;

import mapa.Ilha;
import player.Player;
import pokemon.Combate;
import pokemon.Pokemon;
import skills.Skills;

public class Interacao {
    private Random dado = new Random();
    private Scanner leitor = new Scanner(System.in);
    private Player p;

    public Interacao(Player k){
        this.p = k;
    }

    public void choosePokemon(){
            int k = 0;
            System.out.println("Pokemons disponiveis: ");
            int max = p.printPokemons();
            System.out.println("Digite o numero do pokemon escolhido: ");
            k = leitor.nextInt();
            while(k < 0 || k > max){
                System.out.println("De um número no intervalo correto!");
                k = leitor.nextInt();
            }
            p.setActivePokemon(k);
    		System.out.println("Pokemon " + k + " esta ativo!");
    }
    
    public int chooseAction(){
        System.out.println("(1) Atacar\n(2) Usar Habilidade\n(3) Usar Item");
        int k = leitor.nextInt();
        while(k < 0 || k > 3){
            System.out.println("Um numero entre os citados pfv!");
            k = leitor.nextInt();
        }
        return k;
    }


    public int chooseItem(){
        try{
            System.out.println("Os itens disponiveis sao: ");
            int max = p.printItens();
            if(max == 0){
                throw new IndexOutOfBoundsException();
            }

            System.out.println("Digite o numero do item escolhido: ");

            int k = leitor.nextInt();
            while(k < 0 || k > max){
                System.out.println("De um numero no intervalo correto!");
                k = leitor.nextInt();
            }
            return k;
        }
        catch(IndexOutOfBoundsException e){
            return 0;
        }
    }
    
    public void attackPokemon() {
    	int k = 0;
    	
        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        System.out.println("De o número para escolher o pokemon: ");
        k = leitor.nextInt();
        while(k < 0 || k > max){
            System.out.println("De um número no intervalo correto!");
            k = leitor.nextInt();
        }
        
        Pokemon pokemon = p.getPokemonParaCombate(k);
        Combate combate = new Combate(p, pokemon,true);
    }
    

    public void pokemonIsDead(Pokemon k){
    	p.perdeuPokemon(k);
    	if (p.temPokemons()) {
            System.out.println(k.showInfo() + " esta morto!\nEscolha outro!");
            choosePokemon();
    	}else {
            System.out.println(k.showInfo() + " esta morto!\nVoce nao tem outros pokemons!");
            p.gameOver();
    	}
    }

    public void pokemonCaptured(Pokemon k){
        System.out.println(k.getNome() + " foi capturado!");
    }

    public Skills chooseSkill(Pokemon activePokemon){
        try {
            int max = activePokemon.showAllSkills();
            if(max == 0){
                throw new IndexOutOfBoundsException();
            }
            System.out.println("Digite o número da habilidade");
            int k = leitor.nextInt();
            while(k < 0 || k > max){
                System.out.println("para de tentar quebrar o jogo namoral");
                k = leitor.nextInt();
            }
            return activePokemon.getSkill(k);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nao há habilidades disponiveis");
            return new Skills();
        }
    }

    public void printPokemonsStatus(Pokemon a, Pokemon b){
        System.out.println(a.showInfo() + "\n" + b.showInfo());
    }

    public void printWinner(Pokemon a){
        System.out.printf("O pokemon %s ganhou a luta\n", a.getNome());
    }

	public boolean capturePokemon() {
		int k = 0;
    	
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        System.out.println("De o número para escolher o pokemon: ");
        k = leitor.nextInt();
        while(k < 0 || k > max){
            System.out.println("De um número no intervalo correto!");
            k = leitor.nextInt();
        }
        
        Pokemon pokemon = p.getPokemonParaCombate(k);
        
        for (int i=0; i<2; i++) {
            System.out.println("Lancando dados...");
        	int lance = dado.nextInt(12)+2;
            System.out.println(lance);
        	if (pokemon.tryCapture(lance)) {
                System.out.println("Captura Bem Sucedida!");
                pokemonCaptured(pokemon);
                p.addPokemon(pokemon);
                p.removerPokemonIlha(pokemon);
                return true;
        	}else {
        		System.out.println("Captura Falhou!");
        	}
        }
        
        System.out.println(pokemon.getNome() + " entrando em modo hostil");
        Combate combate = new Combate(p, pokemon,false);
        return false;
	}

    public void emitAttackWarning(Pokemon k){
        System.out.println(k.getNome() + " te atacou!");
    }

}

