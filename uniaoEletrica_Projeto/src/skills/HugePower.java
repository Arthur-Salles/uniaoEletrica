package skills;

import pokemon.Pokemon;
import tipos.Tipo;

public class HugePower extends Skills {

    private boolean hasBeenActive = false;
    private Tipo legalTypes[] = { Tipo.NULO }; // using nulo to all

    public HugePower() {
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) {

        if (hasBeenActive) { // protection for twice activating
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
    public boolean isTypeCompatible(Tipo k) {
        for (Tipo tipo : legalTypes) {
            if (k.equals(tipo) || tipo.equals(Tipo.NULO)) {
                return true;
            }
        }
        return false;
    }

}
