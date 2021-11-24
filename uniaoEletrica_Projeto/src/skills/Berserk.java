package skills;

import pokemon.Pokemon;

public class Berserk implements Skills{

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
