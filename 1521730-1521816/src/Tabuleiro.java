import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro extends JPanel   {
	
	private static Image dado;
	int resp = 0;
	static Graphics2D g2d;
	static int roll = 0;
	Color fundo;

	private static final long serialVersionUID = -4264416327199530488L;
	
	public static  Color LIGHT_BLUE = new Color(51,153,255);
	public static  Color DARK_YELLOW = new Color(255,204,51);
	public static  Color DARK_GREEN = new Color(0, 204, 0);
	public static  Color DARK_RED = new Color(204, 0, 0);
	
	//vetor de pecas
	static  Vector<Peao> pecasVerm = new Vector<Peao>();
	static Vector<Peao> pecasAzul = new Vector<Peao>();
	static Vector<Peao> pecasVerde = new Vector<Peao>();
	static Vector<Peao> pecasAma = new Vector<Peao>();
	
	
	//posicoes iniciais pino (vetor com posicoes de desenho do pino no inicio do jogo)
	static int[][] pinoIniVerm = {{50, 50}, {170, 50}, {50, 170}, {170, 170}};
	static int[][] pinoIniAzul = {{50, 410}, {170, 410}, {50, 530}, {170, 530}};
	static int[][] pinoIniVerde = {{410, 50}, {530, 50}, {410, 170}, {530, 170}};
	static int[][] pinoIniAmar = {{410, 410}, {530, 410}, {410, 530}, {530, 530}};
	
	//posicoes elipses (vetor com posicoes do desenho das elipses bancas)
	static int[][] elipsesVerm = {{40, 40}, {160, 40}, {40, 160}, {160, 160}};
	static int[][] elipsesAzul = {{40, 400}, {160, 400}, {40, 520}, {160, 520}};
	static int[][] elipsesVerde = {{400, 40}, {520, 40}, {400, 160}, {520, 160}};
	static int[][] elipsesAma = {{400, 400}, {520, 400}, {400, 520}, {520, 520}};
	
	//Vetor com todos os nomes das imagens dos dados
	private static String[] images = {"Dado1.png", "Dado2.png", "Dado3.png", "Dado4.png", "Dado5.png", "Dado6.png"};
	

	public Tabuleiro() {
		
    	setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        new Menu();
        
        this.add(Menu.b1);
        this.add(Menu.b2);
        this.add(Menu.b3);
        this.add(Menu.b4);
        this.add(Menu.turno);
        
        Menu.b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        addMouseListener(new Jogo());  //mouse
			}
		});
        
        Menu.b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				roll = Jogo.numeroDado();
			    dado = new ImageIcon(this.getClass().getResource(images[roll-1])).getImage();
			    fundo = Jogo.corEquipedaVez;
			    if (roll != 6 && Jogo.tirou6 == 0 )
			    	Jogo.trocaTurno();
			    else if (Jogo.tirou6 == 3)
			    	Jogo.trocaTurno();
			    
			}
		});
        
    }

	public void paintComponent(Graphics g) {
		
		repaint();
		
    	super.paintComponent(g);
    	
    	g2d = (Graphics2D) g;
    	
    	DrawBoard(g2d);
    	DrawRectangle(g2d);
    	DrawQuadradosColoridos(g2d);
 
    	if (Jogo.newgame == true) {
    		
    		iniciaVetorPecas();
    		desenhaPinos();
    		repaint();
    	}

	}


	private static void desenhaPinos() {
		for (int i = 0; i < 4 ; i ++) {	
			
			DrawPino(g2d, pecasVerm.elementAt(i).CoordX,  pecasVerm.elementAt(i).CoordY, Color.RED);
			Jogo.posicoes[(int) Math.ceil(pecasVerm.elementAt(i).CoordX/40)][(int) Math.ceil(pecasVerm.elementAt(i).CoordY/40)] = i;
			
			DrawPino(g2d, pecasAzul.elementAt(i).CoordX,  pecasAzul.elementAt(i).CoordY, Color.BLUE);
			Jogo.posicoes[(int) Math.ceil(pecasAzul.elementAt(i).CoordX/40)][(int) Math.ceil(pecasAzul.elementAt(i).CoordY/40)] = i;
			
			DrawPino(g2d, pecasVerde.elementAt(i).CoordX,  pecasVerde.elementAt(i).CoordY, Color.GREEN);
			Jogo.posicoes[(int) Math.ceil(pecasVerde.elementAt(i).CoordX/40)][(int) Math.ceil(pecasVerde.elementAt(i).CoordY/40)] = i;
			
			DrawPino(g2d, pecasAma.elementAt(i).CoordX,  pecasAma.elementAt(i).CoordY, Color.YELLOW);	
			Jogo.posicoes[(int) Math.ceil(pecasAma.elementAt(i).CoordY/40)][(int) Math.ceil(pecasAma.elementAt(i).CoordY/40)] = i;
		}
		//System.out.printf("CONFERE MOVIMENTO APOS INCLUSAO PECAS CARAI\n");
		
	}
	
	public static void movepeca(Vector<Peao> peca, int x, int y, int index, int dado) {
		
		int oldX = (int) Math.ceil(peca.elementAt(index).CoordX/40);
		int oldY = (int) Math.ceil(peca.elementAt(index).CoordY/40);
		
		peca.elementAt(index).CoordX = (x * 40) + 10;
		peca.elementAt(index).CoordY = (y * 40) + 10;

		Jogo.posicoes[oldX][oldY] = -1;

		desenhaPinos();
		
		//Jogo.printConfereMovimento();
		
		
	
	}
	

	private void iniciaVetorPecas() {
		
		for (int i = 0; i < 4 ; i ++){
			pecasVerm.add(new Peao(Color.RED, pinoIniVerm [i][0], pinoIniVerm [i][1], i));
			pecasAzul.add(new Peao(Color.BLUE, pinoIniAzul [i][0], pinoIniAzul [i][1], i));
			pecasVerde.add(new Peao(Color.GREEN,  pinoIniVerde [i][0],  pinoIniVerde [i][1], i));
			pecasAma.add(new Peao(Color.YELLOW,  pinoIniAmar [i][0],  pinoIniAmar [i][1], i));
		}
	}


	
	private void DrawBoard(Graphics2D g2d) {
		
		
		for(int a = 0; a < 15; a++){
			   for(int b = 0; b < 15; b++){
				   
				  //----- SET COLOR PARA QUADRADOS COLORIDOS -----// 
		
				   if(b>5 && b < 9) { 
					   if(a<=5) {
						   
						   g2d.setColor(Tabuleiro.DARK_GREEN);
						   
					   }
					   else if(a>8) {
						   
						   g2d.setColor(Tabuleiro.LIGHT_BLUE);
						   
					   }
					   
				   	}
				   
				   else if(b<=5){
					   
					   g2d.setColor(Tabuleiro.DARK_RED);
					   
				   }
				   else if(b>8) {
					   
					   g2d.setColor(Tabuleiro.DARK_YELLOW);
					   
				   }
				   
				 //----- DESENHA OS PRIMEIROS QUADRADOS COLORIDOS E AS SETINHAS DE DENTRO -----// 
				   
				   if ((a == 6 && b == 1) || (a == 1 && b == 8) ||  (a == 8 && b == 13) 
						   
						   ||  (a == 13 && b == 6)) { 
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   

					   int[][] arrayX = {{50, 50, 70}, {330, 350, 340}, {550, 550, 530}, {250, 270, 260}};
					   int[][] arrayY = {{250, 270, 260}, {50, 50, 70}, {330, 350, 340}, {550, 550, 530} };
					   
					   
					   DrawTriangulo(arrayX[0], arrayY[0], Color.WHITE, g2d);
					   DrawTriangulo(arrayX[1], arrayY[1], Color.WHITE, g2d);
					   DrawTriangulo(arrayX[2], arrayY[2], Color.WHITE, g2d);
					   DrawTriangulo(arrayX[3], arrayY[3], Color.WHITE, g2d);
  
				   }
				   
				 //----- DESENHA CAMINHO COLORIDOS -----// 
				   
				   else if ((a == 7 && b >=1 && b<=5) || ( a >=1 && a<=5 && b == 7) || (a == 7  && b >=9 && b<=13) || (b == 7 && a >= 9 && a <= 13)) {
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   
				   }
				   g2d.setColor(Color.black);
				   
				   
				 //----- DESENHA QUADRADOS PRETOS -----// 
				   
				   if ((a == 8 && b == 1) || (a == 13 && b == 8) || (a == 6 && b == 13) || (a == 1 && b == 6) ) {  
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   
				   }
				   
				   //----- DESENHA TRIANGULOS DO CENTRO -----// 
				
				   else if (a >= 6 && a <=8 && b >= 6 && b <=8 ) { 

					   int[][] arrayX = {{240, 240, 300}, {360, 360, 300}, {240, 360, 300}, {240, 360, 300}};
					   int[][] arrayY = {{240, 360, 300}, {240, 360, 300}, {360, 360, 300}, {240, 240, 300}};
						
					   DrawTriangulo(arrayX[0], arrayY[0], Tabuleiro.DARK_RED, g2d);
					   DrawTriangulo(arrayX[1], arrayY[1], Tabuleiro.DARK_YELLOW, g2d);
					   DrawTriangulo(arrayX[2], arrayY[2], Tabuleiro.LIGHT_BLUE, g2d);
					   DrawTriangulo(arrayX[3], arrayY[3], Tabuleiro.DARK_GREEN, g2d);
						
						g2d.setPaint(Color.BLACK);
						g2d.drawRect(240, 240, 120, 120);

					   
				   }
				   
				   //----- DESENHA O RESTO DOS TRIANGULOS DO TABULEIRO -----//
	
				   else if (a >= 6 && a <=8 ||b >= 6 && b <=8 ) {
					   g2d.drawRect(b * 40, a * 40, 40, 40);
				   }
				   
				   g2d.drawRect(b * 40, a * 40, 40, 40);// tirar depois

			   }
			}
	
	}
	
	static void DrawPino(Graphics2D g2d, int x, int y, Color cor) {
		
		

		 g2d.setPaint(cor);
		 g2d.fill(new Ellipse2D.Double(x,y, 20, 20));
	     g2d.setPaint(cor);
	     g2d.draw(new Ellipse2D.Double(x,y, 20, 20));

	}
	
	static void DrawQuadrado(Graphics2D g2d, int x, int y, Color cor) {
		
		g2d.setColor(cor);
		//g2d.fillRect(x, y, 240, 240);
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(x, y, 240, 240);
		
	}
	
	private void DrawQuadradosColoridos(Graphics2D g2d) {
		
		DrawQuadrado(g2d, 0, 0, Tabuleiro.DARK_RED);
		DrawQuadrado(g2d, 0, 360, Tabuleiro.LIGHT_BLUE);
		DrawQuadrado(g2d, 360, 0, Tabuleiro.DARK_GREEN);
		DrawQuadrado(g2d, 360, 360, Tabuleiro.DARK_YELLOW);

		for (int i = 0; i < 4 ; i ++) {		
			
			DrawElipse(g2d, elipsesVerm[i][0], elipsesVerm[i][1], Tabuleiro.DARK_RED);
			DrawElipse(g2d, elipsesAzul[i][0], elipsesAzul[i][1], Tabuleiro.LIGHT_BLUE);
			DrawElipse(g2d, elipsesVerde[i][0], elipsesVerde[i][1], Tabuleiro.DARK_GREEN);
			DrawElipse(g2d, elipsesAma[i][0], elipsesAma[i][1], Tabuleiro.DARK_YELLOW);

		}	
	}
	
	private void DrawElipse(Graphics2D g2d, int x, int y, Color cor) {
		
		 g2d.setPaint(Color.WHITE);
	     g2d.fill(new Ellipse2D.Double(x,y, 40, 40));
	     g2d.setPaint(cor);
	     g2d.draw(new Ellipse2D.Double(x,y, 40, 40));
	     
	}
	
	private void DrawTriangulo(int[] arrayX , int[] arrayY, Color cor, Graphics2D g2d) {
		
		g2d.setPaint(Color.BLACK);
		g2d.drawPolygon(arrayX, arrayY, 3);
		g2d.setPaint(cor);
		g2d.fillPolygon(arrayX, arrayY, 3);
		
	}
	
	private void DrawRectangle(Graphics2D g2d) {
		
		g2d.setColor(Color.GRAY);
		g2d.fill(new Rectangle2D.Double(600, 0, 200, 600));
		
		g2d.setColor(fundo);
		g2d.fill(new Rectangle2D.Double(640, 280, 120, 120));
		
		g2d.drawImage(dado, 650, 290, null);
		
		
	}
	


	


}
