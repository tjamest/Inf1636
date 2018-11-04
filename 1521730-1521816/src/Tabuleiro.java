import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class Tabuleiro extends JPanel   {
	
	private Image dado;
	int resp = 0;
	 
	private static final long serialVersionUID = -4264416327199530488L;

	private String[] images = {"Dado1.png", "Dado2.png", "Dado3.png", "Dado4.png", "Dado5.png", "Dado6.png"};
	

	public Tabuleiro() {
		
    	setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        Menu menu = new Menu();
        
        this.add(Menu.b1);
        this.add(Menu.b2);
        this.add(Menu.b3);
        this.add(Menu.b4);
        this.add(Menu.turno);

    }

	public void paintComponent(Graphics g) {

    	super.paintComponent(g);
 
    	Graphics2D g2d = (Graphics2D) g;
    	Graphics2D test = (Graphics2D) g;
    	
    	DrawBoard(g2d);
    	DrawRectangle(g2d);
    	DrawQuadradosColoridos(g2d);
    	DrawDados(test);
    	
		//System.out.printf("valor tirado eh resp %d\n", resp); 

	}

	private void DrawDados(Graphics2D test) {
		resp = TratadorBotao.getNumber();
		
		if (resp!= 0) {
			 repaint();
			 dado = new ImageIcon(this.getClass().getResource(images[resp-1])).getImage();
			 test.drawImage(dado, 650, 290, null);
			 
	
		 }

	}

	private void DrawRectangle(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.fill(new Rectangle2D.Double(600, 0, 200, 600));
		
	}

	private void DrawBoard(Graphics2D g2d) {
		
		
		for(int a = 0; a < 15; a++){
			   for(int b = 0; b < 15; b++){
				   
				  //----- SET COLOR PARA QUADRADOS COLORIDOS -----// 
		
				   if(b>5 && b < 9) { 
					   if(a<=5) {
						   
						   g2d.setColor(Color.green);
						   
					   }
					   else if(a>8) {
						   
						   g2d.setColor(Color.blue);
						   
					   }
					   
				   	}
				   
				   else if(b<=5){
					   
					   g2d.setColor(Color.red);
					   
				   }
				   else if(b>8) {
					   
					   g2d.setColor(Color.yellow);
					   
				   }
				   
				 //----- DESENHA OS PRIMEIROS QUADRADOS COLORIDOS E AS SETINHAS DE DENTRO -----// 
				   
				   if ((a == 6 && b == 1) || (a == 1 && b == 8) ||  (a == 8 && b == 13) 
						   
						   ||  (a == 13 && b == 6)) { 
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   

					   int[][] arrayX = {{50, 50, 70}, {330, 350, 340}, {550, 550, 530}, {250, 270, 260}};
					   int[][] arrayY = {{250, 270, 260}, {50, 50, 70}, {330, 350, 340}, {550, 550, 530} };
					   
					   
					   fazTriangulo(arrayX[0], arrayY[0], Color.WHITE, g2d);
					   fazTriangulo(arrayX[1], arrayY[1], Color.WHITE, g2d);
					   fazTriangulo(arrayX[2], arrayY[2], Color.WHITE, g2d);
					   fazTriangulo(arrayX[3], arrayY[3], Color.WHITE, g2d);
  
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
						
						fazTriangulo(arrayX[0], arrayY[0], Color.RED, g2d);
						fazTriangulo(arrayX[1], arrayY[1], Color.YELLOW, g2d);
						fazTriangulo(arrayX[2], arrayY[2], Color.BLUE, g2d);
						fazTriangulo(arrayX[3], arrayY[3], Color.GREEN, g2d);
						
						g2d.setPaint(Color.BLACK);
						g2d.drawRect(240, 240, 120, 120);

					   
				   }
				   
				   //----- DESENHA O RESTO DOS TRIANGULOS DO TABULEIRO -----//
	
				   else if (a >= 6 && a <=8 ||b >= 6 && b <=8 ) {
					   g2d.drawRect(b * 40, a * 40, 40, 40);
				   }

			   }
			}
	
	}
	
	void fazTriangulo(int[] arrayX , int[] arrayY, Color cor, Graphics2D g2d) {
		g2d.setPaint(Color.BLACK);
		g2d.drawPolygon(arrayX, arrayY, 3);
		g2d.setPaint(cor);
		g2d.fillPolygon(arrayX, arrayY, 3);
	}
	
	private void DrawQuadradosColoridos(Graphics2D g2d) {
		
		int[] elipsesVermX = {30, 150, 30, 150};
		int[] elipsesVermY = {30, 30, 150, 150};
		
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, 240, 240);
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(0, 0, 240, 240);
		
		for (int i = 0; i < 4 ; i ++) {		
			 g2d.setPaint(Color.WHITE);
		     g2d.fill(new Ellipse2D.Double(elipsesVermX[i],elipsesVermY[i], 50, 50));
		     g2d.setPaint(Color.BLACK);
		     g2d.draw(new Ellipse2D.Double(elipsesVermX[i],elipsesVermY[i], 50, 50));
	
		}
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 360, 240, 240);
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(0, 360, 240, 240);
		
		int[] elipsesAzulX = {30, 150, 30, 150};
		int[] elipsesAzulY = {390, 390, 510, 510};
		
		for (int i = 0; i < 4 ; i ++) {		
			 g2d.setPaint(Color.WHITE);
		     g2d.fill(new Ellipse2D.Double(elipsesAzulX[i],elipsesAzulY[i], 50, 50));
		     g2d.setPaint(Color.BLACK);
		     g2d.draw(new Ellipse2D.Double(elipsesAzulX[i],elipsesAzulY[i], 50, 50));
	
		}
		
	
		g2d.setColor(Color.green);
		g2d.fillRect(360, 0, 240, 240);
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(360, 0, 240, 240);
		
		int[] elipsesVerdeX = {390, 510, 390, 510};
		int[] elipsesVerdeY = {30, 30, 150, 150};
		
		for (int i = 0; i < 4 ; i ++) {		
			 g2d.setPaint(Color.WHITE);
		     g2d.fill(new Ellipse2D.Double(elipsesVerdeX[i],elipsesVerdeY[i], 50, 50));
		     g2d.setPaint(Color.BLACK);
		     g2d.draw(new Ellipse2D.Double(elipsesVerdeX[i],elipsesVerdeY[i], 50, 50));
	
		}
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(360, 360, 240, 240);
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(360, 360, 240, 240);
		
		int[] elipsesAmaX = {390, 510, 390, 510};
		int[] elipsesAmaY = {390, 390, 510, 510};
		
		for (int i = 0; i < 4 ; i ++) {		
			 g2d.setPaint(Color.WHITE);
		     g2d.fill(new Ellipse2D.Double(elipsesAmaX[i],elipsesAmaY[i], 50, 50));
		     g2d.setPaint(Color.BLACK);
		     g2d.draw(new Ellipse2D.Double(elipsesAmaX[i],elipsesAmaY[i], 50, 50));
	
		}
		
	}



}
