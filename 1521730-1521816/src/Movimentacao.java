import java.awt.Color;

public class Movimentacao {
	
	static int casaX, casaY;
	
	static int[][] caminhoVermelho = {{1, 7}, {2, 7},{3, 7},{4, 7},{5, 7}};
	static int[][] caminhoVerde = {{7, 1}, {7, 2},{7, 3},{7, 4},{7, 5}};
	static int[][] caminhoAmarelo = {{13, 7}, {12, 7},{11, 7},{10, 7},{9, 7}};
	static int[][] caminhoAzul = {{7, 13}, {7, 12},{7, 11},{7, 10},{7, 9}};
	
	public Movimentacao() {
		
	}
	
	public static void MovimentacaoNormal(int x, int y, int roll, Color cor, int indice) { //mandar cor da peca
		
		//Caminho branco

		int auxX = x;
		int auxY = y;
		int z = -1 ;

		for (int i = 0 ; i<roll; i++) {

			if (auxX < 5 && auxY == 6 && z!= i) {	
				auxX += 1;
				z ++;
			}
			
			else if (auxX == 5 && auxY == 6 && z!= i) {
				//casa de virada [5][6], anda em y 
				
				auxX = 6;
				auxY -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY > 0 && auxY < 6  &&  z!= i) {	
				
				auxY -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY > 0 && auxY < 6  &&  z!= i) {	
				
				auxY -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY == 0 && z!= i) { 
				//casa de virada [6][0], anda em x 
				
				auxX += 1;
				auxY = 0;
				z ++;
			}
			else if (auxX == 7 && auxY == 0 && z!= i) { 
				//casa de virada [7][0] para pecas verdes, anda em y
				
				//caso peca for verde {}
				//else
				auxX += 1;
				auxY = 0;
				z ++;
			}
			else if (auxX == 8 && auxY >= 0 && auxY < 5 && z!= i) { 
				//casa de virada [8][0], anda em y
				//+ caminho ate casa [8][5]
				auxY += 1;
				z++;
				
			}
			else if (auxX == 8 && auxY == 5 && z!= i) { 
				//casa de virada [8][5], anda em x
				
				auxX += 1;
				auxY = 6;
				z ++;
			}
			else if (auxX >= 9 && auxX <14 && auxY == 6 && z!= i) { 
				auxX += 1;
				z ++;
			}
			else if (auxX == 14 && auxY == 6 && z!= i) { 
				//casa de virada [14][6] , anda em y
				auxY += 1;
				z ++;
			}
			else if (auxX == 14 && auxY == 7 && z!= i) { 
				//casa de virada [14][7] para pecas amarelas , anda em x
				//caso peca for amarela {}
				//else
				auxY += 1;
				z ++;
			}
			else if (auxX <= 14 && auxX > 9 && auxY == 8 && z!= i) { 
				//casa de virada [14][8], anda em x
				//+ caminho ate casa [9][8]
				auxX -= 1;
				z ++;
			}
			else if (auxX == 9 && auxY == 8 && z!= i) { 
				//casa de virada [9][8], anda em y
				auxX = 8;
				auxY += 1;
				z ++;
			}
			else if (auxX == 8 && auxY >= 9 && auxY < 14 && z!= i) { 
				
				auxY += 1;
				z ++;
			}
			else if (auxX == 8 && auxY == 14 && z!= i) { 
				//casa de virada [8][14] , anda em x
				auxX -= 1;
				z ++;
			}
			else if (auxX == 7 && auxY == 14 && z!= i) { 
				//casa de virada [7][14] para pecas azuis , anda em y
				//caso peca for azul{}
				//else
				auxX -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY == 14 && z!= i) { 
				//casa de virada [6][14], anda em y
				
				auxY -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY <= 14 && auxY > 9 && z!= i) { 
	
				auxY -= 1;
				z ++;
			}
			else if (auxX == 6 && auxY == 9 && z!= i) { 
				//casa de virada [6][9], anda em x
				
				auxX -= 1;
				auxY = 8;
				z ++;
			}
			else if (auxX <= 5 && auxX > 0 && auxY == 8 && z!= i) { 
				
				auxX -= 1;
				z ++;
			}
			else if (auxX == 0 && auxY == 8 && z!= i) { 
				//casa de virada [0][8], anda em y
				
				auxY -= 1;
				z ++;
			}
			else if (auxX == 0 && auxY == 7 && z!= i ) { 
				//casa de virada [0][7] para pecas vermelhas , anda em x
				//caso peca for vermelha
				
				if (cor == Color.RED) {
					auxX += 1;
					z++;
				}
				else {
					auxY -= 1;
					z ++;
				}
			}
			
			
			//Casos caminhos coloridos
			
			//Caso caminho Vermelho
			//static int[][] caminhoVermelho = {{1, 7}, {2, 7},{3, 7},{4, 7},{5, 7}};
			
			else if (auxX > 0 && auxX < 6 && auxY == 7 && z!= i && cor == Color.RED) {
				
				auxX += 1;
				z++;
				
			}
			else if (auxX == 6 && auxY == 7 && z!= i && cor == Color.RED) {
				
				System.out.printf("Peca Vermelha de indice = %d chegou na casa final \n", indice);
				System.out.printf("Escolha outra peca para mover \n", indice);
				z++;
			}
			
			//Caso caminho Verde
			//static int[][] caminhoVerde = {{7, 1}, {7, 2},{7, 3},{7, 4},{7, 5}};
			
			//Caso caminho Amarelo
			//static int[][] caminhoAmarelo = {{13, 7}, {12, 7},{11, 7},{10, 7},{9, 7}};
			
			//Caso caminho Azul
			//static int[][] caminhoAzul = {{7, 13}, {7, 12},{7, 11},{7, 10},{7, 9}};
			
			
			
			
			
			
			
			
			
			
			
			

		}
		
		casaX = auxX;
		casaY = auxY;
		
		System.out.printf(" Classe Movimentacao - mover para [%d][%d]\n", casaX, casaY );
	
	}//fim movimenntacao normal

	
//	public static void MovimentacaoColorida(int x, int y, int roll, Color cor) {
//		
//		int auxX = x;
//		int auxY = y;
//		int z = -1 ;
//		
//		if (cor == Color.RED) { //peca vermelha deve ir pro caminho colorido
//			//static int[][] caminhoVermelho = {{1, 7}, {2, 7},{3, 7},{4, 7},{5, 7}};
//			
//			for (int i = 0 ; i<roll; i++) {
//				
//				if (auxX == 0 && auxY == 7 && z!= i) { //movimenta em x
//					
//					auxX += 1;
//					z++;
//				}
//			}
//		}
//		
//		casaX = auxX;
//		casaY = auxY;
//		
//		System.out.printf(" Classe Movimentacao - Caminho Colorido - mover para [%d][%d]\n", casaX, casaY );
//	
//	}//fim movimentacao colorida
	

	


}//fim classe movimentacao

		
	
	