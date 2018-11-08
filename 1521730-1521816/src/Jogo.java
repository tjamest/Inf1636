import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;


public class Jogo implements MouseListener {
	
	public static boolean newgame = false;
	public static int [][]posicoes= new int[15][15];
	public boolean  selecionado = false;
	public static Color cor;
	int ind;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		confereMovimento();
		newgame = true;
		//printConfereMovimento();
		
	}
	
//Vetor que confere se casa esta livre ou nao	
	
public void confereMovimento() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				posicoes[i][j] = -1;
				
			}
		}		
}
	
public static void printConfereMovimento() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				System.out.printf("indice matriz eh [%d][%d] = %d \n" ,i, j , posicoes[i][j]);

				
			}
		}
		
	}
	
	
	
public void confereMatrix(int x, int y) {
	
	if (posicoes[x][y] == -1) {
		System.out.printf("Pode mover\n");
		
		
	}
	
	else{
		

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
		
		if (selecionado == false ) {
			
			for (int i =0 ; i< 4; i++) {
				
				if ((int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordY/40)== y){
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_RED;
					break;
					
					
				}
				
				else if ((int)Math.ceil(Tabuleiro.pecasAzul.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasAzul.elementAt(i).CoordY/40)== y){
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.LIGHT_BLUE;
					break;
					
					
				}
				
				else if ((int)Math.ceil(Tabuleiro.pecasVerde.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasVerde.elementAt(i).CoordY/40)== y){
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_GREEN;
					break;
					
					
				}
				
				else if ((int)Math.ceil(Tabuleiro.pecasAma.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasAma.elementAt(i).CoordY/40)== y){
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_YELLOW;
					break;
					
					
				}	
			}
		}
		else if (selecionado != false) {
			
			System.out.printf("selecionado = %s\n", selecionado);
			
			if (cor == Tabuleiro.DARK_RED ) {
				Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind);
				
			}
			else if (cor == Tabuleiro.LIGHT_BLUE) {
				Tabuleiro.movepeca(Tabuleiro.pecasAzul, x, y, ind);
				
			}
			else if (cor == Tabuleiro.DARK_GREEN) {
				Tabuleiro.movepeca(Tabuleiro.pecasVerde, x, y, ind);
				
			}
			else {
				Tabuleiro.movepeca(Tabuleiro.pecasAma, x, y, ind);
			}
			
			//Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind);
			selecionado = false;
			cor = Color.BLACK;
			
		}
	
		//Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, 0);
			

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
