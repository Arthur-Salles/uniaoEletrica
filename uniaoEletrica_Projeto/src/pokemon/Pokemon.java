package pokemon;

import java.util.ArrayList;

import itens.Item;
import itens.TR;
import mapa.*;
import skills.*;
import tipos.Tipo;

public class Pokemon extends ElementoIlha {
    private String nome;
    private Tipo tipos[] = new Tipo[2];
    private int hp[] = new int[2]; // hp[0] current hp, hp[1] max hp
    private int atq[] = new int[2]; // same index logic
    private int def[] = new int[2];
    private ArrayList<Skills> habilidades = new ArrayList<Skills>();
    private boolean protectSkillsOn = false;

    public Pokemon(String nome, String n, TriplaCoordenada posicao, int vida, int atk, int defesa, Tipo[] tipos) {
        super(posicao, n);
        this.nome = n;
        this.tipos = tipos;
        hp[0] = vida;
        hp[1] = vida;
        atq[0] = atk;
        atq[1] = atk;
        def[0] = defesa;
        def[1] = defesa;
    };

    public String getNome() {
        return this.nome;
    }

    public String showInfo() {
        return this.nome + " hp: " + hp[0] + "/" + hp[1];
    }

    public char renderPokemon() {
        return nome.charAt(0);
    }

    /* skills related methods */
    public boolean ishalfHp() {
        return (hp[0] > (hp[1] * 0.5));
    }

    public boolean isDead() {
        return (hp[0] <= 0);
    }

    public void boostAtk(double i) {
        atq[0] = (int) (atq[0] * i);
    }

    public void boostDef(double i) {
        def[0] = (int) (def[0] * i);
    }

    public void resetAttributes() {
        atq[0] = atq[1];
        def[0] = def[1];
    }

    public boolean isType(Tipo k) {
        if (tipos.length == 2) {
            if (tipos[0].equals(k) || tipos[1].equals(k)) {
                return true;
            }
            return false;
        } else {
            return (tipos[0].equals(k));
        }
    }

    public void takeHP(int i) {
        hp[0] = hp[0] - i;
        hp[0] = (hp[0] < 0) ? 0 : hp[0];
    }

    public void heal(int i) {
        int healthPool = (int) (hp[0] * i * 0.01);
        hp[0] = (hp[0] + healthPool > hp[1]) ? hp[1] : hp[0] + healthPool;
    }

    public void addLife(int i) {
        hp[0] = ((hp[0] + i) > hp[1]) ? hp[1] : hp[0] + i;
    }

    public void setProtectSkillFlag(boolean b) { // needed to attend other guard skills method
        this.protectSkillsOn = b;
    }

    public void addSkillWithTR(TR ebola) {
        Skills skillDoTR = ebola.getSkill();
        for (Tipo i : this.tipos) {
            if (skillDoTR.isTypeCompatible(i) && !habilidades.contains(skillDoTR)) {
                habilidades.add(skillDoTR);
                System.out.println("Skill " + skillDoTR.getNome() + " added!");
            }
        }
    }

    public int showAllSkills() {
        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println(i + ": " + habilidades.get(i).getNome());
        }
        return habilidades.size();
    }

    public Skills getSkill(int j) {
        return this.habilidades.get(j);
    }

    public void attack(Pokemon h) {
        int dmg = this.atq[0] - h.def[0];
        if (h.protectSkillsOn && !this.isType(Tipo.PSYCHIC)) {
            dmg = (int) (dmg * 0.5);
        }
        dmg = (dmg <= 0) ? 1 : dmg;
        h.takeHP(dmg);
    }

    public void useItem(Item k) {
        k.use(this);
    }

}