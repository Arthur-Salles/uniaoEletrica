package pokemon;
import java.util.Random;

public class FlameBody extends Habilidade {
    
    public FlameBody(String n){
        super(n);
    }

    @Override
    public void passiveEffect(Pokemon a){
        Random odd = new Random();
        if(odd.nextInt(10) <= 3){
            if (a.checkTipo(Tipo.WATER) || a.checkTipo(Tipo.FIRE)){
                return;
            }
            a.takeDamage(5);
        }
        else{
            return;
        }
    }

}
