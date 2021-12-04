package turno;

import java.util.Scanner;
import player.Player;
import pokemon.Pokemon;

public class Acao {
    private Scanner leitor = new Scanner(System.in);
    private Player p;
    private boolean isStillRunning = true;

    public Acao(Player k) {
        this.p = k;
    }

    public void start() {
        imprimirInstrucoes();
        lerInstrucoes();
        p.regenerarPokemons();
    }

    private void lerInstrucoes() {
        boolean flag = true;

    	do{
            try {
                int j = Integer.parseInt(leitor.nextLine());
                switch (j) {
                    case 1:
                        choosePokemon();
                        break;
                    case 2:
                        consumeItem();
                        break;
                    case 3:
                        attackPokemon();
                        break;
                    case 4:
                        capturePokemon();
                        break;
                    default:
                        break;
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("De o comando dnv!");
            }
    } while(flag);
    }
    
    private void imprimirInstrucoes() {
		System.out.println(" ");
        System.out.println("---FASE DE ACAO---");
        System.out.println("(1) Escolher um pokemon");
        System.out.println("(2) Usar um item do inventario");
        System.out.println("(3) Atacar um pokemon presente na ilha");
        System.out.println("(4) Tentar a captura de um pokemon presente na ilha ");
        System.out.println("(5) Encerrar fase de ação");
        System.out.println("Digite o numero da acao desejada: ");
    }

    protected void choosePokemon() {
        boolean flag = true;
        String k = "dgshgbhdfsgy";
        System.out.println("Pokemons disponiveis: ");
        p.printPokemons();
        System.out.println("Digite o numero do pokemon escolhido: ");
        do {
            try {
                k = leitor.nextLine();
                p.setActivePokemon(Integer.parseInt(k));
                flag = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e){}
        } while (flag);
        System.out.println("Pokemon " + k + " esta ativo!");
    }

    protected void consumeItem(){
        String k = "";
        boolean flag = true;
        System.out.println("Itens disponiveis: ");
        if(p.printItens() == 0){
            System.out.println("Nada a fazer");
            return;
        }
        System.out.println("De o número para escolher o item: ");

        while(flag){
            try {
                k = leitor.nextLine();
                p.consumeItem(Integer.parseInt(k));
                flag = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Comando certo pfv!");
            }
        }

    }

    public void attackPokemon() {
        String k = "sdffsf";
        boolean flag = true;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora!\nRetornando a Movimentação");
        }
        else{
        	Pokemon pokemon;

            System.out.println("De o número para escolher o pokemon: ");
            do {
                try {
                    k = leitor.nextLine();
                    pokemon = p.getPokemonParaCombate(Integer.parseInt(k));
                    Combate combate = new Combate(p, pokemon, true);
                    combate.start();
                    flag = false;
                } catch (NumberFormatException| IndexOutOfBoundsException e) {
                    System.out.println("De um numero valido");
                }
            } while (flag);
        }        
  }

    private void capturePokemon() {
        int k = 0;
        boolean flag = true;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora! Retornando a Movimentação");
        }
        
        else {
        	System.out.println("De o número para escolher o pokemon: ");
        	
            while(flag){
                try{
                    k = Integer.parseInt(leitor.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("De no formato correto!");
                    k = Integer.parseInt(leitor.nextLine());
                }
                if(k < 0 || k > max){
                    System.out.println("De no intervalo correto!");
                    k = Integer.parseInt(leitor.nextLine());
                }
                flag = false;
            }
            Pokemon pokemon = p.getPokemonParaCombate(k);
            Captura captura = new Captura(p, pokemon);
            captura.start();
        } 
        
    }

}
