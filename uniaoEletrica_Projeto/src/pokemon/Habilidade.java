package pokemon;

public class Habilidade {
    
    private String nome;
    private Tipo[] types = new Tipo[4];
    
    public Habilidade(String n){
        nome = n;
    }
    public String toString(){
        return this.nome;
    }
    
    public void passiveEffect(Pokemon p){
        return;
    }
    public void activeEffect(Pokemon p){
        return;
    }
}
