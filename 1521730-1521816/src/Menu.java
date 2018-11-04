import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu {

	//Botoes
	static JButton b1 = new JButton("Novo Jogo");
	static JButton b2 = new JButton("Carregar Jogo");
	static JButton b3 = new JButton("Salvar");
	static JButton b4 = new JButton("Lancar Dado");
	
	//Labels
	static JLabel turno = new JLabel("À Jogar: ");
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
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Jogo();
			}
		});	
	}
	static void ConfiguraLoadGame() {
		 b2.setBounds(620,110,150,50);
	}
	static void ConfiguraSaveGame() {
		b3.setBounds(620,170,150,50); 
		b3.setEnabled(false);
	}

	static void ConfiguraLabel() {
		turno.setFont(turno25);
		turno.setBounds(630, 235, 180, 30);
	}

	static void ConfiguraLancaDado() {
		b4.setBounds(620,400,150,50);
		b4.addActionListener(new TratadorBotao(b4));
		b4.setEnabled(false);
	
	}

}
