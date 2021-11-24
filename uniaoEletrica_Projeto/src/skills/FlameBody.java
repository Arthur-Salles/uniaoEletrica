package skills;

import java.util.Random;

import pokemon.Pokemon;
import pokemon.Tipo;

public class FlameBody implements Skills {

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
        return;
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) { // caller is the first pokemon
        if(taker.isType(Tipo.FIRE) || taker.isType(Tipo.WATER)){
            return;
        }
        Random rnd = new Random();
        int chance = rnd.nextInt(10);
        if(chance <= 2){
            taker.takeHP(5);
        }
    }
    
}
