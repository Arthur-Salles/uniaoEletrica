package pokemon;

import tipos.Tipo;

import java.util.Random;

public enum ListaPokemons {
    Ab("Abra", Tipo.PSYCHIC),
    Al("Alakazam", Tipo.PSYCHIC),
    Ar("Arcanine", Tipo.FIRE),
    Be("Bellsprout", Tipo.GRASS),
    Bl("Blastoise", Tipo.WATER),
    Bt("Bulbasaur", Tipo.GRASS),
    Cd("Charizard", Tipo.FIRE),
    Ce("Charmander", Tipo.FIRE),
    Co("Charmeleon", Tipo.FIRE),
    Cl("Cloyster", Tipo.WATER),
    Dg("Dewgong", Tipo.WATER),
    Dr("Dragonair", Tipo.DRAGON),
    De("Dragonite", Tipo.DRAGON),
    Di("Dratini", Tipo.DRAGON),
    Do("Drowzee", Tipo.PSYCHIC),
    Ez("Electabuzz", Tipo.ELECTRIC),
    Ee("Electrode", Tipo.ELECTRIC),
    Ex("Exeggcute", Tipo.GRASS),
    Eg("Exeggutor", Tipo.GRASS),
    Fl("Flareon", Tipo.FIRE),
    Gl("Gloom", Tipo.GRASS),
    Ge("Goldeen", Tipo.WATER),
    Gu("Golduck", Tipo.WATER),
    Gr("Growlithe", Tipo.FIRE),
    Gy("Gyarados", Tipo.WATER),
    Ho("Horsea", Tipo.WATER),
    Hy("Hypno", Tipo.PSYCHIC, Tipo.PSYCHIC),
    Iv("Ivysaur", Tipo.GRASS, Tipo.PSYCHIC),
    Jo("Jolteon", Tipo.ELECTRIC),
    Jy("Jynx", Tipo.PSYCHIC),
    Ko("Kabuto", Tipo.WATER),
    Kp("Kabutops", Tipo.WATER),
    Ka("Kadabra", Tipo.PSYCHIC),
    Ki("Kingler", Tipo.WATER),
    Kr("Krabby", Tipo.WATER),
    La("Lapras", Tipo.WATER),
    Mp("Magikarp", Tipo.WATER),
    Mr("Magmar", Tipo.FIRE),
    Me("Magnemite", Tipo.ELECTRIC),
    Mn("Magneton", Tipo.ELECTRIC),
    Mw("Mew", Tipo.PSYCHIC),
    Mo("Mewtwo", Tipo.PSYCHIC),
    Ms("Moltres", Tipo.FIRE),
    Mm("Mr. Mime", Tipo.PSYCHIC),
    Ni("Ninetales", Tipo.FIRE),
    Od("Oddish", Tipo.GRASS),
    Oe("Omanyte", Tipo.WATER),
    Or("Omastar", Tipo.WATER),
    Ps("Paras", Tipo.GRASS),
    Pt("Parasect", Tipo.GRASS),
    Pi("Pikachu", Tipo.ELECTRIC),
    Pg("Poliwag", Tipo.WATER),
    Pl("Poliwhirl", Tipo.WATER),
    Ph("Poliwrath", Tipo.WATER),
    Pa("Ponyta", Tipo.FIRE),
    Py("Psyduck", Tipo.WATER),
    Ru("Raichu", Tipo.ELECTRIC),
    Rh("Rapidash", Tipo.FIRE),
    Sa("Seadra", Tipo.WATER),
    Sg("Seaking", Tipo.WATER),
    Sl("Seel", Tipo.WATER),
    Sr("Shellder", Tipo.WATER),
    So("Slowbro", Tipo.WATER),
    Se("Slowpoke", Tipo.WATER, Tipo.PSYCHIC),
    St("Squirtle", Tipo.WATER, Tipo.PSYCHIC),
    Sm("Starmie", Tipo.WATER),
    Sy("Staryu", Tipo.WATER),
    Ta("Tangela", Tipo.GRASS),
    To("Tentacool", Tipo.WATER),
    Te("Tentacruel", Tipo.WATER),
    Vn("Vaporeon", Tipo.WATER),
    Vr("Venusaur", Tipo.GRASS),
    Vl("Victreebel", Tipo.GRASS),
    Vm("Vileplume", Tipo.GRASS),
    Vb("Voltorb", Tipo.ELECTRIC),
    Vx("Vulpix", Tipo.FIRE),
    Wt("Wartortle", Tipo.WATER),
    Wb("Weepinbell", Tipo.GRASS),
    Za("Zapdos", Tipo.ELECTRIC);

    private Tipo tipo1;
    private Tipo tipo2;
    private String nome;

    private ListaPokemons(String nome, Tipo tipo1) {
        this.nome = nome;
        this.tipo1 = tipo1;
        this.tipo2 = Tipo.NULO;
    }

    private ListaPokemons(String nome, Tipo tipo1, Tipo tipo2) {
        this(nome, tipo1);
        this.tipo2 = tipo2;
    }

    public String getName() {
        return nome;
    }

    public Tipo[] getTipos() {
        Tipo[] tipos = { tipo1, tipo2 };
        return tipos;
    }

}
