import java.awt.Color;

public class Peao {
	
	
	//Time time 
	//Cor cor
	
	Color corP;
	int id;
	int CoordX;
	int CoordY;
	protected int qtdCasasAndadas = 0;
	boolean alteraTam = false;
	
	
	public Peao (Color cor, int x, int y, int i, boolean altera) { // Time x
		
		corP = cor;
		id = i;
		CoordX = x;
		CoordY = y;
		alteraTam = altera;
	}
	
	public int getPositionX() {
		
		return CoordX;
	}
	
	public int getPositionY() {
		
		return CoordY;
	}
	
	
}
