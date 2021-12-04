package transporte;

import java.util.Scanner;

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

		System.out.print("Voce pode ir para os seguintes niveis: ");
		player.imprimirNiveisDisponiveis();
		System.out.print("Digite um nível: ");
		do {
			try {
				String command = keyboard.nextLine();
				player.mudarDeNivel(Integer.valueOf(command));
				flag = false;
			} catch (NumberFormatException e) {
				System.out.println("Para de tentar quebrar");
			}
		} while (flag);
		
	}

}
