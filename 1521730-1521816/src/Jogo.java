import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Jogo implements MouseListener {
	
	public static boolean newgame = false;
	public static String [][]confereMov= new String [15][15];
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		confereMovimento();
		//printConfereMovimento();
		newgame = true;
	}
	
//Vetor que confere se casa esta livre ou nao	
	
public void confereMovimento() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				confereMov[i][j] = "Null";
				
				if ((i == 1) && (j == 1 ||  j == 4 ) || (i== 4) && (j == 1 ||  j == 4 ) ){
					confereMov[i][j] = "Color.red";
				}
				
				else if ((i == 1) && (j == 10 ||  j == 13 ) ||(i == 4) && (j == 10 || j==13)) {
					confereMov[i][j] = "Color.green";
				}
				
				else if ((i == 10) && (j == 1 ||  j == 4 ) || (i== 13) && (j == 1 ||  j == 4 ) ){
					confereMov[i][j] = "Color.blue";
				}

				else if ((i == 10) && (j == 10 ||  j == 13 ) ||(i == 13) && (j == 10 || j==13)) {
					confereMov[i][j] = "Color.yellow";
				}

			}
		}
		
	}
	
public void printConfereMovimento() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				System.out.printf("indice matriz eh [%d][%d] = %s \n" ,i, j , confereMov[i][j]);

				
			}
		}
		
	}
	
	
	
public void confereMatrix(int x, int y) {
	
	if (confereMov[x][y] == "Null") {
		System.out.printf("Pode mover\n");
		
		
	}
	
	else if (confereMov[x][y] != "Null") {
		

		System.out.printf("Casa ocupada \n");
	}		
	
	
}

	// ---- EVENTOS DO MOUSE ----

	@Override
	public void mouseClicked(MouseEvent e) {
	
		int x;
		int y;
		
		x = (int) Math.ceil(e.getX()/40);
		y = (int) Math.ceil(e.getY()/40);
		
		System.out.printf("Casa posicao x = %d y = %d \n ", x, y );

		//System.out.println("mouse na posição x=" + e.getX() + " y=" + e.getY()); 
			
		confereMatrix(x, y);
	}
	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	

}
