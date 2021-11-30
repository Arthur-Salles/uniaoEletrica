package skills;

import pokemon.Pokemon;
import pokemon.Tipo;

public class Berserk extends Skills{

    // criar metodo na skill que compara um tipo com os tipos de dentro
    private Tipo legalTypes[] = {Tipo.ELECTRIC, Tipo.DRAGON};

    public Berserk(){
        m = this.getClass().getName().replace("skills.", "");
        return;
    }

    @Override
    public void passiveEffect(Pokemon p, Pokemon taker) {
        if(p.ishalfHp()){
            p.boostAtk(2);
        }
        else{
            p.resetAttributes();
        }
        
    }

    @Override
    public void activeEffect(Pokemon p, Pokemon taker) {
        return;
    }

    @Override
    public Tipo[] getTipo() {
        return legalTypes;
    }

    // @Override
    // public boolean isTypeCompatible(Tipo k){
    //     for (Tipo tipo : legalTypes) {
    //         if(k.equals(tipo)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
