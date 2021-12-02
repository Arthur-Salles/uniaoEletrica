package dados;

import java.util.Random;

public class Dado {

    private int faces;
    private int quantidade;
    private Random jogar = new Random();

    public Dado() {
        this.faces = 6;
        quantidade = 1;
    }

    public Dado(int faces) {
        this.faces = faces;
        quantidade = 1;
    }

    public Dado(int faces, int quantidade) {
        this.faces = faces;
        this.quantidade = quantidade;
    }

    public int jogarDados() {
        int resultado = 0;
        for (int i = 0; i < quantidade; i++) {
            resultado += jogar.nextInt(faces) + 1;
        }
        return resultado;
    }
}
