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
 
       
    }

	public void paintComponent(Graphics g) {

    	super.paintComponent(g);
    	Menu menu = new Menu();
    	
    	this.add(menu.b1);
    	this.add(menu.b2);
    	this.add(menu.b3);
    	this.add(menu.b4);
    	this.add(menu.turno);
    	
    	
    	Graphics2D g2d = (Graphics2D) g;
    	Graphics2D dice = (Graphics2D) g;
    	resp = TratadorBotao.getNumber();
    	// paint(dice);
    	DrawBoard(g2d);
    	DrawRectangle(g2d);
    	DrawDice(dice);

	}

	private void DrawDice(Graphics2D dice) {
		
		System.out.printf("valor tirado eh resp %d\n", resp); 
		repaint();
		 
		 if (resp!= 0) {
			 
			 dado = new ImageIcon(this.getClass().getResource(images[resp-1])).getImage();
			
			 dice.drawImage(dado, 650, 290, null);
			 
 
		 }
		
		
	}

	private void DrawRectangle(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.fill(new Rectangle2D.Double(613, 0, 200, 799));
		
	}

	private void DrawBoard(Graphics2D g2d) {
		
		
		for(int row = 0; row < 12; row++) {          // For each row
		      for(int col = 0; col < 12; col++) {       // For each square
		    	  
		    	  g2d.drawRect(row + row*50 , col+ col*50, 50, 50);
		    	 
		    	  
		    	  //g2d.fill(new Rectangle2D.Float(0+row,0+col , 50, 50));
		    	  
		        
		      }
		}
		System.out.printf("saiu\n"); 
		

	}

}
