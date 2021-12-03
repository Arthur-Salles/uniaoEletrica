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

    public boolean start() {
        boolean succed = true;
        imprimirInstrucoes();

        switch (leitor.nextInt()) {
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

    private void consumeItem(){
        String k = "";
        boolean flag = true;
        System.out.println("Itens disponiveis: ");
        if(p.printItens() == 0){
            System.out.println("Nada a fazer");
            return;
        }
        System.out.println("De o número para escolher o item: ");

        k = leitor.nextLine();

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
        int k = 0;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora!\nRetornando a Movimentação");
            return true;
        }

        System.out.println("De o número para escolher o pokemon: ");
        k = leitor.nextInt();
        while (k < 0 || k > max) {
            System.out.println("De um número no intervalo correto!");
            k = leitor.nextInt();
        }

        Pokemon pokemon = p.getPokemonParaCombate(k);
        Combate combate = new Combate(p, pokemon, true);
        return combate.start();

    }

    private boolean capturePokemon() {
        int k = 0;

        System.out.println("Pokemons Disponiveis:");
        int max = p.imprimirPokemonsDisponiveisParaAtaque();
        if(max == 0){
            System.out.println("Nada pra fazer agora! Retornando a Movimentação");
            return true;
        }
        System.out.println("De o número para escolher o pokemon: ");
        k = leitor.nextInt();
        while (k < 0 || k > max) {
            System.out.println("De um número no intervalo correto!");
            k = leitor.nextInt();
        }
        Pokemon pokemon = p.getPokemonParaCombate(k);
        Captura captura = new Captura(p, pokemon);
        return captura.start();
    }

    public int chooseItem() {
        String k = "sbhdfshf";
        boolean flag = true;
        do{
            try {
                System.out.println("Os itens disponiveis sao: ");
                int max = p.printItens();
                if(max == 0){
                    throw new IndexOutOfBoundsException();
                }
                k = leitor.nextLine();
                flag = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e) {}
        } while (flag);
        return Integer.parseInt(k);
    }

}
