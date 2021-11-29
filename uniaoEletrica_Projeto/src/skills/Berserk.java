package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Berserk implements Skills{

    private Tipo legalTypes[] = {Tipo.ELECTRIC, Tipo.DRAGON};

    public Berserk(){

        return;
    }

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
        if(p.ishalfHp()){
            p.boostAtk(2);
        }
        else{
            p.resetAttributes();
        }
        
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) {
        return;
    }

    

    
}
