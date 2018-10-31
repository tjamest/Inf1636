import java.awt.*; 

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;


public class TratadorDado implements ActionListener { 
	
	public static int roll = 0;
	
	Container c;
	private String[] images = {"Dado1.png", "Dado2.png", "Dado3.png", "Dado4.png", "Dado5.png", "Dado6.png"}; 
	
	
	
	public TratadorDado(Container x) {
		c=x;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
	  
		
	     roll = (int)(Math.random()*6+1);
	     
	         
	    
	     System.out.printf("valor tirado eh %d\n", roll); 
	
	} 

	 public static int getNumber () {
		 if (roll == 0)
			 return -1;
		 return roll;
	 }
	
	
}