import java.io.ObjectInputStream.GetField;

public class Habilidade {
    
    private String nome;
    private Tipo[] types = new Tipo[4];
    
    public Habilidade(String n){
        nome = n;
    }
    public String toString(){
        return this.nome;
    }
}
