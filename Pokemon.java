
public class Pokemon{
    private int hp, atk, def;
    private Tipo[] type = new Tipo[2];

    public Pokemon(int h, int a, int d, Tipo ... g){
        hp = h;
        atk = a;
        def = d;
        type[0] = g[0];
        type[1] = g.length == 2 ? g[1] : Tipo.NULO;
    }

    public void heal(int a){
        hp += a;
    }

    public void takeDamage(int a){
        hp -= a;
    }
    public void regen(){
        hp += 1;
    }

}