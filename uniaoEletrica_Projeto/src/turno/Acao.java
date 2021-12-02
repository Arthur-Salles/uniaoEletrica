package turno;

import java.util.Random;
import java.util.Scanner;

import mapa.Ilha;
import player.Player;
import pokemon.Pokemon;
import skills.Skills;

public class Acao {
    private Random dado = new Random();
    private Scanner leitor = new Scanner(System.in);
    private Player p;

    public Acao(Player k){
        this.p = k;
    }
    
    public boolean start() {
    	boolean succed = true;
    	imprimirInstrucoes();

		switch (leitor.nextInt()){
		case 1:
			choosePokemon();
			break;
		case 2:
			consumeItem();
			break;
		case 3:
			succed = attackPokemon();
			break;
		case 4:
			succed = capturePokemon();
			break;
		default:
			break;
		}
		
		p.regenerarPokemons();
		return succed;		
    }
    
    private void imprimirInstrucoes() {
    	System.out.println("---FASE DE ACAO---");
		System.out.println("(1) Escolher um pokemon");
		System.out.println("(2) Usar um item do inventario");
		System.out.println("(3) Atacar um pokemon presente na ilha");
		System.out.println("(4) Tentar a captura de um pokemon presente na ilha ");
		System.out.println("(5) Encerrar fase de ação");
		System.out.println("Digite o numero da acao desejada: ");
    }

    void choosePokemon(){
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

    private void consumeItem() {
    	try {
            int itemSelector = chooseItem();
            p.consumeItem(itemSelector);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nada acontece");
        }
	
    }
    
    public boolean attackPokemon() {
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
        
        return combate.start();
    }
    
    private boolean capturePokemon() {
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
        Captura captura = new Captura(p, pokemon);
         
        return captura.start();
	}
    
    int chooseItem(){
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

}

