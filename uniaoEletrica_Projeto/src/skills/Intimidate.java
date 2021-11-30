package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Intimidate extends Skills{

    private boolean hasBeenActive = false;
    private Tipo legalTypes[] = {Tipo.FIRE, Tipo.DRAGON,Tipo.PSYCHIC};
    
    public Intimidate(){
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) { // p is the caller pokemon
        
        if(hasBeenActive){
            hasBeenActive = false;
            return;
        }
        if(taker.isType(Tipo.PSYCHIC)){
            p.setProtectSkillFlag(false);
            return;
        }
        else{
            hasBeenActive = true;
            p.setProtectSkillFlag(true);
        }
        
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) {
        return;
    }

    @Override
    public Tipo[] getTipo() {
        return legalTypes;
    }

    @Override
    public String getNome() {
        return this.m;
    }
    
}
