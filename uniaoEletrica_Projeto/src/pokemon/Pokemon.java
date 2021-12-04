package pokemon;

import java.util.ArrayList;

import dados.Dado;
import itens.Item;
import itens.TR;
import mapa.*;
import player.Player;
import skills.*;
import tipos.Tipo;
import turno.Combate;

public class Pokemon extends ElementoIlha {
    private String nome;
    private Tipo tipos[] = new Tipo[2];
    private int hp[] = new int[2]; // hp[0] current hp, hp[1] normal hp
    private int atq[] = new int[2]; // same index logic
    private int def[] = new int[2];
    private ArrayList<Skills> habilidades = new ArrayList<Skills>();
    private boolean protectSkillsOn = false;
    int d;
    int k;

    public Pokemon(ListaPokemons pokemon, TriplaCoordenada posicao) {
        super(posicao, pokemon.toString());
        this.nome = pokemon.getName();
        this.tipos = pokemon.getTipos();
        getHp()[0] = pokemon.getHP();
        getHp()[1] = pokemon.getHP();
        atq[0] = pokemon.getAtaque();
        atq[1] = pokemon.getAtaque();
        def[0] = pokemon.getDefesa();
        def[1] = pokemon.getDefesa();
    };

    public int[] getHp() {
        return hp;
    }

    public int[] getAtaque() {
        return atq;
    }

    public int[] getDefesa() {
        return def;
    }

    public String getNome() {
        return this.nome;
    }

    public Tipo[] getTipos() {
        return tipos;
    }

    public String showInfo() {
        return nome + " hp: " + hp[0] + "/" + hp[1] + " atq: " + atq[0] + " def: " + def[0];
    }

    public char renderPokemon() {
        return nome.charAt(0);
    }

    /* skills related methods */
    public boolean ishalfHp() {
        return (getHp()[0] > (getHp()[1] * 0.5));
    }

    public boolean isDead() {
        return (getHp()[0] <= 0);
    }

    public void boostAtk(double i) {
        atq[0] = (int) (atq[0] * i);
    }

    public void boostDef(double i) {
        def[0] = (int) (def[0] * i);
    }

    public void regenerate() {
        if (getHp()[0] < getHp()[1]) {
            getHp()[0] += 1;
        }
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
        getHp()[0] = getHp()[0] - i;
        getHp()[0] = (getHp()[0] < 0) ? 0 : getHp()[0];
    }

    public void heal(int i) {
        int healthPool = (int) (getHp()[0] * i * 0.01);
        getHp()[0] = (getHp()[0] + healthPool > getHp()[1]) ? getHp()[1] : getHp()[0] + healthPool;
    }

    public void addLife(int i) {
        getHp()[0] = ((getHp()[0] + i) > getHp()[1]) ? getHp()[1] : getHp()[0] + i;
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
            System.out.println("(" + i + ") " + habilidades.get(i).getNome());
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

    public void setDandK(int d, int k) {
        this.d = d;
        this.k = k;
    }

    public void sortearDistanciaEDificuldade() {
        Dado dado1 = new Dado(4, 1);
        Dado dado2 = new Dado(4, 2);

        setDandK(dado1.jogarDados(), dado2.jogarDados());

    }

    public boolean verificarDistanciaD(TriplaCoordenada coordPlayer) {
        boolean podeSerCapturado = false;

        if (coordPlayer.calculaDistancia(super.getPosicaoAtual()) <= d) {
            podeSerCapturado = true;
        }

        return podeSerCapturado;
    }

    public boolean tryCapture(int lance) {
        boolean captureSucced = false;
        if (lance > d + k) {
            captureSucced = true;
        }
        return captureSucced;
    }

    @Override
    protected void operar(Player player, Mapa mapa) {
        System.out.println("Voce pisou no pokemon! Agora ele esta hostil e pronto pra atacar!");
        Combate combate = new Combate(player, this, false);
        combate.start();
    }

    public void igualTipoIlha() {
        hp[0] = hp[0] * 115 / 100;
        atq[0] = atq[0] * 115 / 100;
        def[0] = def[0] * 115 / 100;
    }

    @Override
    public boolean podePassarPorCima() {
        return false;
    }
    
}