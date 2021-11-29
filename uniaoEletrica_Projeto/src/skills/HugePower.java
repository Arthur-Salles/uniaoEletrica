package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class HugePower implements Skills {

    private boolean hasBeenActive = false;
    private Tipo legalTypes[] = {Tipo.NULO};
    private String m;

    public HugePower(){
        this.m = this.getClass().getName().replace("skills.", "");
        return;
    }

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

    @Override
    public Tipo[] getTipo() {
        return legalTypes;
    }

    @Override
    public String getNome() {
        return this.m;
    }

}
