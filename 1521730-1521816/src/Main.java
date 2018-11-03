

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Main extends JFrame {

	private static final long serialVersionUID = 836988929125495440L;

	static JFrame frame = new JFrame("LUDO");
	static int number;

	
//	
//	//Botoes
//	static JButton b1 = new JButton("Novo Jogo");
//	static JButton b2 = new JButton("Carregar Jogo");
//	static JButton b3 = new JButton("Salvar");
//	static JButton b4 = new JButton("Lancar Dado");
//	
//	//Labels
//	static JLabel turno = new JLabel("À Jogar: ");
//	public static Font turno25 = new Font("Courier New", Font.BOLD, 25);
//	
	public static void main(String[] args)
	 {
//		ConfiguraSaveGame();
//		ConfiguraLoadGame();
//		ConfiguraLancaDado();
//		ConfiguraNewGame();
//		ConfiguraLabel();
		ConfiguraFrame();
//		
//		frame.add(b1);
//		frame.add(b2);
//		frame.add(b3);
//		frame.add(b4);
//		frame.add(turno);
	
		Tabuleiro tab = new Tabuleiro();
		
		
		
		
		frame.add(tab);
		//frame.add(menu);
		
		frame.setVisible(true);	
		frame.repaint();
	 }
	
	

	static void ConfiguraFrame() {
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}


}
