package mapa;

public class Coordenadas {
	private int x;
	private int y;
	
	public Coordenadas (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordenadas mudarPosicao(int a, int b) {
		Coordenadas novaCoordenada = new Coordenadas(x, y);	

		novaCoordenada = new Coordenadas(x+a, y+b);
		
		return novaCoordenada;
	}
	
	public boolean verificarSeEstaDentroDoMapa(int i, int j){
		boolean estaDentroMapa = true;

		if (x>j-1 || x<0 || y<0 || y>i-1) {
			estaDentroMapa = false;
		}	
		return estaDentroMapa;
	}
	
	public double calculaDistancia(Coordenadas a){
		return Math.abs(x-a.x) + Math.abs(y-a.y);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
