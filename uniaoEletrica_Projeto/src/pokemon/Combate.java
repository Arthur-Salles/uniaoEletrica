package pokemon;

import player.Player;
import skills.Skills;
import ui.Interacao;

public class Combate {
    
    private Player jogador;
    private Pokemon nonPlayer;
    private Pokemon activePokemon;
    private Interacao combatUi;

    public Combate(Player jogador, Pokemon pokemonAdv){
        this.jogador = jogador;
        this.nonPlayer = pokemonAdv;
        this.combatUi = new Interacao(jogador);
        this.setupActivePokemon();
        this.engageFight();
    }
    
    private void setupActivePokemon(){
        if(jogador.getActivePokemon() == null){
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
                try {
                    int itemSelector = combatUi.chooseItem();
                    jogador.consumeItem(itemSelector);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nada acontece");
                }
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
            jogador.removerPokemonIlha(nonPlayer);
            combatUi.pokemonCaptured(nonPlayer);
        }
    }

}
