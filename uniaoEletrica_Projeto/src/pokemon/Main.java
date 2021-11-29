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

        // Interacao ui = new Interacao(l);
        // ui.movePlayer();
        TR t1 = new TR();

        Tipo[] kek = {Tipo.ELECTRIC};

        Pokemon pikachu = new Pokemon("pikachu", kek, new Coordenadas(2, 15), 20, 10, 6);
        l.addPokemon(pikachu);
        l.printPokemons();
        pikachu.addSkillWithTR(t1);
        pikachu.showAllSkills();

    }
}   