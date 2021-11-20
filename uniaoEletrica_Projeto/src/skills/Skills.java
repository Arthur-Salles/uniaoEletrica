package skills;

import pokemon.Pokemon;

public interface Skills {
    void passiveEffect(Pokemon p);
    void activeEffect(Pokemon p);
}
