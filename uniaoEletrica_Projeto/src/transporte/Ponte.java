package transporte;

import java.util.Scanner;

import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Ponte extends Transporte {

    private Scanner keyboard;

    public Ponte(TriplaCoordenada posicao) {
        super(posicao, "~ ");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void transportar(Player player, Mapa mapa) {
        keyboard = new Scanner(System.in);
        int nivelAtual = player.getNivel();

        System.out.print("Voce pode ir para as seguintes ilhas: ");
        mapa.imprimirIlhasDisponiveis(nivelAtual);
        System.out.println(" ");
        System.out.print("Digite o numero da ilha: ");
        String command = keyboard.nextLine();

        player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));

    }
}
