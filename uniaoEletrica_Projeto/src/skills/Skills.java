package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public interface Skills { // talvez trocar por herança normal por conta dos ultimos metodos
    public void passiveEffect(Pokemon p, Pokemon taker);
    public void activeEffect(Pokemon p, Pokemon taker);
    public Tipo[] getTipo();
    public String getNome();

}
