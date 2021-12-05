package skills;

import pokemon.Pokemon;
import tipos.Tipo;

public class Skills {

    protected String m;

    public void passiveEffect(Pokemon p, Pokemon taker) {
        return;
    };

    public void activeEffect(Pokemon p, Pokemon taker) {
        return;
    };

    public Tipo[] getTipo() {
        return null;
    };

    public String getNome() {
        return this.m;
    };

    public boolean isTypeCompatible(Tipo k) {
		return false;
    }

}
