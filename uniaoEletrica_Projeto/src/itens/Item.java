package itens;

import pokemon.Pokemon;
import mapa.ElementoIlha;
import mapa.TriplaCoordenada;

public abstract class Item extends ElementoIlha{

    public Item(TriplaCoordenada posicao, String icone) {
        super(posicao, icone);
    }
    public String render(){
        return super.getIcone();
    }
    public void use(Pokemon p){
        return;
    };
    @Override
    public boolean ehItem(){
        return true;
    }


}
