package itens;

import pokemon.Pokemon;

public interface Item {

    public String render();
    public void use(Pokemon p);

}
