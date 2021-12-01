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
        Tipo[] kek1 = {Tipo.WATER, Tipo.WATER};

        Pokemon pikachu = new Pokemon("pikachu", kek , new Coordenadas(2, 15), 20, 15, 7);
        Pokemon leonardo = new Pokemon("leonardo", kek1, new Coordenadas(3, 145), 30, 20, 5);

        leonardo.addSkillWithTR(t1);
        l.addItem(new Fruta());

        // l.addPokemon(pikachu);
        l.addPokemon(leonardo);
        // l.addPokemon(pikachu);
        // l.setActivePokemon(0);

        Combate rinhaDeAnimal = new Combate(l, pikachu);

    }
}   