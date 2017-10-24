package gameQuiz;

import java.awt.*;
import javax.swing.*;

public class JanelaPrincipal {

	public void principal() { // Janela principal do programa
		JFrame frame = new JFrame("Java Menubar Example");
		JMenuBar menuBar = new JMenuBar();

		// build the File menu
		JMenu fileMenu = new JMenu("Menu");
		JMenuItem openMenuItem = new JMenuItem("Jogar");
		JMenuItem gravaMenuItem = new JMenuItem("Cadastrar Perguntar");
		JMenuItem respostaMenuItem = new JMenuItem("Cadastrar Respostas");
		JMenuItem setaMenuItem = new JMenuItem("Seta Resposta Correta para as Perguntas");
		fileMenu.add(openMenuItem);
		fileMenu.add(gravaMenuItem);
		fileMenu.add(respostaMenuItem);
		fileMenu.add(setaMenuItem);

		// add menus to menubar
		menuBar.add(fileMenu);

		// put the menubar on the frame
		frame.setJMenuBar(menuBar);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		

	}

}
