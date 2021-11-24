package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Intimidate implements Skills{

    private boolean hasBeenActive = false;

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


    
}
