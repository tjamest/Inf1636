import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class Tabuleiro extends JPanel   {
	
	private Image dado;
	int resp = 0;
	 int xPositions = 0;
     int yPositions = 0;
     int squareSize = 40;
	
	private static final long serialVersionUID = -4264416327199530488L;

	private String[] images = {"Dado1.png", "Dado2.png", "Dado3.png", "Dado4.png", "Dado5.png", "Dado6.png"};

	public Tabuleiro() {
		
    	setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));
        Menu menu = new Menu();
        this.add(menu.b1);
        this.add(menu.b2);
        this.add(menu.b3);
        this.add(menu.b4);
        this.add(menu.turno);

    }

	public void paintComponent(Graphics g) {

    	super.paintComponent(g);
 
    	Graphics2D g2d = (Graphics2D) g;
    	Graphics2D test = (Graphics2D) g;
 
    	
    	DrawBoard(g2d);
    	DrawRectangle(g2d);
    	DrawQuadradosColoridos(g2d);
    //	DrawDados(test);
    	
		System.out.printf("valor tirado eh resp %d\n", resp); 

	}



//	private void DrawDados(Graphics2D test) {
//		resp = TratadorBotao.getNumber();
//		
//		if (resp!= 0) {
//			 repaint();
//			 dado = new ImageIcon(this.getClass().getResource(images[resp-1])).getImage();
//			 test.drawImage(dado, 650, 290, null);
//			 
//	
//		 }
//
//	}

	

	

	private void DrawRectangle(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.fill(new Rectangle2D.Double(600, 0, 200, 600));
		
	}

	private void DrawBoard(Graphics2D g2d) {
		for(int a = 0; a < 15; a++){
			   for(int b = 0; b < 15; b++){
				   //set cor para quadrados coloridos
				   if(b>5 && b < 9) {
					   if(a<=5) {
						   g2d.setColor(Color.green);
					   }else if(a>8) {
						   g2d.setColor(Color.blue);
					   }
				   }else if(b<=5){
					   g2d.setColor(Color.red);
				   }else if(b>8) {
					   g2d.setColor(Color.yellow);
				   }
				   
				   if ((a == 6 && b == 1) || (a == 1 && b == 8) ||  (a == 8 && b == 13) 
						   
						   ||  (a == 13 && b == 6)) { //primeiro quadrado colorido
					   
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
				   }
				   
				   
				   
				   else if ((a == 7 && b >=1 && b<=5) || ( a >=1 && a<=5 && b == 7) 
						   
						   || (a == 7  && b >=9 && b<=13) || (b == 7 && a >= 9 && a <= 13)) { //caminho colorido
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   
				   }
				   g2d.setColor(Color.black);
				   if ((a == 8 && b == 1) || (a == 13 && b == 8) || (a == 6 && b == 13) 
						   
						   || (a == 1 && b == 6) ) { //quadrados pretos 
					   
					   g2d.fillRect(b * 40, a * 40, 40, 40);
					   
				   }
				
				   else if (a >= 6 && a <=8 && b >= 6 && b <=8 ) { //aonde vao ficar os triangulos
					   
					   
//					   
//					   g2d.setColor(Color.red);
//					   
//					  
//					   
//					   
//					   g2d.setColor(Color.green);
//					   
//					   g2d.setColor(Color.blue);
//					   
//					   g2d.setColor(Color.yellow);
//					   
//					   g2d.setColor(Color.black);
//					  // g2d.fillRect(b * 40, a * 40, 40, 40);
					   
					   
					   
				   }
	
				   else if (a >= 6 && a <=8 ||b >= 6 && b <=8 ) { //resto dos quadrados do tabuleiro
					   g2d.drawRect(b * 40, a * 40, 40, 40);
				   }
				   
				   
				   
//				   else {
//					   DrawQuadradosColoridos(g2d);
//				   }

			   }
			}
	
	}
	
	private void DrawQuadradosColoridos(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, 240, 240);
		
		g2d.setColor(Color.green);
		g2d.fillRect(360, 0, 240, 240);
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 360, 240, 240);
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(360, 360, 240, 240);
		
	}



}
