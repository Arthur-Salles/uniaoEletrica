package turno;

import dados.Dado;
import player.Player;
import pokemon.Pokemon;

public class Captura {
    private Player player;
    private Pokemon pokemon;
    private Dado dado = new Dado(6, 2);

    public Captura(Player player, Pokemon pokemon) {
        this.player = player;
        this.pokemon = pokemon;
    }

    public void start() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Lancando dados...");
            int lance = dado.jogarDados();
            System.out.println(lance);
            if (pokemon.tryCapture(lance)) {
                System.out.println("Captura Bem Sucedida!");
                pokemonCaptured(pokemon);
                player.addPokemon(pokemon);
                player.removerPokemonIlha(pokemon);
                return;
            } else {
                System.out.println("Captura Falhou!");
            }
        }

        System.out.println(pokemon.getNome() + " entrando em modo hostil");
        Combate combate = new Combate(player, pokemon, false);
        combate.start();
    }

    private void pokemonCaptured(Pokemon k) {
        System.out.println(k.getNome() + " foi capturado!");
    }

}
