
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {
	
	public MainFrame()
	 {
		 setTitle("Super Ludo");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 add(new CanvasPanel());
		 setSize(800, 600);
		 setLocationRelativeTo(null);
	 } 
	
	public static void main(String[] args)
	 {
		 SwingUtilities.invokeLater(new Runnable(){
			 @Override
			 public void run(){
				 new MainFrame().setVisible(true);
			 }
		 });
	 }

}
