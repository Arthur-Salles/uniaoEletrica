package pokemon;

public class Combat {
    
    private Pokemon j, pc;
    private int turns = 0;
    // deve receber o player tbm
    // ver iniciativa por hr o pc sempre starta

    public Combat(Pokemon j, Pokemon pc){
        this.j = j;
        this.pc = pc;
    }

    // ultra simple fight model
    public void initiateFight(){
        while(j.isAlive() && pc.isAlive()){
            // check skills and land buffs
            j.takePokemonDamage(pc.getAtk());
            pc.takePokemonDamage(j.getAtk());
            turns++;
        }
        if(j.isAlive()){
            System.out.println(j.toString() + " ganhou!");
        }
        else{
            System.out.println(pc.toString() + " ganhou!");
        }
    }

}
