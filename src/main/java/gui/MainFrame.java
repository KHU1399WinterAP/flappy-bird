package main.java.gui;

import main.java.config.SpriteConfig;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JLabel birdLabel;
	
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
		birdLabel = new JLabel();
		birdLabel.setIcon(SpriteConfig.BIRD_STATE_01);
		birdLabel.setSize(SpriteConfig.BIRD_STATE_01.getIconWidth(), SpriteConfig.BIRD_STATE_01.getIconHeight());
		birdLabel.setLocation(50, 50);
		
		mainPanel.add(birdLabel);
	}
	
	private void createUIComponents() {
		mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(SpriteConfig.BACKGROUND, 0, 0, this);
			}
		};
		
		mainPanel.setLayout(null);
	}
}
