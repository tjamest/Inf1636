import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;


public class Jogo implements MouseListener {
	
	//matrizes e vetores
	public static int [][]posicoes= new int[15][15];
	
	//variaveis
	public static boolean newgame = false;
	public boolean  selecionado = false;
	public static Color cor;
	public static int ind, roll;
	public static boolean jogadaNormal = false;
	public static boolean concluiuJogada = false;
	
	//private static boolean active = true;
	public static int tirou6 = 0;
	public static Color corEquipedaVez;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		preencheMatrizPosicoes();
		newgame = true;
		corEquipedaVez = Color.RED;
		
		
		//printMatrizPosicoes();
		
	}


	
public void preencheMatrizPosicoes() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				posicoes[i][j] = -1;
				
			}
		}		
}
	
public static void printMatrizPosicoes() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++) {
				
				System.out.printf("indice matriz eh [%d][%d] = %d \n" ,i, j , posicoes[i][j]);

				
			}
		}
		
}
	
// Checa se movimento pode acontecer ou nao	
	
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
		
		//System.out.printf("Casa posicao x = %d y = %d \n ", x, y );
		
		//cor = Tabuleiro.DARK_RED;
		
		confereMovimento(x, y); 
	
	}
	
	
	
	//---- MOVIMENTACAO ----
	protected void confereMovimento(int x, int y) {
		
		if (selecionado == false ) { //ainda nao selecionou peca para mover
			
			//Menu.b4.setEnabled(false);
			
			System.out.printf("Selecionando Peca \n"); 
			System.out.printf("Equipe da vez = %s  \n", getEquipedaVez());
			
			if (getEquipedaVez() == "Vermelho") {
				
				ind = pecaSelecionada(Tabuleiro.times.elementAt(0).peoes,  x, y);
				
				Movimentacao.MovimentacaoNormal(x,  y, roll, Color.RED, ind);
				
				if (ind != -1) {
					
					if (getEquipedaVez() != "Vermelho") {
						System.out.printf("Time Vermelho aguarde sua vez de jogar \n ");
					}
					Menu.b4.setEnabled(false);
					
					
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_RED;
				}
				
			}
			
			else if (getEquipedaVez() == "Verde") {
				ind = pecaSelecionada(Tabuleiro.times.elementAt(1).peoes,  x, y);
				
				Movimentacao.MovimentacaoNormal(x,  y, roll, Color.GREEN, ind);
				
				if (ind != -1) {
					
					if (getEquipedaVez() != "Verde") {
						System.out.printf("Time Verde aguarde sua vez de jogar \n ");
					}
					Menu.b4.setEnabled(false);
					
					
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_GREEN;
				}
				
			}
			else if (getEquipedaVez() == "Amarelo") {
				ind = pecaSelecionada(Tabuleiro.times.elementAt(2).peoes,  x, y);
				
				Movimentacao.MovimentacaoNormal(x,  y, roll, Color.YELLOW, ind);
				
				if (ind != -1) {
					
					if (getEquipedaVez() != "Amarelo") {
						System.out.printf("Time Amarelo aguarde sua vez de jogar \n ");
					}
					Menu.b4.setEnabled(false);
					
					
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.DARK_YELLOW;
				}
				
			}
			else if (getEquipedaVez() == "Azul") {
				ind = pecaSelecionada(Tabuleiro.times.elementAt(3).peoes,  x, y);
				
				Movimentacao.MovimentacaoNormal(x,  y, roll, Color.BLUE, ind);
				
				if (ind != -1) {
					
					if (getEquipedaVez() != "Azul") {
						System.out.printf("Time Azul aguarde sua vez de jogar \n ");
					}
					Menu.b4.setEnabled(false);
					
					
					System.out.printf("Peca selecionada = %d\n", ind);
					selecionado = true;
					cor = Tabuleiro.LIGHT_BLUE;
				}	
			}

		}
		
		else { // ja tem peca selecionada para mover
			System.out.printf("Selecionando Posicao \n");

			if (cor == Tabuleiro.DARK_RED ) {
				
				System.out.printf(" X = %d e Y = %d\n", x,y);
				
				if (Movimentacao.casaX == x  && Movimentacao.casaY == y) {
					
					System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
					movimento(Tabuleiro.times.elementAt(0).peoes, x, y, roll);
					Tabuleiro.times.elementAt(0).ultimoPinoMovimentado = Tabuleiro.times.elementAt(0).peoes.elementAt(ind);
					System.out.printf("-- Classe Jogo - ultimo peao movimentado tem indice %d\n", Tabuleiro.times.elementAt(0).peoes.elementAt(ind).id);
					Menu.b4.setEnabled(true);
					concluiuJogada = true;
				}
				else {
					System.out.printf("Movimento Invalido\n");
				}
	
			}
			if (cor == Tabuleiro.DARK_GREEN ) {
				
				System.out.printf(" X = %d e Y = %d\n", x,y);
				
				if (Movimentacao.casaX == x  && Movimentacao.casaY == y) {
					
					System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
					movimento(Tabuleiro.times.elementAt(1).peoes, x, y,  roll);
					Tabuleiro.times.elementAt(1).ultimoPinoMovimentado = Tabuleiro.times.elementAt(1).peoes.elementAt(ind);
					System.out.printf("-- Classe Jogo - ultimo peao movimentado tem indice %d\n", Tabuleiro.times.elementAt(1).peoes.elementAt(ind).id);
					Menu.b4.setEnabled(true);
					concluiuJogada = true;
				}
				else {
					System.out.printf("Movimento Invalido\n");
				}	
			}
			if (cor == Tabuleiro.DARK_YELLOW) {
				System.out.printf(" X = %d e Y = %d\n", x,y);
				
				if (Movimentacao.casaX == x  && Movimentacao.casaY == y) {
					
					System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
					movimento(Tabuleiro.times.elementAt(2).peoes, x, y,  roll);
					Tabuleiro.times.elementAt(2).ultimoPinoMovimentado = Tabuleiro.times.elementAt(2).peoes.elementAt(ind);
					System.out.printf("-- Classe Jogo - ultimo peao movimentado tem indice %d\n", Tabuleiro.times.elementAt(2).peoes.elementAt(ind).id);
					Menu.b4.setEnabled(true);
					concluiuJogada = true;
				}
				else {
					System.out.printf("Movimento Invalido\n");
				}
			}
			if (cor == Tabuleiro.LIGHT_BLUE) {
				
				System.out.printf(" X = %d e Y = %d\n", x,y);
				
				if (Movimentacao.casaX == x  && Movimentacao.casaY == y) {
					
					System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
					movimento(Tabuleiro.times.elementAt(3).peoes, x, y, roll);
					Tabuleiro.times.elementAt(3).ultimoPinoMovimentado = Tabuleiro.times.elementAt(3).peoes.elementAt(ind);
					System.out.printf("-- Classe Jogo - ultimo peao movimentado tem indice %d\n", Tabuleiro.times.elementAt(3).peoes.elementAt(ind).id);
					Menu.b4.setEnabled(true);
					concluiuJogada = true;
					
				}
				else {
					System.out.printf("Movimento Invalido\n");
				}
			}
			

			selecionado = false; 
			jogadaNormal = false;
			
			
			if (roll != 6 && concluiuJogada == true) {
				System.out.printf("Troca turno jogo\n");
				trocaTurno();
				concluiuJogada = false;
			}
			else if (roll == 6 && tirou6 <2) { // && tem peca na casa de saida ou fora do jogo
				contaSeis();
				
//				if (tirou6 == 3) {
//					System.out.printf("Conta6 = %d \n", contaSeis());
//					System.out.printf("Indice da ultima peca movimentada = %d d time %s \n", contaSeis(), getEquipedaVez());
//					
//				}
			}
			
			
		}	
	}
	
	
	//Logica da Movimentacao
	
	public static void movimento(Vector<Peao> peca, int x, int y,int dado){
		
		System.out.printf("indice = %d\n", ind);
		Tabuleiro.movepeca(peca, x, y, ind, dado);
		
		
	}
	
	
	//Retorna indice de peca selecionada
		
	public static int pecaSelecionada(Vector<Peao> peca, int x, int y) {
		
		for (int i =0 ; i< 4; i++) {
			
			if (peca.elementAt(i).CoordX == x 
					&& peca.elementAt(i).CoordY == y){
				
				ind = i;
				//System.out.printf("Peca selecionada = %d\n", ind);
				return ind;
			}	
		}
		
		return -1;
		
	}	
	
	
	
	// -- DADO --
	
	public static int numeroDado(int n) {
		
		//roll = 0;
		//roll = (int)(Math.random()*6+1);
		
		
		
		roll = n;
		
		
	    System.out.printf("valor tirado eh %d e time  %s\n", roll, getEquipedaVez() ); 

	     if (roll == 5) {
	    	 Tabuleiro.fundo = corEquipedaVez;
	    	 int aux = jogadaAutomatica(roll);
	    	 
	    	 // fazer caso abrigo
	    	 
	    	 if (aux == -1) { // Todas as pecas do time estao no jogo
	    		 System.out.printf("Nao fez jogada automatica, faz jogada normal\n", roll); 
	    		 
	    		 if (roll == 5 && (Jogo.posicoes[1][6] != -1 && getEquipedaVez() == "Vermelho") ||
	    		    	 (Jogo.posicoes[8][1] != -1 && getEquipedaVez() == "Verde" ) ||  (Jogo.posicoes[13][8] != -1 && getEquipedaVez() == "Amarelo" ) || 
	    		    			 (Jogo.posicoes[6][13] != -1 && getEquipedaVez() == "Azul")) {
	    			 
	    			// Casa de saida nao vazia e dado igual a 5 = jogada normal
	    			 Tabuleiro.fundo = corEquipedaVez;
		    		 System.out.printf("entrou\n");
		    		 jogadaNormal = true;
		    		 Menu.b4.setEnabled(false);
	    
	    		 }
	    	 }
	    	 else {
	    		 Tabuleiro.fundo = corEquipedaVez;
	    		 trocaTurno(); 
	    	 }
	    	 
	     }
	     else if (roll != 5  && (Jogo.posicoes[1][6] != -1 && getEquipedaVez() == "Vermelho") ||
		    	 (Jogo.posicoes[8][1] != -1 && getEquipedaVez() == "Verde" ) ||  (Jogo.posicoes[13][8] != -1 && getEquipedaVez() == "Amarelo" ) || 
    			 (Jogo.posicoes[6][13] != -1 && getEquipedaVez() == "Azul")) {
	    	 
	    	 		//BUG! peca verde estava na casa de saida da amarela e bugou pq ele achou que era peca amarela q ia sair
	    	 		//fazer funcao que retorna time da peca que esta em determinado [x][y]
    		 
    		 // Casa de saida nao vazia e dado diferente de  5 = jogada normal
    	
	    		 Tabuleiro.fundo = corEquipedaVez;
	    		 System.out.printf("entrou\n");
	    		 jogadaNormal = true;
	    		 Menu.b4.setEnabled(false);

    	 }
	    	 
	     else  if (roll != 5  && (Jogo.posicoes[1][6] == -1 && getEquipedaVez() == "Vermelho") ||
    		    	 (Jogo.posicoes[8][1] == -1 && getEquipedaVez() == "Verde" ) ||  (Jogo.posicoes[13][8] == -1 && getEquipedaVez() == "Amarelo" ) || 
	    			 (Jogo.posicoes[6][13] == -1 && getEquipedaVez() == "Azul")) {
	    	 
	    	 //caso dado diferente de 5 e pino fora da casa de saida =  jogada normal

	    	 Tabuleiro.fundo = corEquipedaVez;
	    	 int aux;

	    	 aux = checaPecaForaDaCasaInicial();

	    	 if (aux != -1) {
	    		 Menu.b4.setEnabled(false);
	    		 System.out.printf("Peca de indice %d da equipe %s fora da casa inicial\n",aux, getEquipedaVez());


	    	 }
	    	 
	    	  if (roll == 6 && tirou6 == 2) { // caso 3 x 6
	    		 contaSeis();
	    		 //ultimo peao movimentado volta para casa inicial
	    		 if (getEquipedaVez() == "Vermelho") {
	    			 
	    			 Tabuleiro.movepeao(Tabuleiro.times.elementAt(0).ultimoPinoMovimentado, 1, 6);
	    			 trocaTurno(); 
	    			 Menu.b4.setEnabled(true);
	    		 }
	    		 else if (getEquipedaVez() == "Verde") {
	    			 
	    			 Tabuleiro.movepeao(Tabuleiro.times.elementAt(1).ultimoPinoMovimentado, 8, 1);
	    			 trocaTurno(); 
	    			 Menu.b4.setEnabled(true);
	    		 }
	    		 else if (getEquipedaVez() == "Amarelo") {
	    			 
	    			 Tabuleiro.movepeao(Tabuleiro.times.elementAt(2).ultimoPinoMovimentado, 13, 8);
	    			 trocaTurno(); 
	    			 Menu.b4.setEnabled(true);
	    		 }
	    		 else if (getEquipedaVez() == "Azul") {
	 
					 Tabuleiro.movepeao(Tabuleiro.times.elementAt(3).ultimoPinoMovimentado, 6, 13);
					 trocaTurno(); 
					 Menu.b4.setEnabled(true);
	    		 } 
	    	 }
	    	 
	    	 
	    	 
	    	 else  if (roll != 6) { 
				Tabuleiro.fundo = corEquipedaVez;
				System.out.printf("--- Dado != 6  -- Jogada Normal \n");
				trocaTurno();
	    	 }
	     }
	     return roll;
	}
	
	public static int jogadaAutomatica(int dado) {
		
		int x = -1, y = -1;
		Vector<Peao> aux = null;

		if(getEquipedaVez() == "Vermelho") {
			
			x = 1;
			y = 6;
			aux = Tabuleiro.times.elementAt(0).peoes;
		}
		
		else if(getEquipedaVez() == "Verde") {
			
			x = 8;
			y = 1;
			aux = Tabuleiro.times.elementAt(1).peoes;
		}
		
		else if(getEquipedaVez() == "Amarelo") {
			
			x = 13;
			y = 8;
			aux = Tabuleiro.times.elementAt(2).peoes;
		}
		
		else if(getEquipedaVez() == "Azul") {
			
			x = 6;
			y = 13;
			aux = Tabuleiro.times.elementAt(3).peoes;
		}
		
		
		int indice = buscaPecaInicio(aux);
		
		if (posicoes[x][y] == -1 && indice != -1) {
			Tabuleiro.movepeca(aux, x, y, indice, roll);
			
			return 0;
		}
		if (indice == -1 )
			 System.out.printf("Todos os pinos ja estao no jogo\n"); 
		return -1;

	}
	
	//Faz um loop para o movimento automatico ver se tem peca que pode ir pra casa de saida
	
	private static int buscaPecaInicio(Vector<Peao> peca) {
		
		int [][]pecas = null;
		int indice = -1;
		
		if (getEquipedaVez() == "Vermelho")
			pecas = Tabuleiro.pinoIniVerm;
		
		else if (getEquipedaVez() == "Verde")
			pecas = Tabuleiro.pinoIniVerde;
		
		else if (getEquipedaVez() == "Amarelo")
			pecas = Tabuleiro.pinoIniAmar;
		
		else if (getEquipedaVez() == "Azul")
			pecas = Tabuleiro.pinoIniAzul;

		
		for (int i =0 ; i< 4; i++) {
			for (int j = 0; j<4; j++) {
				
				if (peca.elementAt(j).CoordX == pecas[i][0] 
						&&peca.elementAt(j).CoordY == pecas[i][1]){
		
					indice = j;
					System.out.printf("Indice da peca do inicio = %d\n", indice);
					return indice;
				}
				
			}
		}
		
		return -1;
		
	}
	

	private static int checaPecaForaDaCasaInicial() {
		
		
		int [][]inicial = null;
		
		
		if (getEquipedaVez() == "Vermelho") {
			
			inicial = Tabuleiro.pinoIniVerm;
		}
		
		else if (getEquipedaVez() == "Verde") {
			
			inicial = Tabuleiro.pinoIniVerde;
		}
		
		else if (getEquipedaVez() == "Amarelo") {
			
			inicial = Tabuleiro.pinoIniAmar;
		}
		
		else if (getEquipedaVez() == "Azul") {
			
			inicial = Tabuleiro.pinoIniAzul;
		}
		
		for (int i =0 ; i< 4; i++) {
			
				int aux1 = inicial[i][0];
				int aux2 = inicial[i][1];
			
			
				if (posicoes[aux1][aux2] == -1){ // posicao esta vazia
					//peca fora da casa inicial
					
					System.out.printf("chacaPecaFora %d %d = %d \n", aux1, aux2, i);
		
					return i;
					
				
			}
				
			
		}
		return -1;
		
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
	
	public static boolean contaSeis() {
		tirou6++;
		System.out.printf("Conta 6 = %d\n", tirou6);
		if(tirou6 == 3) {
			tirou6 = 0;
			return true;
		}
		return false;
	}
	

	public void passaVez() {
		trocaTurno();
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
