package skills;

import pokemon.Pokemon;
import tipos.Tipo;

public class Berserk extends Skills {

    private Tipo legalTypes[] = { Tipo.ELECTRIC, Tipo.DRAGON };

    public Berserk() {
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
        if (p.ishalfHp()) {
            p.boostAtk(2);
        } else {
            p.resetAttributes();
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
