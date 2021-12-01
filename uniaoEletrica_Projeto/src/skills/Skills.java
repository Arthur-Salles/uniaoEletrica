package skills;

import pokemon.Pokemon;

public interface Skills {
    void passiveEffect(Pokemon p, Pokemon taker);
    void activeEffect(Pokemon p, Pokemon taker);
}
