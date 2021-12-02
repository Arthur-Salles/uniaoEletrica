package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import skills.Skills;
import java.util.LinkedList;
import tipos.Tipo;

public class GenerateWithTxt {

    private Scanner input;
    public LinkedList<Pokemon> pokeList = new LinkedList<Pokemon>();
    // private String pathConfig = "";

    private static Scanner createScanner(String filename) throws FileNotFoundException {
        String x = filename + ".txt";
        File fileobj = new File(x);
        Scanner sc;
        if (!fileobj.exists()) {
            throw new FileNotFoundException();
        } else {
            sc = new Scanner(fileobj);
        }
        return sc;
    }

    public GenerateWithTxt(String filename) {
        try {
            this.input = createScanner(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Nao existe arquivo " + filename);
            System.exit(1);
        }
    }

    public void readPokemonFromTxt() {
        // retornar a lista inteira

        while (input.hasNext()) {

            String test[] = input.nextLine().split("/");
            int hp = Integer.parseInt(test[1]);
            int atk = Integer.parseInt(test[2]);
            int def = Integer.parseInt(test[3]);

            // Tipo t1[] = Tipo.valueOf(test[4].split("$"))
            String aux[] = test[4].split("-");
            Tipo[] type = new Tipo[2];
            Skills[] skills = new Skills[4];

            type[0] = Tipo.valueOf(aux[0].toUpperCase());
            type[1] = (aux.length > 1) ? Tipo.valueOf(aux[1].toUpperCase()) : Tipo.NULO;

            aux = test[5].split("#");

            // Pokemon p = new Pokemon(test[0], hp, atk, def, type, aux);
            // pokeList.add(p);
        }
    }

}