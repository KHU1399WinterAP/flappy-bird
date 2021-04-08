package main.java.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	
	public MainFrame() {
		super("Flappy Bird");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
	}
}
