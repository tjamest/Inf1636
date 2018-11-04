import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Jogo implements MouseListener {
	
	public Jogo() {
		
		Menu.b3.setEnabled(true);
		Menu.b4.setEnabled(true);
		
		

		
	}
	public void paintComponent2(Graphics g) {

    	
 
    	
    	
    	
    	
    
	}
	
	

	

	// ---- EVENTOS DO MOUSE ----
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//if(e.getXOnScreen() == 40 && e.getYOnScreen() ==40) {
			System.out.println("mouse na posição x=" + e.getX() + " y=" + e.getY()); 

		//}
		
		
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



	

}
