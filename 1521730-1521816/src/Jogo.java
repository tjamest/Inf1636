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

	public static int [][]casasDeSaida = {{1,6},{8,1},{13,8},{6,13}};
	
	public static int [][]casasDeAbrigo = {{6,1},{13,6},{8,13},{1,8}};
	
	public static int [][]casasDeBarreira = 
		{
			{0,6},{2,6},{3,6},{4,6},{5,6},{9,6},{10,6},{11,6},{12,6},{14,6},
			{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{9,7},{10,7},{11,7},{12,7},{13,7},{14,7}, 
			{0,8},{2,8},{3,8},{4,8},{5,8},{9,8},{10,8},{11,8},{12,8},{14,8}, 
			{6,0},{6,2},{6,3},{6,4},{6,5},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14}, 
			{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,9},{7,10},{7,11},{7,12},{7,13},{7,14},
			{8,0},{8,2},{8,3},{8,4},{8,5},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14}
		};
	
	public static Color []cores = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE};
	    	
	public static Peao[][] abrigo = new Peao[4][2];
	public static Peao[][] saida = new Peao[4][2];
	public static Peao[][] barreira = new Peao[64][2];

	//variaveis
	
	public static Color cor, c1, c2, corEquipedaVez;
	public static int ind, roll, IndiceTimeDaVez = 0, tirou6 = 0;
	public static boolean newgame = false, jogadaNormal = false, concluiuJogada = false,
			 selecionado = false ;
//	public static boolean ehAbrigo = false;

	
	//private static boolean active = true;
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		preencheMatrizes();
		newgame = true;
		corEquipedaVez = cores[IndiceTimeDaVez];
		
		
		//printMatrizPosicoes();
		
	}
	

	public void preencheMatrizes() {
		
		for (int i = 0 ; i<15; i++) {
			for (int j = 0 ; j<15 ; j++)
				posicoes[i][j] = -1;
		}	
		for (int i = 0 ; i<4; i++) {
			for (int j = 0 ; j<2 ; j++) {
				abrigo[i][j] = null;
				saida[i][j] = null;
			}	
		}
		for (int i = 0 ; i<64; i++) {
			for (int j = 0 ; j<2 ; j++) 
				barreira[i][j] = null;	
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

	
	
	
	
	// ---- CASOS COM MAIS DE 1 PECA NO MESMO LUGAR ----
	
	
	public int checaAbrigo(int x, int y, Peao peca) {
		
		int abr1 = 0;
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
				System.out.printf("--- ABR1 = %d \n ", abr1);
				
				if (abrigo [index][1] != null)
					return 2;
				
			}
		
			else {
				abrigo [index][1] = peca;
				abr1++;
				System.out.printf("--- ABR1 = %d \n ", abr1);
				if (abrigo [index][0] != null)
					return 2;
				
			}
		}
		return 0;
	}
	
	public void checa1PecaAbrigo(Peao peca) {
		for (int i = 0; i<4; i++) {
			
			if (abrigo [i][0] == peca) {
				
				if (abrigo [i][1] != null) { // tem algo em cima da peca 1
					
					abrigo[i][1].abrigo = false;
					abrigo[i][0] = null;
				}
			}
			else if (abrigo [i][1] == peca) {
					if (abrigo [i][0] != null) { // tirando 2 peca do vetor de abrigo
						
					abrigo[i][1] = null;
				}
			}
			
		}
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
	
	//falta caso em que a segunda peca vem de uma jogada automatica!!
	//falta checar se pelo menos 1 das pecas eh da cor da casa de saida
	
	public static int checaCasaDeSaida(int x, int y, Peao peca) {
		
		int sd = 0;
		int index = -1;
		
		//public static Peao[][] saida = new Peao[4][2];
		//public static int [][]casasDeAbrigo = {{6,1},{13,6},{8,13},{1,8}};
		
		for(int i=0;i<4;i++) {
			
			System.out.printf(" --  CASAS SAIDA [%d][%d]\n",casasDeSaida[i][0], casasDeSaida[i][1]);
			System.out.printf(" -- X [%d] Y[%d]\n",x, y);
			
			
			if(casasDeSaida[i][0] == x && casasDeSaida[i][1] == y) {
				index = i;
				break;
			}
			
		}
		if(index != -1 ) {
			
			if (saida [index][0] == null ) {
				System.out.printf("-- ENTROU 01 \n");
				saida [index][0] = peca;
				sd ++;
				System.out.printf("--- ABR1 = %d \n ", sd);
				
				if (saida [index][1] != null)
					return 2;
				
			}
		
			else {
				System.out.printf("-- ENTROU 02 \n");
				saida[index][1] = peca;
				sd++;
				System.out.printf("--- ABR1 = %d \n ", sd);
				if (saida [index][0] != null)
					return 2;
				
			}
		}
	
		
		return 0;
		
	}
	
	public void checa1Saida(Peao peca) {
		for (int i = 0; i<4; i++) {
			
			if (saida [i][0] == peca) {
				
				if (saida [i][1] != null) { // tem algo em cima da peca 1
					
					saida[i][1].saida = false;
					saida[i][0] = null;
				}
			}
			else if (saida[i][1] == peca) {
					if (saida [i][0] != null) { // tirando 2 peca do vetor de abrigo
						
					saida[i][1] = null;
				}
			}
			
		}
	}

	
	//falta caso em que uma das peças é diferente da anterior
	
	public static int checaBarreira(int x, int y, Peao peca) {
		
		//public static Peao[][] barreira = new Peao[64][2];
		
		int sb = 0;
		int index = -1;
		
		for (int i = 0; i<64; i++) {
			
			if (casasDeBarreira[i][0] == x && casasDeBarreira[i][1] == y ) {
				
				index = i;
				break;
			}
			
		}
		if(index != -1 ) {
			
			if (barreira [index][0] == null ) {
				System.out.printf("-- ENTROU 01 checa Barreira\n");
				barreira [index][0] = peca;
				sb ++;
				if (barreira [index][1] != null && barreira[index][1].corP == barreira[index][0].corP)
					return 2;
				else if (barreira [index][1] != null && barreira[index][1].corP != barreira[index][0].corP) {
					System.out.printf("-- Checa barreira, cor de baixo != da cor de cima\n");
					System.out.printf("-- Caso Captura\n");
					//peca que capturou pode andar 6
					Peao capturada = barreira [index][1];
					captura(x, y,peca , capturada);
				}
				
			}
		
			else {
				System.out.printf("-- ENTROU 02 checa Barreira\n");
				barreira[index][1] = peca;
				sb++;
				if (barreira [index][0] != null && barreira[index][0].corP == barreira[index][1].corP)
					return 2;
				else if (barreira [index][0] != null && barreira[index][0].corP != barreira[index][1].corP) {
					System.out.printf("-- Checa barreira, cor de cima != da cor de baixo\n");
					System.out.printf("-- Caso Captura\n");
					Peao capturada = barreira [index][0];
					captura(x, y,peca , capturada);
				}
				
			}
		}

		return 0;
	}
	
	public void checa1Barreira(Peao peca) {
		for (int i = 0; i<62; i++) {
			if (barreira [i][0] == peca) {
				if (barreira [i][1] != null) { // tem algo em cima da peca 1
					barreira[i][1].barreira = false;
					barreira[i][0] = null;
				}
			}
			else if (barreira[i][1] == peca) {
					if (barreira[i][0] != null) { // tirando 2 peca do vetor de abrigo
						barreira[i][1] = null;
				}
			}
		}
	}
	
	
	private static void captura(int x, int y, Peao peca, Peao capturada) {
		
		if (capturada.corP == Color.RED ) 
			Tabuleiro.movepeca(capturada, casasDeSaida[0][0], casasDeSaida[0][1], capturada.id,roll);
		else if (capturada.corP == Color.GREEN ) 
			Tabuleiro.movepeca(capturada, casasDeSaida[1][0], casasDeSaida[1][1], capturada.id,roll);
		else if (capturada.corP == Color.YELLOW ) 
			Tabuleiro.movepeca(capturada, casasDeSaida[2][0], casasDeSaida[2][1], capturada.id,roll);
		else if (capturada.corP == Color.BLUE) 
			Tabuleiro.movepeca(capturada, casasDeSaida[3][0], casasDeSaida[3][1], capturada.id,roll);
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
	
	public void primeiroClick ( int x, int y, Color color) {
		
		Menu.b4.setEnabled(false);
		System.out.printf("Peca selecionada = %d\n", ind);
		selecionado = true;
		cor = color;
		Movimentacao.MovimentacaoNormal(x,  y, roll, cor, ind);

	}
	
	
	public void segundoClick (int x, int y, int id) {
		
		int cA, cS, cB;
		Time time = Tabuleiro.times.elementAt(id);
		
		System.out.printf(" Classe JOGO - movendo para [%d][%d]\n",x, y);
		
		
		time.ultimoPinoMovimentado = time.peoes.elementAt(ind);

		
		cA = checaAbrigo(x,y, time.ultimoPinoMovimentado);
		
		System.out.printf("-- AUX CHECA ABRIGO = %d \n", cA);
		
		if (cA == 2) { // segundo pino na casa de abrigo
			//ehAbrigo = true;
			time.peoes.elementAt(ind).abrigo = true;
		}
		
		else if (cA == 0 && time.peoes.elementAt(ind).abrigo == true) {
			//ehAbrigo = false;
			time.peoes.elementAt(ind).abrigo = false;
			checa1PecaAbrigo(time.ultimoPinoMovimentado);
		}
		else //if (aux == 1)
			checa1PecaAbrigo(time.ultimoPinoMovimentado);
		
		cS = checaCasaDeSaida(x,  y, time.peoes.elementAt(ind)); //0 ou 2
		
		System.out.printf("-- AUX CHECA CASA DE SAIDA = %d \n", cA);
		
		if (cS == 2) {
			time.peoes.elementAt(ind).saida = true;
		}
		else if (cS == 0 && time.peoes.elementAt(ind).saida == true) { // movimenta peca de cima, muda tamanho
			time.peoes.elementAt(ind).saida = false;
			checa1Saida(time.ultimoPinoMovimentado);
		}
		else 
			checa1Saida(time.ultimoPinoMovimentado);
		
		cB = checaBarreira(x,  y, time.peoes.elementAt(ind));
		if (cB == 2) { // segundo pino na casa de barreira
			
			time.peoes.elementAt(ind).barreira = true;
		}
		else if (cA == 0 && time.peoes.elementAt(ind).barreira == true) {
			
			time.peoes.elementAt(ind).barreira= false;
			checa1Barreira(time.ultimoPinoMovimentado);
		}
		else 
			checa1Barreira(time.ultimoPinoMovimentado);
		
		
		
		//----------------------- 
		
		imprimeAbrigo();

		System.out.printf(" ---- PEAO %d EH ABRIGO = %s  \n",ind
				,Tabuleiro.times.elementAt(id).peoes.elementAt(ind).abrigo);
		
		movimento(Tabuleiro.times.elementAt(id).peoes.elementAt(ind), x, y, roll);
	
		
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
					System.out.printf("Tirou 6 do confere movimento\n");
				}
			}
		}	
	}
	
	
	//Logica da Movimentacao
	public static void movimento(Peao peca, int x, int y,int dado){
		System.out.printf("indice = %d\n", ind);
		Tabuleiro.movepeca(peca, x, y, ind, dado);
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
				    		System.out.printf("Tirou 6 do numero dado\n");
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
			
			int aux2 = checaCasaDeSaida(x,  y, aux.elementAt(indice)); //0 ou 2
			if (aux2 == 2) {
				aux.elementAt(indice).saida = true;
			}
	
			Tabuleiro.movepeca(aux.elementAt(indice), x, y, indice, roll);
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
		System.out.printf("FUNCAO Conta 6 = %d\n", tirou6);
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