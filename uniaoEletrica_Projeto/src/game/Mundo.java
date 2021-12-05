package game;

import mapa.Coordenadas;
import mapa.Ilha;
import mapa.Mapa;
import tipos.Tipo;
import java.util.Random;

public class Mundo {

    public void criarMapaAleatorio(Mapa mapa) {
        Random random = new Random();
        int j = random.nextInt(10) + 2;

        int verifica[][] = new int[2][j];

        for (int i = 0; i < j; i++) {
            int a = random.nextInt(12) + 1;
            int b = random.nextInt(12) + 1;
            if (verificaSeJaFoiAdicionado(verifica, a, b) == true) {
                criarIlha(random.nextInt(10) + 3, random.nextInt(4) + 1, new Coordenadas(a, b),
                        "I" + (i + 1), Tipo.values()[random.nextInt(Tipo.values().length)], mapa);
                verifica[0][i] = a;
                verifica[1][i] = b;
            }
        }
    }

    public void criarTerra(Mapa mapa) {
        criarIlha(13, 2, new Coordenadas(4, 4), "I1", Tipo.DRAGON, mapa);
        criarIlha(13, 3, new Coordenadas(6, 3), "I2", Tipo.FIRE, mapa);
        criarIlha(13, 5, new Coordenadas(8, 5), "I3", Tipo.ELECTRIC, mapa);
        criarIlha(13, 2, new Coordenadas(4, 8), "I4", Tipo.GRASS, mapa);
        criarIlha(13, 2, new Coordenadas(11, 8), "I5", Tipo.PSYCHIC, mapa);
        criarIlha(13, 3, new Coordenadas(3, 9), "I6", Tipo.WATER, mapa);
        criarIlha(13, 2, new Coordenadas(6, 9), "I7", Tipo.DRAGON, mapa);
        criarIlha(13, 3, new Coordenadas(4, 10), "I8", Tipo.FIRE, mapa);
        criarIlha(13, 5, new Coordenadas(6, 11), "I9", Tipo.ELECTRIC, mapa);
    }

    public void criarHoenn(Mapa mapa) {
        criarIlha(6, 1, new Coordenadas(13, 2), "I1", Tipo.FIRE, mapa);
        criarIlha(6, 1, new Coordenadas(11, 3), "I2", Tipo.DRAGON, mapa);
        criarIlha(6, 1, new Coordenadas(12, 4), "I3", Tipo.ELECTRIC, mapa);
        criarIlha(6, 1, new Coordenadas(10, 5), "I4", Tipo.WATER, mapa);
    }

    public void criarJohto(Mapa mapa) {
        criarIlha(7, 1, new Coordenadas(12, 4), "I1", Tipo.WATER, mapa);
        criarIlha(6, 2, new Coordenadas(12, 6), "I2", Tipo.WATER, mapa);
        criarIlha(13, 1, new Coordenadas(12, 7), "I3", Tipo.ELECTRIC, mapa);
        criarIlha(6, 4, new Coordenadas(12, 9), "I4", Tipo.WATER, mapa);
    }

    public void criarKanto(Mapa mapa) {
        criarIlha(8, 1, new Coordenadas(9, 10), "I1", Tipo.ELECTRIC, mapa);
        criarIlha(8, 2, new Coordenadas(9, 13), "I2", Tipo.ELECTRIC, mapa);
        criarIlha(13, 1,new Coordenadas(11, 11), "I3", Tipo.ELECTRIC, mapa);
        criarIlha(5, 4, new Coordenadas(13, 10), "I4", Tipo.FIRE, mapa);
        criarIlha(7, 2, new Coordenadas(13, 12), "I5", Tipo.WATER, mapa);
    }

    public void criarSinnoh(Mapa mapa) {
        criarIlha(5, 4, new Coordenadas(2, 2), "I1", Tipo.ELECTRIC, mapa);
        criarIlha(5, 4, new Coordenadas(2, 5), "I2", Tipo.GRASS, mapa);
        criarIlha(5, 4, new Coordenadas(2, 8), "I3", Tipo.PSYCHIC, mapa);
        criarIlha(5, 4, new Coordenadas(2, 12), "I4", Tipo.FIRE, mapa);
        criarIlha(5, 4, new Coordenadas(4, 3), "I5", Tipo.WATER, mapa);
        criarIlha(5, 4, new Coordenadas(4, 7), "I6", Tipo.GRASS, mapa);
        criarIlha(5, 4, new Coordenadas(4, 9), "I7", Tipo.PSYCHIC, mapa);
    }

    private static void criarIlha(int i, int k, Coordenadas c, String icone, Tipo tipo, Mapa mapa) {
        Ilha ilha = new Ilha(i, i, k, c, icone, tipo);
        mapa.adicionarIlha(ilha, c);
    }

    private static boolean verificaSeJaFoiAdicionado(int[][] verifica, int a, int b) {
        for (int i = 0; i < verifica[1].length; i++) {
            if (verifica[0][i] == a && verifica[1][i] == b) {
                return false;
            }
        }
        return true;
    }

    public void imprimirMapasDisponiveis() {
        System.out.println("Selecione o mapa para jogar: ");
        System.out.println("(1) - Hoenn. Hoenn fica no oeste do japão. Possui ilhas planas");
        System.out.println("(2) - Johto. Johto fica no sul do japão. É uma região bem aquática");
        System.out.println("(3) - Kanto. Kanto fica no leste do japão. Possui grandes cidades e bastante eletricidade");
        System.out.println("(4) - Sinnoh. Sinnoh fica no norte do japão. É o maior território do japão");
        System.out.println("(5) - Terra. Saia do japão e pegue pokemóns pelo mundo. É o mapa mais desafiador");
        System.out.println("(6) - Aleatório. Gere um mapa aleatório");
    }

}
