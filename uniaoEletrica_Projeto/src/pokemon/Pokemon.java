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
    private boolean protectSkillsOn = false;

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

    public boolean ishalfHp() {
        return (hp[0] > (hp[1] * 0.5));
    }

    public void boostAtk(double i) {
        atq[0] = (int)(atq[0] * i);
    }

    public void boostDef(double i) {
        def[0] = (int)(def[0] * i);
    }

    public void resetAttributes() {
        atq[0] = atq[1];
        def[0] = def[1];
    }

    public boolean isType(Tipo k) {
        if(tipos[0] == k || tipos[1] == k){
            return true;
        }
        return false;
    }

    public void takeHP(int i) {
        hp[0] -= i;
    }

    public void heal(int i) {
        int healthPool = (int)(hp[0] * i * 0.01);
        hp[0] = (hp[0] + healthPool > hp[1]) ? hp[1] : hp[0] + healthPool;
    }

    public void setProtectSkillFlag(boolean b) { // needed to attend other guard skills method
        this.protectSkillsOn = b;
    }



}