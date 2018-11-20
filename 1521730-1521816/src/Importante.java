
public @interface Importante {
	
	/*
	
	Posicoes iniciais pecas vermelhas = [1][1], [1][4], [4][1], [4][4]
	Posicoes iniciais pecas azuis = [1][10], [1][13], [4][10], [4][13]
	Posicoes iniciais pecas verdes = [10][1], [13][1], [10][4], [13][4]
	Posicoes iniciais pecas Amarelas = [10][10], [13][10], [10][13], [13][13]
	
	
	Posicoes casa saida:
		Vermelho = [1][6]
		Verde = [8][1]
		Amarelo = [13][8]
		Azul = [6][13]
		
	Posicoes que podem ter barreiras:
		[0][6], [2][6], [3][6], [4][6], [5][6], [9][6], [10][6], [11][6], [12][6], [14][6]
		
		[0][7],[1][7],[2][7], [3][7], [4][7], [5][7], [9][7], [10][7], [11][7], [12][6], [13][6], [14][6]
	
		[0][8], [2][8], [3][8], [4][8], [5][8], [9][8], [10][8], [11][8], [12][8], [14][8]
		
		[6][0], [6][2], [6][3], [6][4], [6][5], [6][9],[6][10], [6][11], [6][12],[6][14]
		
		[7][0], [7][1], [7][2], [7][3], [7][4], [7][5], [7][9], [7][10], [7][11], [7][12], [7][13], [7][14]
		 
		[8][0], [8][2], [8][3], [8][4], [8][5], [8][9],[8][10], [8][11], [8][12],[8][14]  
		
	
	
	Jogador s� escolher� a peca a ser movimentada caso n�o seja poss�vel posicionar o peao na casa de saida
	Caso jogador tire 6 e tiver uma barreira formada com seus peoes, ela dever� ser desfeita. Caso exista 2 barreiras, 
	 � desfeita aquela mais perto da chegada.
	
	
	
	
	
	REGRAS E MOVIMENTACAO:
	
		FEITO:
			- Jogada autom�tica de quando se � retirado 5 no dado
			- N�o mudar o turno ao retirar 6 no dado
			
			
		
		
		FALTA FAZER:
		
			- Fazer regra caso se tire 3x 6 no dado: o ultimo peao movimentado volta para a casa inicial.
			
			- Fazer caso no qual duas pecas do mesmo jogador ocupam a mesma casa (barreira)
			- Fazer caso no qual dois peoes diferentes ocupam a mesma casa (abrigo ou inicial)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 if ((posicoes[1][6] != -1) || (posicoes[1][1] == -1 && posicoes[1][4] == -1 && posicoes[4][1] == -1 && posicoes[4][4] == -1)) { 
						//caso casa saida vazia e sem peca pra sair
						//Tabuleiro.movepeca(Tabuleiro.pecasVerm, 1+roll, 6, ind, roll);
						 Tabuleiro.movepeca(Tabuleiro.pecasVerm, x, y, ind, roll);
					}
	
	
	
	
	
	
	 if (roll == 5 && posicoes[1][6] != -1 ) { // existe pino na casa de saida e foi retirado um 5
					 
						 for (int i =0 ; i< 4; i++) {
								
								if ((int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordX/40) == 1 
										&& (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(i).CoordY/40)== 6){
									
									ind = i;
									System.out.printf("Peca selecionada = %d\n", ind);
								}	
							}
						 
						 Tabuleiro.movepeca(Tabuleiro.pecasVerm, (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(ind).CoordX/40) +roll,
								 (int)Math.ceil(Tabuleiro.pecasVerm.elementAt(ind).CoordY/40), ind, roll);
					 
					 }
	
	
	
	
	
	*/

}
