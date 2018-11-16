
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



  se peao na casa de virada e andar!= 0{
    se casaAtual == casaDeVirada
      se casaAtual == [6][6] { // x permanece o mesmo, anda em y
        int y = 6 - andar (que é o que falta do tirar do dado)
        movimento = [6][y]
      }

      se casaAtual == [6][0] { // y permanece o mesmo, anda em x
        int x = 6 + andar (que é o que falta do tirar do dado)
        movimento = [x][0]
      }

      se casaAtual == [8][0] { // x permanece o mesmo, anda em y
        int y = 0 + andar (que é o que falta do tirar do dado)
        movimento = [8][y]
      }

      se casaAtual == [8][6] { // y permanece o mesmo, anda em x
        int x = 8 + andar (que é o que falta do tirar do dado)
        movimento = [x][6]
      }
      se casaAtual == [14][6] { // x permanece o mesmo, anda em y
        int y = 6 + andar (que é o que falta do tirar do dado)
        movimento = [14][y]
      }
      se casaAtual == [14][8] { // y permanece o mesmo, anda em x
        int x = 14 - andar (que é o que falta do tirar do dado)
        movimento = [x][8]
      }
      se casaAtual == [8][8] { // x permanece o mesmo, anda em y
        int y = 8 + andar (que é o que falta do tirar do dado)
        movimento = [8][y]
      }
      se casaAtual == [8][14] { // y permanece o mesmo, anda em x
        int x = 8 - andar (que é o que falta do tirar do dado)
        movimento = [x][14]
      }
      se casaAtual == [6][14] { // x permanece o mesmo, anda em y
        int y = 14 - andar (que é o que falta do tirar do dado)
        movimento = [6][y]
      }
      se casaAtual == [6][8] { // y permanece o mesmo, anda em x
        int x = 6 - andar (que é o que falta do tirar do dado)
        movimento = [x][8]
      }
      se casaAtual == [0][8] { // x permanece o mesmo, anda em y
        int y = 8 - andar (que é o que falta do tirar do dado)
        movimento = [0][y]
      }
      se casaAtual == [0][6] { // y permanece o mesmo, anda em x
        int x = 0 + andar (que é o que falta do tirar do dado)
        movimento = [x][6]
      }
  } else { //movimento normal

			se casaAtual.x < 6 && casaAtual.y == 6 { // anda em x normal
				int x = casaAtual.x + andar
				movimento = [x][6]
			}
			se casaAtual.x == 6 && casaAtual.y > 0 && casaAtual.y < 6 { // anda em y normal
				int y = casaAtual.y - andar
				movimento = [6][y]
			 }
			se casaAtual.x == 7 && casaAtual.y == 0  { // anda em x normal
				int x = casaAtual.y + andar
				movimento = [x][0]
			}
			se casaAtual.x == 8 && casaAtual.y > 0 && casaAtual.y < 6 { // anda em y normal
				int y = casaAtual.y + andar
				movimento = [8][y]
			}
			se casaAtual.x < 14 && casaAtual.x > 8 && casaAtual.y == 6 { // anda em x normal
				int x = casaAtual.x + andar
				movimento = [x][6]
			}
			se casaAtual.x == 14 && casaAtual.y == 7  { // anda em y normal
				int y = casaAtual.y + andar
				movimento = [14][y]
			}
			se casaAtual.x < 14 && casaAtual.x > 8 && casaAtual.y == 8 { // anda em x normal
				int x = casaAtual.x - andar
				movimento = [x][8]
			}
			se casaAtual.x == 8 && casaAtual.y > 8 && casaAtual.y < 14 { // anda em y normal
				int y = casaAtual.y + andar
				movimento = [8][y]
			}
			se casaAtual.x == 7 && casaAtual.y == 14  { // anda em x normal
				int x = casaAtual.x - andar
				movimento = [14][y]
			}
			se casaAtual.x == 6 && casaAtual.y > 8 && casaAtual.y < 14 { // anda em y normal
				int y = casaAtual.y + andar
				movimento = [8][y]
			}
			se casaAtual.x < 6 && casaAtual.x > 0 && casaAtual.y == 8 { // anda em x normal
        			int x = casaAtual.x - andar
       				 movimento = [x][8]
      			}
			se casaAtual.x == 0 && casaAtual.y == 7  { // anda em y normal
				int y = casaAtual.y - andar
				movimento = [0][y]
			}

  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
