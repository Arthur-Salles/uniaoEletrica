package itens;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import skills.*;


public class TR implements Item{

    private final String iconExists = "TR";
    private final String iconNonExists = "-";
    private Skills habilidadeInTR;


    public TR(){
        generateSkill();
    }

    @Override
    public String render() {
        return iconExists;
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub   
    }

    private void generateSkill(){

        Random rnd = new Random();
        File dir = new File("src/skills");
        File[] allSkills = dir.listFiles();
        int classNumber = rnd.nextInt(allSkills.length);
        while(allSkills[classNumber].getName().equals("Skills.java")){ // finds a random skill class in "src/skills"
            classNumber = rnd.nextInt(allSkills.length);
        }
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

    
}