package itens;

import pokemon.Pokemon;

public class Fruta implements Item {

    private final String iconExists = "F";

    @Override
    public String render() {
        return iconExists;
    }

    @Override
    public void use(Pokemon p){
        p.addLife(2000000);
        System.out.println(p.getNome() + " foi curado!");
    }
    
}
