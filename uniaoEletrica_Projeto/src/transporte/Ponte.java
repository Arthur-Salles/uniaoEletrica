package transporte;

import java.util.Scanner;

import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Ponte extends Transporte {

    private Scanner keyboard;

    public Ponte(TriplaCoordenada posicao) {
        super(posicao, "~ ");
    }

    @Override
    public void transportar(Player player, Mapa mapa) {
        keyboard = new Scanner(System.in);
        int nivelAtual = player.getNivel();
        boolean flag = true;

        System.out.print("Voce pode ir para as seguintes ilhas: ");
        mapa.imprimirIlhasDisponiveis(nivelAtual, player.getIlhaAtual());
        System.out.println(" ");
        System.out.print("Digite o numero da ilha: ");

        do {
            int n = keyboard.nextInt();
            if(mapa.ilhaEhValida(n, player.getNivel(), player.getIlhaAtual())) {
                player.viajarParaIlha(mapa.getIlha(n));
                flag = false;
            }else {
                System.out.println("Digite um numero valido: ");
            }
        } while (flag);
    }
}
