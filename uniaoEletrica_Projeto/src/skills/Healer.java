package skills;

import dados.Dado;
import pokemon.Pokemon;
import tipos.Tipo;

public class Healer extends Skills {

    private Tipo legalTypes[] = { Tipo.WATER, Tipo.GRASS, Tipo.PSYCHIC };

    public Healer() {
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) { // only affects p
        Dado rnd = new Dado(10);
        int chance = rnd.jogarDados();
        if (chance <= 6) {
            p.heal(10);
        } else if (chance > 6 && chance <= 8) {
            p.heal(20);
        }
    }

    @Override
    public boolean isTypeCompatible(Tipo k) {
        for (Tipo tipo : legalTypes) {
            if (k.equals(tipo) || tipo.equals(Tipo.NULO)) {
                return true;
            }
        }
        return false;
    }

}
