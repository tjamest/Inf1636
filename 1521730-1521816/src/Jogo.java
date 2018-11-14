import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;


public class Jogo implements MouseListener {
	
	//matrizes
	static int[][] inicialVermelho = {{1, 1}, {1,4}, {4, 1}, {4,4}};
	static int[][] inicialVerde = {{10, 1}, {13,1}, {10, 4}, {13,4}};
	static int[][] inicialAmarelo = {{10, 10}, {13,10}, {10, 13}, {13,13}};
	static int[][] inicialAzul = {{1, 10}, {1,13}, {4, 10}, {4,13}};
	
	public static int [][]posicoes= new int[15][15];
	
	//variaveis
	public static boolean newgame = false;
	public boolean  selecionado = false;
	public static Color cor;
	public static int ind, roll;
	static int turno;
	public static int tirou6 = 0;
	public static Color corEquipedaVez;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		confereMovimento();
		newgame = true;
		corEquipedaVez = Color.RED;
		
		
		//printConfereMovimento();
		
	}


	
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
		//selecionado = true;
		cor = Tabuleiro.DARK_RED;
		
		if (selecionado == false ) {
			
			
			
			for (int i =0 ; i< 4; i++) {
				
				System.out.printf("A EQUIPE DA VER EH %s \n ", getEquipedaVez());
				
				if ((int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordY/40)== y){
					
					if (getEquipedaVez() != "Vermelho") {
						System.out.printf("Time Vermelho aguarde sua vez de jogar \n ");
					}
	
					Menu.b4.setEnabled(false);
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_RED;
					break;
			
				}
			
				
				else if ((int)Math.ceil(Tabuleiro.pecasAzul.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasAzul.elementAt(i).CoordY/40)== y){
					
					if (getEquipedaVez() != "Azul") {
						System.out.printf("Time Azul aguarde sua vez de jogar \n ");
					}
					
					Menu.b4.setEnabled(false);
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.LIGHT_BLUE;
					break;
					
					
				}
				
				else if ((int)Math.ceil(Tabuleiro.pecasVerde.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasVerde.elementAt(i).CoordY/40)== y){
					

					if (getEquipedaVez() != "Verde") {
						System.out.printf("Time Verde aguarde sua vez de jogar \n ");
					}
					
					ind = i;
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_GREEN;
					break;
					
					
				}
				
				else if ((int)Math.ceil(Tabuleiro.pecasAma.elementAt(i).CoordX/40) == x 
						&& (int)Math.ceil(Tabuleiro.pecasAma.elementAt(i).CoordY/40)== y){
					
					if (getEquipedaVez() != "Amarelo") {
						System.out.printf("Time Amarelo aguarde sua vez de jogar \n ");
					}
					
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

					pecaSelecionada(Tabuleiro.pecasVerm, x, y);
					Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind, roll);
		
				}
				
				else if (cor == Tabuleiro.LIGHT_BLUE) {
					
					pecaSelecionada(Tabuleiro.pecasAzul, x, y);
					
					Tabuleiro.movepeca(Tabuleiro.pecasAzul, x, y, ind, roll);
					
				}
				else if (cor == Tabuleiro.DARK_GREEN) {
					
					pecaSelecionada(Tabuleiro.pecasVerde, x, y);
					
					Tabuleiro.movepeca(Tabuleiro.pecasVerde, x, y, ind, roll);
					
				}
				else {
					
					pecaSelecionada(Tabuleiro.pecasAma, x, y);
					
					Tabuleiro.movepeca(Tabuleiro.pecasAma, x, y, ind, roll);
				}
			
			//Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind);
			Menu.b4.setEnabled(true);	
			selecionado = false;
			cor = Color.BLACK;
			
			
		}
		else if (roll == 0) {
			System.out.println("Jogue o dado para concluir o movimento\n");
			
		}

		confereMatrix(x, y);
	}
	
	
	// -- DADO --
	
	public static int numeroDado() {
		
		roll = 0;
		roll = (int)(Math.random()*6+1);
	     System.out.printf("valor tirado eh %d e time é %s\n", roll, getEquipedaVez() ); 

	     if (roll == 5) 
	    	 jogadaAutomatica(roll);

	     return roll;
	}
	
	public static void jogadaAutomatica(int dado) {
			
		if(getEquipedaVez() == "Vermelho") {

			int indice = buscaPecaInicio(Tabuleiro.pecasVerm);
			
			if (posicoes[1][6] == -1 && indice != -1) {
				Tabuleiro.movepeca(Tabuleiro.pecasVerm, 1, 6, indice, roll);	
			}
			if (indice == -1 )
				 System.out.printf("Todos os pinos ja estão no jogo\n"); 
		}

		else if(getEquipedaVez() ==  "Azul") {
			
			int indice = buscaPecaInicio(Tabuleiro.pecasAzul);
			
			if (posicoes[6][13] == -1 && indice != -1) {
				Tabuleiro.movepeca(Tabuleiro.pecasAzul, 6, 13, indice, roll);	
			}
			if (indice == -1 )
				 System.out.printf("Todos os pinos ja estão no jogo\n"); 
			
		}
			
		else if(getEquipedaVez()  == "Verde") {
			
			int indice = buscaPecaInicio(Tabuleiro.pecasVerde);
			
			if (posicoes[8][1] == -1 && indice != -1) {
				Tabuleiro.movepeca(Tabuleiro.pecasVerde, 8, 1, indice, roll);	
			}
			if (indice == -1 )
				 System.out.printf("Todos os pinos ja estão no jogo\n"); 
				 
		}
		else if(getEquipedaVez() == "Amarelo") {
			
			int indice = buscaPecaInicio(Tabuleiro.pecasAma);
			
			if (posicoes[13][8] == -1 && indice != -1) {
				Tabuleiro.movepeca(Tabuleiro.pecasAma, 13, 8, indice, roll);	
			}
			if (indice == -1 )
				 System.out.printf("Todos os pinos ja estão no jogo\n"); 
			
		}	
	}
	
	public boolean contaSeis() {
		tirou6++;
		if(tirou6 == 3) {
			tirou6 = 0;
			return true;
		}
		return false;
	}
	
	
	// -- TURNO --
	
	public static void trocaTurno() {
		tirou6 = 0;
		if(corEquipedaVez == Color.RED) {
			corEquipedaVez = Color.GREEN;
			
		} else if(corEquipedaVez == Color.GREEN) {
			corEquipedaVez = Color.YELLOW;
			
		} else if(corEquipedaVez == Color.YELLOW) {
			corEquipedaVez = Color.BLUE;
			
		} else if(corEquipedaVez ==  Color.BLUE) {
			corEquipedaVez = Color.RED;
		}	
	}
	
	public static String getEquipedaVez() {
		String cor;
		if(corEquipedaVez == Color.YELLOW){
			cor = "Amarelo";
			return cor;
		}
		
		if(corEquipedaVez == Color.BLUE){
			cor = "Azul";
			return cor;
		}
		
		if(corEquipedaVez == Color.RED){
			cor = "Vermelho";
			return cor;
		} 
		
		if(corEquipedaVez == Color.GREEN) {
			cor = "Verde";
			return cor;
		}
		
		return null;
	}
	
	
	
	//-- MOVIMENTACAO PECA -- 
	
	
private static int buscaPecaInicio(Vector<Peao> peca) {
	
		int [][]pecas = null;
		int indice = -1;
		
		if (getEquipedaVez() == "Vermelho")
			pecas = inicialVermelho;
		
		else if (getEquipedaVez() == "Verde")
			pecas = inicialVerde;
		
		else if (getEquipedaVez() == "Amarelo")
			pecas = inicialAmarelo;
		
		else if (getEquipedaVez() == "Azul")
			pecas = inicialAzul;

		
		for (int i =0 ; i< 4; i++) {
			for (int j = 0; j<4; j++) {
				
//				System.out.printf("X SENDO VISTO NO FOR = %d\n", (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(j).CoordX/40));
//				System.out.printf("Y SENDO VISTO NO FOR = %d\n", (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(j).CoordY/40));
//				
//				System.out.printf("X QUE EU QUERO = %d\n", inicialVermelho[i][0] );
//				System.out.printf("Y QUE EU QUERO = %d\n", inicialVermelho[i][1]);
				
				if ((int)Math.ceil(peca.elementAt(j).CoordX/40) == pecas[i][0] 
						&& (int)Math.ceil(peca.elementAt(j).CoordY/40)== pecas[i][1]){
		
					indice = j;
					System.out.printf("Indice da peca do inicio = %d\n", indice);
					return indice;
				}
				
			}
		}
		
		return -1;
		
	}
	
	
	
	public static int pecaSelecionada(Vector<Peao> peca, int x, int y) {
		
		for (int i =0 ; i< 4; i++) {
			
			if ((int)Math.ceil(peca.elementAt(i).CoordX/40) == x 
					&& (int)Math.ceil(peca.elementAt(i).CoordY/40)== y){
				
				ind = i;
				System.out.printf("Peca selecionada = %d\n", ind);
			}	
		}
		
		return ind;
		
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
