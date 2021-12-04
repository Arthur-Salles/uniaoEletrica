package transporte;

import java.util.Scanner;

import mapa.Ilha;
import mapa.Mapa;
import mapa.TriplaCoordenada;
import player.Player;

public class Elevador extends Transporte{

	private Scanner keyboard;

	public Elevador(TriplaCoordenada posicao) {
		super(posicao, "||");
	}
	
	@Override
	public void transportar(Player player, Mapa mapa) {
        keyboard = new Scanner(System.in);
		boolean flag = true;
		Ilha ilhaAtual = player.getIlhaAtual();
		
		if (ilhaAtual.temMaisDeUmNivel()) {
			System.out.print("Voce pode ir para os seguintes niveis: ");
			player.imprimirNiveisDisponiveis();
			System.out.print("Digite um nível: ");
			do {
				String command = keyboard.nextLine();
				int n = Integer.valueOf(command);
				if (player.getNivel() != n && ilhaAtual.nivelEhValido(n)) {
					player.mudarDeNivel(Integer.valueOf(command));
					flag = false;
				}else {
					System.out.println("Digite um nível válido!");
				}
			} while (flag);
		}else {
			System.out.println("Não há niveis disponiveis");
			player.mudarDeNivel(0);
		}
		
		
	}

}
