package pokemon;

import tipos.Tipo;

public enum ListaPokemons {
    Ab("Abra", 25, 20, 15, Tipo.PSYCHIC),
    Al("Alakazam", 55, 20, 15, Tipo.PSYCHIC),
    Ar("Arcanine", 90, 20, 15, Tipo.FIRE),
    Be("Bellsprout", 50, 20, 15, Tipo.GRASS),
    Bl("Blastoise", 79, 20, 15, Tipo.WATER),
    Bt("Bulbasaur", 45, 20, 15, Tipo.GRASS),
    Cd("Charizard", 78, 20, 15, Tipo.FIRE),
    Ce("Charmander", 39, 20, 15, Tipo.FIRE),
    Co("Charmeleon", 58, 20, 15, Tipo.FIRE),
    Cl("Cloyster", 50, 20, 15, Tipo.WATER),
    Dg("Dewgong", 90, 20, 15, Tipo.WATER),
    Dr("Dragonair", 61, 20, 15, Tipo.DRAGON),
    De("Dragonite", 91, 20, 15, Tipo.DRAGON),
    Di("Dratini", 41, 20, 15, Tipo.DRAGON),
    Do("Drowzee", 60, 20, 15, Tipo.PSYCHIC),
    Ez("Electabuzz", 65, 20, 15, Tipo.ELECTRIC),
    Ee("Electrode", 60, 20, 15, Tipo.ELECTRIC),
    Ex("Exeggcute", 60, 20, 15, Tipo.GRASS),
    Eg("Exeggutor", 95, 20, 15, Tipo.GRASS),
    Fl("Flareon", 65, 20, 15, Tipo.FIRE),
    Gl("Gloom", 60, 20, 15, Tipo.GRASS),
    Ge("Goldeen", 45, 20, 15, Tipo.WATER),
    Gu("Golduck", 80, 20, 15, Tipo.WATER),
    Gr("Growlithe", 55, 20, 15, Tipo.FIRE),
    Gy("Gyarados", 95, 20, 15, Tipo.WATER),
    Ho("Horsea", 30, 20, 15, Tipo.WATER),
    Hy("Hypno", 85, 20, 15, Tipo.PSYCHIC, Tipo.PSYCHIC),
    Iv("Ivysaur", 60, 20, 15, Tipo.GRASS, Tipo.PSYCHIC),
    Jo("Jolteon", 65, 20, 15, Tipo.ELECTRIC),
    Jy("Jynx", 65, 20, 15, Tipo.PSYCHIC),
    Ko("Kabuto", 30, 20, 15, Tipo.WATER),
    Kp("Kabutops", 60, 20, 15, Tipo.WATER),
    Ka("Kadabra", 40, 20, 15, Tipo.PSYCHIC),
    Ki("Kingler", 55, 20, 15, Tipo.WATER),
    Kr("Krabby", 30, 20, 15, Tipo.WATER),
    La("Lapras", 130, 20, 15, Tipo.WATER),
    Mp("Magikarp", 20, 20, 15, Tipo.WATER),
    Mr("Magmar", 65, 20, 15, Tipo.FIRE),
    Me("Magnemite", 25, 20, 15, Tipo.ELECTRIC),
    Mn("Magneton", 50, 20, 15, Tipo.ELECTRIC),
    Mw("Mew", 100, 20, 15, Tipo.PSYCHIC),
    Mo("Mewtwo", 106, 20, 15, Tipo.PSYCHIC),
    Ms("Moltres", 90, 20, 15, Tipo.FIRE),
    Mm("Mr Mime", 40, 45, 65, Tipo.PSYCHIC),
    Ni("Ninetales", 73, 20, 15, Tipo.FIRE),
    Od("Oddish", 45, 20, 15, Tipo.GRASS),
    Oe("Omanyte", 35, 20, 15, Tipo.WATER),
    Or("Omastar", 70, 20, 15, Tipo.WATER),
    Ps("Paras", 35, 20, 15, Tipo.GRASS),
    Pt("Parasect", 60, 20, 15, Tipo.GRASS),
    Pi("Pikachu", 35, 20, 15, Tipo.ELECTRIC),
    Pg("Poliwag", 40, 20, 15, Tipo.WATER),
    Pl("Poliwhirl", 65, 20, 15, Tipo.WATER),
    Ph("Poliwrath", 90, 20, 15, Tipo.WATER),
    Pa("Ponyta", 50, 20, 15, Tipo.FIRE),
    Py("Psyduck", 50, 20, 15, Tipo.WATER),
    Ru("Raichu", 60, 20, 15, Tipo.ELECTRIC),
    Rh("Rapidash", 65, 20, 15, Tipo.FIRE),
    Sa("Seadra", 55, 20, 15, Tipo.WATER),
    Sg("Seaking", 80, 20, 15, Tipo.WATER),
    Sl("Seel", 65, 20, 15, Tipo.WATER),
    Sr("Shellder", 30, 20, 15, Tipo.WATER),
    So("Slowbro", 95, 20, 15, Tipo.WATER),
    Se("Slowpoke", 90, 20, 15, Tipo.WATER, Tipo.PSYCHIC),
    St("Squirtle", 44, 20, 15, Tipo.WATER, Tipo.PSYCHIC),
    Sm("Starmie", 60, 20, 15, Tipo.WATER),
    Sy("Staryu", 30, 20, 15, Tipo.WATER),
    Ta("Tangela", 65, 20, 15, Tipo.GRASS),
    To("Tentacool", 40, 20, 15, Tipo.WATER),
    Te("Tentacruel", 80, 20, 15, Tipo.WATER),
    Vn("Vaporeon", 130, 20, 15, Tipo.WATER),
    Vr("Venusaur", 80, 20, 15, Tipo.GRASS),
    Vl("Victreebel", 80, 20, 15, Tipo.GRASS),
    Vm("Vileplume", 75, 20, 15, Tipo.GRASS),
    Vb("Voltorb", 40, 20, 15, Tipo.ELECTRIC),
    Vx("Vulpix", 38, 20, 15, Tipo.FIRE),
    Wt("Wartortle", 59, 20, 15, Tipo.WATER),
    Wb("Weepinbell", 65, 20, 15, Tipo.GRASS),
    Za("Zapdos", 90, 20, 15, Tipo.ELECTRIC);

    private String nome;
    private int HP;
    private int ataque;
    private int defesa;
    private Tipo tipo1;
    private Tipo tipo2;

    private ListaPokemons(String nome, int HP, int ataque, int defesa, Tipo tipo1) {
        this.nome = nome;
        this.HP = HP;
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo1 = tipo1;
        this.tipo2 = Tipo.NULO;
    }

    private ListaPokemons(String nome, int HP, int ataque, int defesa, Tipo tipo1, Tipo tipo2) {
        this(nome, HP, ataque, defesa, tipo1);
        this.tipo2 = tipo2;
    }

    public String getName() {
        return nome;
    }

    public int getHP() {
        return HP;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public Tipo[] getTipos() {
        Tipo[] tipos = { tipo1, tipo2 };
        return tipos;
    }

}
