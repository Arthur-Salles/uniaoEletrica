package mapa;

import java.util.ArrayList;

public class Mapa {
    private ElementoGeografico[][] mapa;
    private ArrayList<Ilha> ilhasDisponiveis = new ArrayList<Ilha>();
    private String iconePosicoesVazias = "--";

    public Mapa(int i, int j) {
        mapa = new ElementoGeografico[i][j];

        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                mapa[a][b] = new ElementoGeografico(new Coordenadas(a, b), iconePosicoesVazias);
            }
        }
    }

    public boolean adicionarIlha(Ilha ilha, Coordenadas coord) {
        boolean foiAdicionado = false;

        if (ilha.estaDentroDoMapa(mapa.length, mapa[0].length)) {
            this.mapa[coord.getX()][coord.getY()] = ilha;
            foiAdicionado = true;
            ilhasDisponiveis.add(ilha);
        }

        return foiAdicionado;
    }

    public void imprimirMapa() {
        for (int i = 0; i < mapa.length; i++) {
            centralizarMapa(i);
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j].imprimirIcone();
            }
            System.out.println(" ");
        }
    }

    public void centralizarMapa(int i) {
        System.out.print(
                "\u001b[H\u001b[" + ((17 - mapa.length) / 2 + 1 + i) + "B\u001b[" + ((34 - mapa.length) / 4 + 1) + "C");
    }

    public void imprimirIlhasDisponiveis(int n) {
        ilhasDisponiveis.forEach((k) -> k.imprimirSeTemNivel(n));
    }

    public Ilha getIlha(int i) {
        return ilhasDisponiveis.get(i - 1);
    }

}
