package itens;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import mapa.TriplaCoordenada;
import pokemon.Pokemon;
import skills.*;


public class TR extends Item{

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
    public String toString(){
        return "TR: " + this.nomeDaHabilidade;
    }

    @Override
    public void use(Pokemon p) {
        p.addSkillWithTR(this); 
    }

    private void generateSkill(){

        Random rnd = new Random();
        File dir = new File("src/skills"); // sempre mudar ao mudar a pasta do vs
        File[] allSkills = dir.listFiles();

        int classNumber = rnd.nextInt(allSkills.length);
        while(allSkills[classNumber].getName().equals("Skills.java")){ // finds a random skill class in "src/skills"
            classNumber = rnd.nextInt(allSkills.length);
        }
        this.nomeDaHabilidade = (allSkills[classNumber].getName()).replace(".java", "");
        String nome = "skills." + (allSkills[classNumber].getName()).replace(".java", ""); // prepares the random class name
        Class<?> c; // creates the Skills class
        Constructor<?> k;

        try {
            c = Class.forName(nome);
            k = c.getConstructor();
            habilidadeInTR = (Skills) k.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Skills getSkill() {
        return habilidadeInTR;
    }

    
}
