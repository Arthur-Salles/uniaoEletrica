package pokemon;

public class HugePower extends Habilidade{
        
    public HugePower(String n){
        super(n);
    }

    @Override
    public void activeEffect(Pokemon p){
        // implementar turno
        p.takeDamage(5);
        p.changeDef(2);
        p.changeAtk(2);
    }

}
