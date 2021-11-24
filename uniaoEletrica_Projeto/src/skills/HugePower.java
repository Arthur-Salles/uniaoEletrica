package skills;

import pokemon.Pokemon;

public class HugePower implements Skills {

    boolean hasBeenActive = false;

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
        return;
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) {
        
        if(hasBeenActive){ // protection for twice activating
            hasBeenActive = false;
            p.resetAttributes();
            return;
        }
        p.boostAtk(2);
        p.boostDef(2);
        p.takeHP(5);
        hasBeenActive = true;
    }
    
}
