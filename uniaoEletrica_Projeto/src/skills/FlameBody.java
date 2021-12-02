package skills;

import java.util.Random;

import pokemon.Pokemon;
import tipos.Tipo;

public class FlameBody extends Skills {

    private Tipo legalTypes[] = {Tipo.FIRE, Tipo.DRAGON};

    public FlameBody(){
        m = this.getClass().getName().replace("skills.", "");
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
