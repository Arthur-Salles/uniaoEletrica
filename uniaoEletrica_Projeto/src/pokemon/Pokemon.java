package pokemon;
import java.util.ArrayList;

public class Pokemon{
    private String nome;
    private int hp, atk, def;
    private Tipo[] type = new Tipo[2];
    private int oldAtk, maxHp, oldDef;
    // private Habilidade[] skills = new Habilidade[4];
    private ArrayList<Habilidade> skills = new ArrayList<Habilidade>();
    // posicao dele tbm se for wild e a ilha

    public Pokemon(String n, int h, int a, int d, Tipo[] g, String ... s){
        nome = n;
        hp = h;
        maxHp = h;
        atk = a;
        def = d;
        oldDef = def;
        oldAtk = atk;
        type[0] = g[0];
        type[1] = g[1];
        for(int i = 0; i < s.length; i++){
            skills.add(new Habilidade(s[i]));
        }
    }

    public Pokemon(String n, int h, int a, int d){
        nome = n;
        hp = h;
        maxHp = h;
        atk = a;
        def = d;
    }

    public void heal(int a){
        hp += a;
    }

    public void takeDamage(int a){
        hp -= a;
    }
    public void takePokemonDamage(int a){
        int d = ((a - def > 0) ? a - def : 1);
        hp -= d;
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
    public boolean checkTipo(Tipo a){
        if(type[0].equals(a) || type[1].equals(a)){
            return true;
        }
        return false;
    }

    public boolean checkHalfHp(){
        return (hp > (maxHp/2));
    }

    public void changeAtk(int a){
        if(atk != oldAtk){ // ja foi mudado uma vez
            return;
        }   
        oldAtk = atk;
        atk = atk * a;
    }

    public void resetAtk(){
        atk = oldAtk;
    }

    public void changeDef(int a){
        if(def != oldDef){
            return;
        }
        oldDef = def;
        def = def * a;
    }

    public int getDef(){
        if(def > oldDef){
            return def;
        }
        else{
            return oldDef;
        }
    }

    public int getAtk(){
        if(atk > oldAtk){
            return atk;
        }
        else{
            return oldAtk;
        }
    }

    public boolean isAlive(){
        return hp > 0;
    }

}