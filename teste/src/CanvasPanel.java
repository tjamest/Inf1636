

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class CanvasPanel extends JPanel implements Runnable {
	
	JButton b1 = new JButton("Novo Jogo");
	JButton b2 = new JButton("Carregar Jogo");
	JButton b3 = new JButton("Salvar");
	JButton b4 = new JButton("Lancar Dado");
	
	
	private Image dado;

	int resp = 0;
	
	public CanvasPanel()
	 {
		 b4.addActionListener(new TratadorDado(this));
		 setDoubleBuffered(true);
		 setFocusable(true);
		 load();
		 
		 new Thread(this).start();
	 }
	 @Override public void paintComponent(Graphics g)
	 {
		 super.paintComponent(g);
		 draw(g);
	 }
	 
	 @Override public void run()
	 {
		 double btime, dtime = 0;
		 btime = System.currentTimeMillis();
		 while(true)
		 {
			 update(dtime/1000);
			 repaint();
			 try {
				 Thread.sleep(1);
			 } catch (InterruptedException e) {
				 System.out.println(e.getMessage());
			 }
			 dtime = (System.currentTimeMillis() - btime);
			 btime = System.currentTimeMillis();
		 } 
	 }
	 
	 private void load()
	 {
		 setBackground(Color.WHITE);
	 }

	 private void update(double dt)
	 {
		 resp = TratadorDado.getNumber();
		 
	 }

	 private void draw(Graphics g)
	 {
		 Graphics2D g2d = (Graphics2D)g;

		 //desenha barra cinza lateral
		 g2d.setColor(Color.GRAY);
		 g2d.fill(new Rectangle2D.Double(600, 0, 200, 799));
		 
		 //botoes 
		 b1.setBounds(620,50,150,50); //novo jogo
		 b2.setBounds(620,110,150,50); //carregar jogo
		 b3.setBounds(620,210,150,50); // salvar
		 b4.setBounds(620,290,150,50); // lancar dados
		 b3.setEnabled(false);
		 this.add(b1);
		 this.add(b2);
		 this.add(b3);
		 this.add(b4);
		 
		 if (resp != -1 && resp == 1) {
			 dado = new ImageIcon(this.getClass().getResource("Dado1.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 if (resp != -1 && resp == 2) {
			 dado = new ImageIcon(this.getClass().getResource("Dado2.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 if (resp != -1 && resp == 3) {
			 dado = new ImageIcon(this.getClass().getResource("Dado3.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 if (resp != -1 && resp == 4) {
			 dado = new ImageIcon(this.getClass().getResource("Dado4.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 if (resp != -1 && resp == 5) {
			 dado = new ImageIcon(this.getClass().getResource("Dado5.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 if (resp != -1 && resp == 6) {
			 dado = new ImageIcon(this.getClass().getResource("Dado6.png")).getImage();
			 g2d.drawImage(dado, 650, 350, this);
			 
		 }
		 
		 
		
	 }
	
	
	
	
	

}
