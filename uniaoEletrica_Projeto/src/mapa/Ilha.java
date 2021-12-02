package mapa;

import java.util.Random;

import player.Player;
import pokemon.ListaPokemons;
import pokemon.Pokemon;
import tipos.Tipo;
import transporte.Elevador;
import transporte.Ponte;
import transporte.Portal;

public class Ilha extends ElementoGeografico {
    private ElementoIlha[][][] ilha;
    private String iconePosicoesVazias = "- ";
    private Tipo tipo[] = new Tipo[1];
    private Random random = new Random();

    public Ilha(int i, int j, int k, Coordenadas posicaoNoMundo, String icone, Tipo tipo) {
        super(posicaoNoMundo, icone);
        ilha = new ElementoIlha[i][j][k];
        this.tipo[0] = tipo;

        for (int c = 0; c < k; c++) {
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < j; b++) {
                    ilha[a][b][c] = new ElementoIlha(new TriplaCoordenada(a, b, c), iconePosicoesVazias);
                }
            }
            adicionarPontes(i, j, c);
            adicionarPortal(i, j, c);
            adicionarElevador(i, j, c);

            for (int l = 0; l < random.nextInt(3) + 2; l++) {
                adicionarPokemons(i, j, c);
            }

        }

    }

    private void adicionarPokemons(int i, int j, int k) {
        ListaPokemons poke = pokemonAleatorio();
        Pokemon pokemon1 = new Pokemon(poke.getName(), poke.toString(), new TriplaCoordenada(random.nextInt(i),
                random.nextInt(j), k), 50, 10, 10, poke.getTipos());
        adicionarObjeto(pokemon1, pokemon1.getPosicaoAtual());
    }

    private void adicionarElevador(int i, int j, int c) {
        Elevador elevador = new Elevador(new TriplaCoordenada(3, 3, c));
        adicionarObjeto(elevador, elevador.getPosicaoAtual());

    }

    private void adicionarPortal(int i, int j, int c) {
        Portal portal = new Portal(new TriplaCoordenada(i / 2, j / 2, c));
        adicionarObjeto(portal, portal.getPosicaoAtual());

    }

    private void adicionarPontes(int i, int j, int k) {
        Ponte ponte1 = new Ponte(new TriplaCoordenada(i / 2, j - 1, k));
        Ponte ponte2 = new Ponte(new TriplaCoordenada(i / 2, 0, k));
        Ponte ponte3 = new Ponte(new TriplaCoordenada(i - 1, j / 2, k));
        Ponte ponte4 = new Ponte(new TriplaCoordenada(0, j / 2, k));

        adicionarObjeto(ponte1, ponte1.getPosicaoAtual());
        adicionarObjeto(ponte2, ponte2.getPosicaoAtual());
        adicionarObjeto(ponte3, ponte3.getPosicaoAtual());
        adicionarObjeto(ponte4, ponte4.getPosicaoAtual());
    }

    public boolean adicionarObjeto(ElementoIlha obj, TriplaCoordenada coord) {
        boolean foiMovido = false;

        if (verificarSeEstaDentroDoMapa(coord)) {
            this.ilha[coord.getX()][coord.getY()][coord.getZ()] = obj;
            foiMovido = true;
        }

        return foiMovido;
    }

    private void removerElemento(TriplaCoordenada posicaoAntiga) {
        int linha = posicaoAntiga.getX();
        int coluna = posicaoAntiga.getY();
        int nivel = posicaoAntiga.getZ();
        ilha[linha][coluna][nivel] = new ElementoIlha(new TriplaCoordenada(linha, coluna, nivel), iconePosicoesVazias);
    }

    public boolean moverPlayer(Player player, Mapa mapa, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
        int i = posicaoNova.getX();
        int j = posicaoNova.getY();
        int k = posicaoNova.getZ();
        boolean viajou = false;

        if (posicaoNova.verificarSeEstaDentroDoMapa(ilha.length, ilha[0].length)) {
            if (ilha[i][j][k].ehTransporte()) {
                ilha[i][j][k].transportar(player, mapa);
                viajou = true;
                removerElemento(posicaoAntiga);
            } else {
                removerElemento(posicaoAntiga);
                viajou = adicionarObjeto(player, posicaoNova);
            }
        }
        return viajou;
    }

    public boolean moverElemento(Player player, TriplaCoordenada posicaoAntiga, TriplaCoordenada posicaoNova) {
        removerElemento(posicaoAntiga);

        return adicionarObjeto(player, posicaoNova);
    }

    protected boolean verificarSeEstaDentroDoMapa(TriplaCoordenada coord) {
        boolean estaDentro = false;

        if (coord.verificarSeEstaDentroDoMapa(ilha.length, ilha[0].length)) {
            if (coord.getZ() <= ilha[0][0].length && coord.getZ() >= 0) {
                estaDentro = true;
            }
        }

        return estaDentro;
    }

    public void imprimirIlha(int nivel) {
        System.out.println(" ----- " + super.getIcone() + " ----- ");
        for (int i = 0; i < ilha.length; i++) {
            for (int j = 0; j < ilha[0].length; j++) {
                ilha[i][j][nivel].imprimirIcone();
                System.out.print(" ");
            }
            System.out.println(" ");
        }

    }

    public void imprimirNiveisDisponiveis(int nivelAtual) {
        for (int i = 0; i < ilha[0][0].length; i++) {
            if (i != nivelAtual) {
                System.out.print(" " + i);
            }
        }
        System.out.println(" ");
    }

    public void imprimirSeTemNivel(int n) {
        if (ilha[0][0].length >= n) {
            super.imprimirIcone(" ");
        }
    }

    public ListaPokemons pokemonAleatorio() {
        return ListaPokemons.values()[new Random().nextInt(ListaPokemons.values().length)];
    }

}
