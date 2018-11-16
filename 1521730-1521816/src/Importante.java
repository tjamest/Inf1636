
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
		
	Casas de Virada: (Pino vai para o triangulo ou so para a casa branca?)
	[0][6]
	[6][6] //triangulo
	[6][0]
	[8][0]
	[8][6] //triangulo
	[14][6]
	[14][8]
	[8][8] //triangulo
	[8][14]
	[6][14]
	[6][8] //triangulo
	[0][8]
	
	
	
	
	Jogador só escolherá a peca a ser movimentada caso não seja possível posicionar o peao na casa de saida
	Caso jogador tire 6 e tiver uma barreira formada com seus peoes, ela deverá ser desfeita. Caso exista 2 barreiras, 
	 é desfeita aquela mais perto da chegada.
	
	
	
	
	
	REGRAS E MOVIMENTACAO:
	
		FEITO:
			- Jogada automática de quando se é retirado 5 no dado
			- Não mudar o turno ao retirar 6 no dado
			
			
		
		
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
