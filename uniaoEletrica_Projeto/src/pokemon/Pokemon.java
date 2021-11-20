package pokemon;
import mapa.*;
import skills.*;

import java.util.ArrayList;

public class Pokemon extends ElementoGeografico{
    
    private String nome;
    private Tipo tipos[] = new Tipo[2];
    private int hp[] = new int[2]; // hp[0] current hp, hp[1] max hp
    private int atq[] = new int[2]; // same index logic
    private int def[] = new int[2];
    private Skills[] habilidades = new Skills[2];

    public Pokemon(String n, Tipo types[], Coordenadas posicao, int vida, int atk, int defesa){
        super(posicao, n);
        this.nome = n;
        tipos = types;
        hp[0] = vida;
        hp[1] = vida;
        atq[0] = atk;
        atq[1] = atk;
        def[0] = defesa;
        def[1] = defesa;
    };

    public char renderPokemon(){
        return nome.charAt(0);
    }



}