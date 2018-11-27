import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.*;

public class Menu {

	//Botoes
	static JButton b1 = new JButton("Novo Jogo");
	static JButton b2 = new JButton("Carregar Jogo");
	static JButton b3 = new JButton("Salvar");
	static JButton b4 = new JButton("Lancar Dado");
	
	//Labels
	static JLabel turno = new JLabel("A Jogar: ");
	public static Font turno25 = new Font("Courier New", Font.BOLD, 25);
	
	public Menu() {
		
		ConfiguraSaveGame();
		ConfiguraLoadGame();
		ConfiguraLancaDado();
		ConfiguraNewGame();
		ConfiguraLabel();

	}

	static void ConfiguraNewGame() {
		b1.setBounds(620,50,150,50);
	
	}
	static void ConfiguraLoadGame() {
		 b2.setBounds(620,110,150,50);
		 b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoadGame();
				}
			});
	}
	static void ConfiguraSaveGame() {
		b3.setBounds(620,170,150,50); 
		b3.setEnabled(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveGame();
			}
		});
	}

	static void ConfiguraLabel() {
		turno.setFont(turno25);
		turno.setBounds(630, 235, 180, 30);
	}

	static void ConfiguraLancaDado() {
		b4.setBounds(620,400,150,50);
		b4.setEnabled(false);
	
	}
	
	public static void LoadGame()
	{
		//Abrindo o Filechooser e escolhendo o arquivo txt correto
		File file = null;
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = fc.showDialog(fc, "Load Game");
		if(returnVal == JFileChooser.APPROVE_OPTION)
			file = fc.getSelectedFile();
		else
			System.out.print("Nenhum arquivo escolhido");
		
		
	}
	
	public static void SaveGame()
	{
		int i;
		String path = null;
		Vector<Peao> pecas = new Vector<Peao>();
		//pecas = tab.getPecas();
		
		//Escolhendo local e nome do salvamento do jogo
		JFileChooser fs = new JFileChooser();	
		int returnVal = fs.showSaveDialog(fs);	
		if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				path = fs.getSelectedFile().getAbsolutePath();
			}
		else
			System.out.print("Nenhum arquivo escolhido");
		
	
	}

}
