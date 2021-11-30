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
    public boolean isTypeCompatible(Tipo k){
        for (Tipo tipo : legalTypes) {
            if(k.equals(tipo) || tipo.equals(Tipo.NULO)){
                return true;
            }
        }
        return false;
    }
    
}
