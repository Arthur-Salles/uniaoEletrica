package skills;

import java.util.Random;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Healer extends Skills {

    private Tipo legalTypes[] = {Tipo.WATER, Tipo.GRASS, Tipo.PSYCHIC};

    public Healer(){
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) { // only affects p
        Random rnd = new Random();
        int chance = rnd.nextInt(10);
        if(chance <= 6){
            p.heal(10);
        }
        else if(chance > 6 && chance <= 8){
            p.heal(20);
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
