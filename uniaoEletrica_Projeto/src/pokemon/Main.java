package pokemon;

import mapa.*;
import player.Player;
import skills.*;
import ui.Interacao;

public class Main {
    public static void main(String[] args) throws Exception {
        // so para testar
        Player l = new Player(new Coordenadas(2, 9));

        Interacao ui = new Interacao(l);
        ui.movePlayer();
    }
}   