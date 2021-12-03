package transporte;

import java.util.Scanner;

import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Portal extends Transporte {

    private Scanner keyboard;

    public Portal(TriplaCoordenada posicao) {
        super(posicao, "o ");
    }

    @Override
    public void transportar(Player player, Mapa mapa) {
        keyboard = new Scanner(System.in);
        boolean flag = true;

        System.out.print("Voce pode visitar as seguintes ilhas: ");
        player.imprimirIlhasVisitadas();
        System.out.println(" ");
        System.out.println("Digite o numero da Ilha: ");

        do {
            try {
                String command = keyboard.nextLine();
                player.mudarDeNivel(0);
                player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));
                flag = false;
            } catch (NumberFormatException| IndexOutOfBoundsException e) {
                System.out.println("Digite um numero valido:");
            }
        } while (flag);

    }

}
