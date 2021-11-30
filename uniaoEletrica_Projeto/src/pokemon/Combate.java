package pokemon;

import player.Player;
import skills.Skills;
import ui.Interacao;

public class Combate {
    
    private Player jogador;
    private Pokemon nonPlayer;
    private Pokemon activePokemon;
    private Interacao combatUi;

    public Combate(Player jogador, Pokemon nonPlayer){
        this.jogador = jogador;
        this.nonPlayer = nonPlayer;
        this.combatUi = new Interacao(jogador);
        this.setupActivePokemon();
        this.engageFight();
    }

    private void setupActivePokemon(){
        if(this.activePokemon == null){
            jogador.setActivePokemon(0);      
        }
        this.activePokemon = jogador.getActivePokemon(); 
    }

    public void engageFight(){

        System.out.printf("%s VERSUS %s\n", activePokemon.getNome(), nonPlayer.getNome());

        while(!activePokemon.isDead() && !nonPlayer.isDead()){
            // player 
            int k = combatUi.chooseAction();

            if(k == 1){
                activePokemon.attack(nonPlayer);
            }
            else if (k == 2){
                Skills habilidadeDoPokemonPlayer =  combatUi.chooseSkill(activePokemon);
                habilidadeDoPokemonPlayer.activeEffect(activePokemon, nonPlayer);
                habilidadeDoPokemonPlayer.passiveEffect(activePokemon, nonPlayer);
            }
            else if(k == 3){
                int itemSelector = combatUi.chooseItem();
                jogador.consumeItem(itemSelector);
            }

            // turno do NPC
            nonPlayer.attack(activePokemon);
            combatUi.printPokemonsStatus(this.activePokemon, nonPlayer);
        }
        if(activePokemon.isDead()){
            combatUi.printWinner(nonPlayer);
            combatUi.pokemonIsDead(activePokemon);
        }
        else if(nonPlayer.isDead()){
            combatUi.printWinner(activePokemon);
            jogador.addPokemon(nonPlayer);
            combatUi.pokemonCaptured(nonPlayer);
        }
    }

}
