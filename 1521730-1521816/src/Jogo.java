import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;


public class Jogo implements MouseListener {
	
	public static boolean newgame = false;
	public static int [][]posicoes= new int[15][15];
	public boolean  selecionado = false;
	public static Color cor;
	public static int ind, roll;
	static int turno;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		confereMovimento();
		newgame = true;
		confereTurno();
		
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
		else if (selecionado != false && roll != 0) {
			
			System.out.printf("selecionado = %s\n", selecionado);
			
			if (cor == Tabuleiro.DARK_RED ) {
				
				if (roll == 5) { // Dado vai para casa de saida
					
				}
				
				//caso nao tenha peoes a serem retirados ou ja tenha peao na casa de saida, ele movimenta 5 casas com outro peao qualquer
				
				
				
				
				
				
				
				
				Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind, roll);
				
			}
			else if (cor == Tabuleiro.LIGHT_BLUE) {
				Tabuleiro.movepeca(Tabuleiro.pecasAzul, x, y, ind, roll);
				
			}
			else if (cor == Tabuleiro.DARK_GREEN) {
				Tabuleiro.movepeca(Tabuleiro.pecasVerde, x, y, ind, roll);
				
			}
			else {
				Tabuleiro.movepeca(Tabuleiro.pecasAma, x, y, ind, roll);
			}
			
			//Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind);
			selecionado = false;
			cor = Color.BLACK;
			
		}
		else if (roll == 0) {
			System.out.println("Jogue o dado para concluir o movimento\n");
			
		}
	
		//Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, 0);
			

		//System.out.println("mouse na posição x=" + e.getX() + " y=" + e.getY()); 
			
		confereMatrix(x, y);
	}
	
	public static void confereTurno() {
		
		turno = (int)(Math.random()*4+1);
		System.out.printf("valor turno eh %d\n", turno);
		
		if (turno == 1) {
			System.out.printf("VEZ VERMELHO \n");
			
		}
		else if (turno == 2) {
			System.out.printf("VEZ VERDE\n");
			
		}
		else if (turno == 3) {
			System.out.printf("VEZ AMARELO\n");
			
		}
		else {
			System.out.printf("VEZ AZUL\n");
			
		}

	}
	
	public static int numeroDado() {
		
		 roll = (int)(Math.random()*6+1);
	     System.out.printf("valor tirado eh %d\n", roll); 
	     return roll;
	    //dadox = true;
		
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
