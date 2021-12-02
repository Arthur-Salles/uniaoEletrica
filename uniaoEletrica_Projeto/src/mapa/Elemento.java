package mapa;

import player.Player;

public class Elemento {
    private String icone;

    public Elemento(String icone) {
        this.icone = icone;
    }

    protected String getIcone() {
        return icone;
    }

    public void imprimirIcone() {
        System.out.print(icone);
    }

    public void imprimirIcone(String h) {
        System.out.print(icone + h);
    }

<<<<<<< HEAD
	public Elemento(String icone) {
		this.icone = icone;
	}
	
	protected String getIcone() {
		return icone;
	}
	
	public void imprimirIcone() {
		System.out.print(icone);		
	} 
	
	public void imprimirIcone(String h) {
		System.out.print(icone + h);		
	}

=======
>>>>>>> e2fe8101234bc47decada957b43eaa4680a55f6e
}
