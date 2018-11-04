import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

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
		System.out.printf("PODE MOVER CARAI \n");
		
	//	Tabuleiro.DrawPino(Tabuleiro.g2d, x,y, Color.red);
		
		
	}
	
	else if (confereMov[x][y] != "Null") {
		
		//salvar x1 e y1
		//conferir 2 clique
		//baseado no 2 clique, ver se pode ou n mover
		//if nulo, pegar valor da posicao, pegar x1, y1, e mudar para nulo na matriz
		//passar para x2,y2 o valor da posicao
		//percorrer nova matriz e alterar pino ini vermelho ...
	
		
		//botar tipo id na matriz
		//cortar numero e salvo em algum lugar e passar cor
		//esse 1 2 3 4 varo ser alterados na matriz pino vermelho
		//alterar baseado no id dos vermelhos;
		
		//tabuleiro.repaint
		
		//funcao chama jogada chama a mouse click. 
		
	
		//rapaint pecas
		
		

		
		
		System.out.printf("CHEGOU TARDE OTARIO \n");
	}		
	
	
}

	// ---- EVENTOS DO MOUSE ----

	@Override
	public void mouseClicked(MouseEvent e) {
	
		int x;
		int y;
		
		x = (int) Math.ceil(e.getX()/40);
		y = (int) Math.ceil(e.getY()/40);

		System.out.println("mouse na posição x=" + e.getX() + " y=" + e.getY()); 
			
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
