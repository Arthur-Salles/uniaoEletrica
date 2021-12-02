package transporte;

import java.util.Scanner;

import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Portal extends Transporte {

    private Scanner keyboard;

    public Portal(TriplaCoordenada posicao) {
        super(posicao, "o ");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void transportar(Player player, Mapa mapa) {
        keyboard = new Scanner(System.in);

        System.out.print("Voce pode visitar as seguintes ilhas: ");
        player.imprimirIlhasVisitadas();
        System.out.println(" ");
        System.out.println("Digite o numero da Ilha: ");
        String command = keyboard.nextLine();

        player.mudarDeNivel(0);
        player.viajarParaIlha(mapa.getIlha(Integer.valueOf(command)));

    }

}
