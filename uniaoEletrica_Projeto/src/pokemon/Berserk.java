package pokemon;

public class Berserk extends Habilidade {
    
    public Berserk(String n){
        super(n);
    }

    @Override
    public void passiveEffect(Pokemon p){
        if(p.checkHalfHp()){
            p.changeAtk(2);
        }
        else{
            p.resetAtk();
        }
    }

}
