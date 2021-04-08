package main.java.gui;

import main.java.animations.BirdFlyAnimation;
import main.java.animations.BirdJumpAnimation;
import main.java.animations.GravityAnimation;
import main.java.animations.PipeAnimation;
import main.java.config.SpriteConfig;
import main.java.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JLabel birdLabel;
	
	private Thread birdFlyAnimation;
	private Thread birdGravityAnimation;
	
	public MainFrame() {
		super("Flappy Bird");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);
		
		initCustomComponents();
		initAnimations();
		initListeners();
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
	
	private void initCustomComponents() {
		var width = SpriteConfig.BIRD_STATE_01.getIconWidth();
		var height = SpriteConfig.BIRD_STATE_01.getIconHeight();
		
		birdLabel = new JLabel();
		birdLabel.setIcon(SpriteConfig.BIRD_STATE_01);
		birdLabel.setSize(width, height);
		birdLabel.setLocation(50, 50);
		
		mainPanel.add(birdLabel);
	}
	
	private void initAnimations() {
		birdFlyAnimation = new BirdFlyAnimation(birdLabel);
		birdFlyAnimation.start();
		
		birdGravityAnimation = new GravityAnimation(birdLabel);
		birdGravityAnimation.start();
		
		new PipeAnimation(mainPanel).start();
	}
	
	private void initListeners() {
		initMainPanelListeners();
	}
	
	private void initMainPanelListeners() {
		GuiUtils.addMouseReleasedListener(mainPanel, e -> {
			GravityAnimation.halt = true;
			new BirdJumpAnimation(birdLabel, () -> GravityAnimation.halt = false).start();
		});
	}
}
