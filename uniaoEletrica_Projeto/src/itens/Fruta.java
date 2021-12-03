package itens;

import mapa.TriplaCoordenada;
import pokemon.Pokemon;

public class Fruta extends Item {

    private final String iconExists = "F ";


    public Fruta(TriplaCoordenada posicao, String icone) {
        super(posicao, icone);
    }

    @Override
    public String toString(){
        return "Fruta";
    }

    @Override
    public String render(){
        return this.iconExists;
    }

    @Override
    public void use(Pokemon p){
        p.addLife(2000000);
        System.out.println(p.getNome() + " foi curado!");
    }
    
}
