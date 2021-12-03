package itens;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import skills.*;

public class TR extends Item {

    private String skillsPossiveis[] = {"Berserk","FlameBody","Healer","HugePower","Intimidate"};
    private final String iconExists = "TR";
    private Skills habilidadeInTR;
    private String nomeDaHabilidade;

    public TR(TriplaCoordenada posicao, String icone) {
        super(posicao, icone);
        generateSkill();
    }

    @Override
    public String render() {
        return iconExists;
    }

    @Override
    public String toString() {
        return "TR: " + this.nomeDaHabilidade;
    }

    @Override
    public void use(Pokemon p) {
        p.addSkillWithTR(this); 
    }

    private void generateSkill() {

        Random rnd = new Random();
        int k = rnd.nextInt(skillsPossiveis.length);
        this.nomeDaHabilidade = skillsPossiveis[k];

        Class<?> c;
        Constructor<?> ck;

        try {
            c = Class.forName("skills."+nomeDaHabilidade);
            ck = c.getConstructor();
            habilidadeInTR = (Skills) ck.newInstance();
        } 
        catch (ClassNotFoundException | NoSuchMethodException e) {
            System.err.println("Nao foi possível criar");
        } catch (SecurityException | InstantiationException | IllegalAccessException | 
        IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Skills getSkill() {
        return habilidadeInTR;
    }

}
