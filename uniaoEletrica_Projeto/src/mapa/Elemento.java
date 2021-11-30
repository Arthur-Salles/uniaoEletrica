package mapa;

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
}
