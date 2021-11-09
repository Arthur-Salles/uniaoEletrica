package pokemon;

public class Main {
    public static void main(String[] args) throws Exception {
        // so para testar

        String path = "D:\\Documentos\\2021.2\\MC322\\uniaoEletrica\\poketest";

        GenerateWithTxt k = new GenerateWithTxt(path);
        k.readPokemonFromTxt();

        for(Pokemon p : k.pokeList){
            p.showSkills();
        }
    }
}   