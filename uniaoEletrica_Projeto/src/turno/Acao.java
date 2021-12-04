package turno;

import java.util.Scanner;
import player.Player;
import pokemon.Pokemon;

public class Acao {
    private Scanner leitor = new Scanner(System.in);
    private Player p;

    public Acao(Player k) {
        this.p = k;
    }

    public boolean start(int totalPokemons) {
        boolean succed = true;
        boolean flag = true;
        mostrarStatus(totalPokemons);
        imprimirInstrucoes();

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
                        succed = attackPokemon();
                        break;
                    case 4:
                        succed = capturePokemon();
                        break;
                    default:
                        break;
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("De o comando dnv!");
            }
    } while(flag);

        p.regenerarPokemons();
        return succed;
    }

    private void mostrarStatus(int o) {
        System.out.println(" --- Status do jogo ---\nSeus Pokemons: ");
        p.printPokemons();
        System.out.println("Seu inventário: ");
        p.printItens();
        System.out.println("Pokemons Atacaveis e Capturaveis: ");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        System.out.printf("Existem %d pokemons restantes dentre todas ilhas\n",o);

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

    public boolean attackPokemon() {
        String k = "sdffsf";
        boolean flag = true;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora!\nRetornando a Movimentação");
            return true;
        }

        Pokemon pokemon;

        System.out.println("De o número para escolher o pokemon: ");
        do {
            try {
                k = leitor.nextLine();
                pokemon = p.getPokemonParaCombate(Integer.parseInt(k));
                Combate combate = new Combate(p, pokemon, true);
                flag = false;
                return combate.start();
            } catch (NumberFormatException| IndexOutOfBoundsException e) {
                System.out.println("De um numero valido");
            }
        } while (flag);
        return false;
    }

    private boolean capturePokemon() {
        int k = 0;
        boolean flag = true;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora! Retornando a Movimentação");
            return true;
        }
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
        return captura.start();
    }

}
