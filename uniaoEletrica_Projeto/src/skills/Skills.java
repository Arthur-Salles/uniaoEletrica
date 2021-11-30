package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Skills { 

    protected String m;
    private Tipo legalTypes[] = {Tipo.NULO};

    public void passiveEffect(Pokemon p, Pokemon taker){
        return;
    };
    public void activeEffect(Pokemon p, Pokemon taker){
        return;
    };
    public Tipo[] getTipo(){
        return null;
    };
    public String getNome(){
        return this.m;
    };

    public boolean isTypeCompatible(Tipo k){
        for (Tipo tipo : legalTypes) {
            if(k.equals(tipo) || tipo.equals(Tipo.NULO)){
                return true;
            }
        }
        return false;
    }

}
