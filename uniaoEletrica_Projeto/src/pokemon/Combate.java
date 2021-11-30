package pokemon;

import player.Player;
import ui.Interacao;

public class Combate {
    
    private Player jogador;
    private Pokemon nonPlayer;
    private Pokemon activePokemon;
    private Interacao combatUi;

    public Combate(Player jogador, Pokemon nonPlayer){
        this.jogador = jogador;
        this.nonPlayer = nonPlayer;
        this.activePokemon = jogador.getActivePokemon();
        this.combatUi = new Interacao(jogador);
    }

    public void engageFight(){

        while(!activePokemon.isDead() || !nonPlayer.isDead()){
            // player 
            int k = combatUi.chooseAction();
            switch(k){
                case 1:;
                    break;
                case 2:
                    break;
                case 3:
                    combatUi.useItem();
                    break;
            }
            // turno do NPC
        }
        if(activePokemon.isDead()){
            combatUi.pokemonIsDead(activePokemon);
            return;
        }
        if(nonPlayer.isDead()){
            jogador.addPokemon(nonPlayer);
            combatUi.pokemonCaptured(nonPlayer);
            return;
        }
    }

}
