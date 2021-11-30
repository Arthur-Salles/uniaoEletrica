package mapa;

public class TriplaCoordenada extends Coordenadas{
	private int z;
	
	public TriplaCoordenada (int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public TriplaCoordenada mudarPosicao(int a, int b, int c) {
		int x = super.getX();
		int y = super.getY();
		TriplaCoordenada novaCoordenada = new TriplaCoordenada(x+a, y+b, z+c);	
			
		return novaCoordenada;
	}
	
	public boolean verificarSeEstaDentroDoMapa(int i, int j, int k){
		boolean estaDentroMapa = false;

		if (super.verificarSeEstaDentroDoMapa(i, j) || z<=k) {
			estaDentroMapa = true;
		}	
		return estaDentroMapa;
	}	
	
	public int getX() {
		return super.getX();
	}
	public int getY() {
		return super.getY();
	}
	public int getZ() {
		return z;
	}

	public void zerarPosicao() {
		super.zerarPosicao();	
	}

	public void mudarDeNivel(int n) {
		z=n;		
	}
}
