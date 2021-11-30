package pokemon;

import mapa.*;
import player.Player;
import skills.*;
import ui.Interacao;
import itens.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // so para testar
        Player l = new Player(new Coordenadas(2, 9));

        Interacao ui = new Interacao(l);
        TR t1 = new TR();

        Tipo[] kek = {Tipo.WATER};

        Pokemon pikachu = new Pokemon("pikachu", kek, new Coordenadas(2, 15), 20, 10, 6);
        l.addPokemon(pikachu);
        l.addItem(t1);
        ui.choosePokemon();
        pikachu.showAllSkills();
        ui.useItem();
        pikachu.showAllSkills();
        l.printItens();

    }
}   