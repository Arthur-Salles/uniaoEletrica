
public class Pokemon{
    String nome;
    private int hp, atk, def;
    private Tipo[] type = new Tipo[2];
    private Habilidade[] skills = new Habilidade[4];


    public Pokemon(String n, int h, int a, int d, Tipo[] g, Habilidade ... s){
        nome = n;
        hp = h;
        atk = a;
        def = d;
        type[0] = g[0];
        type[1] = g.length == 2 ? g[1] : Tipo.NULO;
        for(int i = 0; i < s.length; i++){
            skills[i] = s[i];
        }
    }

    public Pokemon(String n, int h, int a, int d){
        nome = n;
        hp = h;
        atk = a;
        def = d;
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

    @Override
    public String toString(){
        return (String.format("%s\nHP:%d\nATK:%d\nDEF:%d\n", nome,hp,def,atk));
    }
}