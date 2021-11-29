package skills;

import java.util.Random;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Healer implements Skills {

    private Tipo legalTypes[] = {Tipo.WATER, Tipo.GRASS, Tipo.PSYCHIC};

    public Healer(){
        return;
    }

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
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
    public Tipo[] getTipo() {
        return legalTypes;
    }

    @Override
    public String getNome() {
        return this.getClass().getName();
    }

}
