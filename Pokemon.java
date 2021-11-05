import java.util.ArrayList;

public class Pokemon{
    private String nome;
    private int hp, atk, def;
    private Tipo[] type = new Tipo[2];
    // private Habilidade[] skills = new Habilidade[4];
    private ArrayList<Habilidade> skills = new ArrayList<Habilidade>();

    public Pokemon(String n, int h, int a, int d, Tipo[] g, String ... s){
        nome = n;
        hp = h;
        atk = a;
        def = d;
        type[0] = g[0];
        type[1] = g[1];
        for(int i = 0; i < s.length; i++){
            skills.add(new Habilidade(s[i]));
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

    public void showSkills(){
        for(int i = 0; i < this.skills.size(); i++){
            System.out.print(skills.get(i).toString());
        }
        System.out.print("\n");
    }

    @Override
    public String toString(){
        String x = String.format("%s\nHP:%d\nATK:%d\nDEF:%d\n", nome,hp,def,atk);
        x = x + String.format("Tipos:%s %s\n", type[0].name(),(type[1] != Tipo.NULO) ? type[1].name() : "");
        // x = x + String.format("Habilidades: %s\n", this.showSkills());
        return x;
    }
}