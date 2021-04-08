package main.java.gui;

import main.java.config.SpriteConfig;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JLabel birdLabel;
	private JLabel xyz;
	
	public MainFrame() {
		super("Flappy Bird");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
		
		initCustomComponents();
	}
	
	private void initCustomComponents() {
		xyz = new JLabel();
		xyz.setIcon(SpriteConfig.BIRD);
		xyz.setSize(100, 100);
		xyz.setLocation(50, 50);
		
		mainPanel.add(xyz);
	}
	
	private void createUIComponents() {
		mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(SpriteConfig.BACKGROUND, 0, 0, this);
			}
		};
		
		mainPanel.setLayout(null);
		
		birdLabel = new JLabel();
	}
}
