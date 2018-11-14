import java.awt.Color;

public class Peao {
	
	
	//Time time 
	//Cor cor
	
	Color time;
	int id;
	int CoordX;
	int CoordY;

	
	public Peao (Color cor, int x, int y, int i) { // Time x
		
		//cor = cor;
		//time = x;
		time = cor;
		id = i;
		CoordX = x;
		CoordY = y;
	}
	
	public int getPositionX() {
		
		return CoordX;
	}
	
	public int getPositionY() {
		
		return CoordY;
	}
	
	public Color getTime() {
		
		return time;
	}

}
