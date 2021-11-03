public class Main {
    public static void main(String[] args) throws Exception {
        // so para testar

        // TODO : melhorar o sistema de path
        String path = "D:\\EAD\\2021.2\\MC322\\uniaoEletrica\\poketest";

        GenerateWithTxt k = new GenerateWithTxt(path);
        k.readPokemonFromTxt();

        for(Pokemon p : k.pokeList){
            p.showSkills();
        }
    }
}   
