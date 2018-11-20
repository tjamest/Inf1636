import java.awt.Color;

public class Peao {
	
	
	//Time time 
	//Cor cor
	
	Color corP;
	int id;
	int CoordX;
	int CoordY;
	protected int qtdCasasAndadas = 0;
	boolean abrigo = false;
	boolean saida = false;
	boolean barreira = false;

	
	public Peao (Color cor, int x, int y, int i, boolean abr, boolean said, boolean barr) { // Time x
		
		corP = cor;
		id = i;
		CoordX = x;
		CoordY = y;
		abrigo = abr;
		saida = said;
		barreira = barr;
	}
	
	public int getPositionX() {
		
		return CoordX;
	}
	
	public int getPositionY() {
		
		return CoordY;
	}
	
	
}
