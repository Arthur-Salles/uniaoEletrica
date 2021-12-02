package pokemon;

import player.Player;
import skills.Skills;
import ui.Interacao;

public class Combate {
    
    private Player jogador;
    private Pokemon nonPlayer;
    private Pokemon activePokemon;
    private Interacao combatUi;

    // constructor with player priority
    public Combate(Player jogador, Pokemon pokemonAdv, boolean priority){
        this.jogador = jogador;
        this.nonPlayer = pokemonAdv;
        this.combatUi = new Interacao(jogador);
        this.setupActivePokemon();
        if(priority){ // deve ter um jeito melhor de fazer isso kkk
            this.engageFightPlayerPriority();
        }
        else{
            this.engageFightNPCPriority();
        }
    }
    
    private void setupActivePokemon(){
        if(jogador.getActivePokemon() == null){
            jogador.setActivePokemon(0);      
        }
        this.activePokemon = jogador.getActivePokemon(); 
    }

    private void engageFightPlayerPriority(){

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
            combatUi.emitAttackWarning(nonPlayer);
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

    private void engageFightNPCPriority(){

        System.out.printf("%s VERSUS %s\n", activePokemon.getNome(), nonPlayer.getNome());

        while(!activePokemon.isDead() && !nonPlayer.isDead()){
            // turno do NPC
            combatUi.emitAttackWarning(nonPlayer);
            nonPlayer.attack(activePokemon);
            combatUi.printPokemonsStatus(this.activePokemon, nonPlayer);

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
