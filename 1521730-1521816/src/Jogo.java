import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;


public class Jogo implements MouseListener {
	
	//matrizes e vetores
	public static int [][]posicoes= new int[15][15];
	public static int [][] abrigos = new int [4][2];
	public static int [][]casasDeSaida = {{1,6},{8,1},{13,8},{6,13}};
	public static int [][]casasDeAbrigo = {{6,1},{13,6},{8,13},{1,8}};
	public static Color []cores = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE};
	    	
	public static Peao[][] abrigo = new Peao[4][2];

	//variaveis
	public static boolean newgame = false;
	public boolean  selecionado = false;
	public static Color cor;
	public static int ind, roll;
	public static boolean jogadaNormal = false;
	public static boolean concluiuJogada = false;
	public static boolean ehAbrigo = false;
	public static Color c1, c2;
	public static int abrigoX1, abrigoX2, abrigoY1, abrigoY2;
	public static int IndiceTimeDaVez = 0;
	
	
	//private static boolean active = true;
	public static int tirou6 = 0;
	public static Color corEquipedaVez;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		preencheMatrizPosicoes();
		newgame = true;
		corEquipedaVez = cores[IndiceTimeDaVez];
		
		
		//printMatrizPosicoes();
		
	}
	

	public void preencheMatrizPosicoes() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++)
				posicoes[i][j] = -1;
		}	
		for (int i = 0 ; i<4; i++) {
			for (int j = 0 ; j<2 ; j++)
				abrigo[i][j] = null;
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
	
	public int checaAbrigo(int x, int y, Peao peca) {
		
		int abr1 = 0, abr2 = 0, abr3 = 0, abr4 = 0;
		int index = -1;
		
		//public static Peao[][] abrigo = new Peao[4][2];
		//public static int [][]casasDeAbrigo = {{6,1},{13,6},{8,13},{1,8}};
		
		for(int i=0;i<4;i++) {
			
			System.out.printf(" --  CASAS ABRIGO [%d][%d]\n",casasDeAbrigo[i][0], casasDeAbrigo[i][1]);
			System.out.printf(" -- X [%d] Y[%d]\n",x, y);
			
			
			if(casasDeAbrigo[i][0] == x && casasDeAbrigo[i][1] == y) {
				index = i;
				break;
			}
			
		}
		
		if(index != -1 ) {
			
			if (abrigo [index][0] == null && abr1 == 0) {
				
				abrigo [index][0] = peca;
				abr1 ++;	
				
			}
		
			else {
				abrigo [index][1] = peca;
				abr1++;
				return 2;
			}
		}
		return 0;
	}
		
	
	
	
	
	// criar funcao que pega x e y antigo da peca
	// rodar o vetor de abrigo
	// ver tem algo no [0][1]
	//fazer a peca do [0][1] como eh abrigo == false
	
	
	public void checa1PecaAbrigo(Peao peca) {
		
//		int oldX, oldY;
//		
//		oldX = peca.CoordX;
//		oldY = peca.CoordY;
//		
		for (int i = 0; i<4; i++) {
			
			if (abrigo [i][0] == peca) {
				
				if (abrigo [i][1] != null) { // tem algo em cima da peca 1
					
					abrigo[i][1].abrigo = false;
				}
			}	
		}
	}
	
	public void primeiroClick ( int x, int y, Color color) {
		
		Menu.b4.setEnabled(false);
		System.out.printf("Peca selecionada = %d\n", ind);
		selecionado = true;
		cor = color;
		Movimentacao.MovimentacaoNormal(x,  y, roll, cor, ind);

	}
	
	public void imprimeAbrigo () {
		System.out.printf(" -- IMPRIME CASAS DE ABRIGO --\n");
		
		for(int i=0;i<4;i++) {
			
			if (abrigo[i][0] != null )
				System.out.printf(" -- posicao 1: %s \n",abrigo[i][0].corP );
			if ( abrigo[i][1] != null) 
				System.out.printf(" -- posicao 2: %s \n",abrigo[i][1].corP);
			

		}
	}
	
	
	
	public void segundoClick (int x, int y, int id) {
		
		int aux;
		
		System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
		
		
		Tabuleiro.times.elementAt(id).ultimoPinoMovimentado = Tabuleiro.times.elementAt(id).peoes.elementAt(ind);

		
		aux = checaAbrigo(x,y, Tabuleiro.times.elementAt(id).ultimoPinoMovimentado);
		
		System.out.printf("-- AUX = %d \n", aux);
		

		if (aux == 2) { // segundo pino na casa de abrigo
			ehAbrigo = true;
			Tabuleiro.times.elementAt(id).peoes.elementAt(ind).abrigo = true;
		}
		
		else if (aux == 0 && Tabuleiro.times.elementAt(id).peoes.elementAt(ind).abrigo == true) {
			ehAbrigo = false;
			Tabuleiro.times.elementAt(id).peoes.elementAt(ind).abrigo = false;
		}
		else if (aux != 0)
			checa1PecaAbrigo(Tabuleiro.times.elementAt(id).ultimoPinoMovimentado);
		
		imprimeAbrigo();

		System.out.printf(" ---- PEAO %d EH ABRIGO = %s  \n",ind
				,Tabuleiro.times.elementAt(id).peoes.elementAt(ind).abrigo);
		
		movimento(Tabuleiro.times.elementAt(id).peoes.elementAt(ind), x, y, roll, ehAbrigo);
	
		
		System.out.printf("-- Classe Jogo - ultimo peao movimentado tem indice %d\n", Tabuleiro.times.elementAt(id).peoes.elementAt(ind).id);
		Menu.b4.setEnabled(true);
		concluiuJogada = true;
		
	}
	
	private static int transformaInt(String s){
		
		if (s == "Vermelho")
			return 0;
		else if (s == "Verde")
			return 1;
		else if (s == "Amarelo")
			return 2;
		else if (s == "Azul")
			return 3;
		else {
			System.out.printf(" -- Deu ruim borracha no transforma int \n --");
			return -1;

		}
	
	}


	//---- MOVIMENTACAO ----
	protected void confereMovimento(int x, int y) {
		
		if (selecionado == false ) { //ainda nao selecionou peca para mover
			System.out.printf("Selecionando Peca \n"); 
			System.out.printf("Equipe da vez = %s  \n", getEquipedaVez());
			
			int vez = transformaInt(getEquipedaVez());
			if( vez != -1){
				ind = pecaSelecionada(Tabuleiro.times.elementAt(vez).peoes,  x, y);
				if (ind != -1)
					primeiroClick (x, y, Tabuleiro.times.elementAt(vez).peoes.elementAt(ind).corP);
				else {
					selecionado = false;
					System.out.printf(" ----------  Nenhuma Peca selecionada ----------- \n");
				}
			}
		}else { // ja tem peca selecionada para mover
			int passar;

			if (cor == Color.RED ) 
				passar = 0;
			else if (cor == Color.GREEN ) 
				passar = 1;
			else if (cor == Color.YELLOW) 
				passar = 2;
			else if (cor == Color.BLUE) 
				passar = 3;
			else {
				System.out.printf(" ----------  Movimento Invalido ----------- \n");
				passar = -1;
			}
			if(passar != -1){
				System.out.printf(" X = %d e Y = %d\n", x,y);
				if (Movimentacao.casaX == x  && Movimentacao.casaY == y)
					segundoClick (x, y, passar);
			}
			selecionado = false; 
			jogadaNormal = false;
			if(concluiuJogada){
				if (roll != 6) {
					System.out.printf("Troca turno jogo\n");
					trocaTurno();
					concluiuJogada = false;
				}
				else if (tirou6 < 2) { // && tem peca na casa de saida ou fora do jogo
					contaSeis();
				}
			}
		}	
	}
	
	
	//Logica da Movimentacao
	public static void movimento(Peao peca, int x, int y,int dado, boolean a){
		System.out.printf("indice = %d\n", ind);
		Tabuleiro.movepeca(peca, x, y, ind, dado, a);
	}

	//Retorna indice de peca selecionada
	public static int pecaSelecionada(Vector<Peao> peca, int x, int y) {
		
		for (int i =0 ; i< 4; i++) {
			if (peca.elementAt(i).CoordX == x 
					&& peca.elementAt(i).CoordY == y){
				//System.out.printf("Peca selecionada = %d\n", ind);
				return i;
			}	
		}
		
		return -1;
	}	

	// -- DADO --
	public static int numeroDado(int n) {
		//roll = 0;
		//roll = (int)(Math.random()*6+1);
		roll = n;
		int i = transformaInt(getEquipedaVez());
	    System.out.printf("valor tirado eh %d e time  %s\n", roll, getEquipedaVez() ); 
	    if(i != -1){
	    	Tabuleiro.fundo = corEquipedaVez;

	    	if(posicoes[ casasDeSaida[i][0] ][ casasDeSaida[i][1] ] != -1 /*&& !ConfereSePossivelSairDoComeco()*/){
	    	 	Tabuleiro.fundo = corEquipedaVez;
			    System.out.printf("entrou\n");
			    jogadaNormal = true;
			    Menu.b4.setEnabled(false);
	    	}else{
	    		int aux;
	    		if(roll == 5)
	    			aux = jogadaAutomatica(i);
	    		else
	    			aux = checaPecaForaDaCasaInicial();
	    		if(aux != -1){
	    			//nao deu erro em nenhum dos dois casos
	    			if(roll == 5){
	    		 		Tabuleiro.fundo = corEquipedaVez;
	    		 		trocaTurno(); 
	    			}else{
						Menu.b4.setEnabled(false);
	    				System.out.printf("Peca de indice %d da equipe %s fora da casa inicial\n",aux, getEquipedaVez());
	    		 
			    		if (roll == 6 && tirou6 != 2) // caso 3 x 6
				    		contaSeis();
				    	else if(roll == 6 && tirou6 == 2){
				    		contaSeis();
				    		caso3Seis(i);
				    	}
	    			}
	    		}else{ 
					Tabuleiro.fundo = corEquipedaVez;
					System.out.printf("--- Dado != 5 ecasa de saida vazia  -- Troca turno\n");//mudar este debug
					trocaTurno();
		    	 }
	    	}
	    }else{
			System.out.printf("--- DEU RUIM NO TRANSFORMA INT\n");
	    }
	     
	    return roll;
	}
	
	
	
	public static void caso3Seis(int i) {
		Tabuleiro.movepeao(Tabuleiro.times.elementAt(i).ultimoPinoMovimentado, casasDeSaida[i][0], casasDeSaida[i][1]);
		trocaTurno(); 
		Menu.b4.setEnabled(true);
	}
	
	public static int jogadaAutomatica(int i) {
		
		int x = casasDeSaida[i][0], y = casasDeSaida[i][1];
		Vector<Peao> aux = Tabuleiro.times.elementAt(i).peoes;
		
		int indice = buscaPecaInicio(aux);
		
		if (indice != -1) {
			Tabuleiro.movepeca(aux.elementAt(indice), x, y, indice, roll, ehAbrigo);
			return 0;
		}
		if (indice == -1 )
			 System.out.printf("Todos os pinos ja estao no jogo\n"); 
		return -1;

	}
	
	//Faz um loop para o movimento automatico ver se tem peca que pode ir pra casa de saida
	
	private static int buscaPecaInicio(Vector<Peao> peca) {
		
		int [][]pecas = null;
		
		
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
					System.out.printf("Indice da peca do inicio = %d\n", j);
					return j;
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
	
	
	
	
	// private static String getTime(int x, int y) {
		
	// 	for (int i = 0; i< 4; i++) {
	// 		if (Tabuleiro.times.elementAt(0).peoes.elementAt(i).CoordX == x && Tabuleiro.times.elementAt(0).peoes.elementAt(i).CoordY == y) {
	// 			return "Vermelho";
	// 		}
	// 		else if (Tabuleiro.times.elementAt(1).peoes.elementAt(i).CoordX == x && Tabuleiro.times.elementAt(1).peoes.elementAt(i).CoordY == y) {
	// 			return "Verde";
	// 		}
	// 		else if (Tabuleiro.times.elementAt(2).peoes.elementAt(i).CoordX == x && Tabuleiro.times.elementAt(2).peoes.elementAt(i).CoordY == y) {
	// 			return "Amarelo";
	// 		}
	// 		else if (Tabuleiro.times.elementAt(3).peoes.elementAt(i).CoordX == x && Tabuleiro.times.elementAt(3).peoes.elementAt(i).CoordY == y) {
	// 			return "Azul";
	// 		}			
	// 	}
	// 	return "";
	// }
	
	
	
	
	
	
	
	// -- TURNO --
	
	public static void trocaTurno() {
		tirou6 = 0;
		IndiceTimeDaVez++;
		if(IndiceTimeDaVez == 4)
			IndiceTimeDaVez = 0;
		corEquipedaVez = cores[IndiceTimeDaVez];
	}
	
	public static String getEquipedaVez() {
		// se der para por string como NULL retornar cor se nao nao alterar
		String cor = "";
		if(IndiceTimeDaVez == 2)
			cor = "Amarelo";
		else if(IndiceTimeDaVez == 3)
			cor = "Azul";
		else if(IndiceTimeDaVez == 0)
			cor = "Vermelho";
		else if(IndiceTimeDaVez == 1)
			cor = "Verde";
		if(cor != "")
			return cor;
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
	//Getter & setter


}