package main.java.animations;

import main.java.config.SpriteConfig;
import main.java.utils.GuiUtils;

import javax.swing.*;

public class PipeAnimation extends Thread {
	private final JPanel PANEL;
	private final JLabel BIRD_LABEL;
	private final int INTERVAL;
	private final int SPEED;
	private final Runnable GAME_OVER_CALLBACK;
	
	public PipeAnimation(JPanel panel, JLabel birdLabel, int interval, int speed, Runnable gameOverCallback) {
		this.PANEL = panel;
		this.BIRD_LABEL = birdLabel;
		this.INTERVAL = interval;
		this.SPEED = speed;
		this.GAME_OVER_CALLBACK = gameOverCallback;
	}
	
	public PipeAnimation(JPanel panel, JLabel birdLabel, Runnable gameOverCallback) {
		this(panel, birdLabel, 1800, 2, gameOverCallback);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				new PipeMovementAnimation(PANEL, BIRD_LABEL, SPEED, GAME_OVER_CALLBACK).start();
				
				sleep(INTERVAL);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PipeMovementAnimation extends Thread {
	private final int INITIAL_X = 1000;
	private final int FINAL_X = -400;
	private final int PIPES_DISTANCE = 150;
	private final int PADDING = 50;
	private final int SLEEP = 10;
	
	private final JPanel PANEL;
	private final JLabel BIRD_LABEL;
	private final int SPEED;
	private final Runnable GAME_OVER_CALLBACK;
	
	private JLabel top;
	private JLabel bottom;
	
	public PipeMovementAnimation(JPanel panel, JLabel birdLabel, int speed, Runnable gameOverCallback) {
		this.PANEL = panel;
		this.BIRD_LABEL = birdLabel;
		this.SPEED = speed;
		this.GAME_OVER_CALLBACK = gameOverCallback;
	}
	
	@Override
	public void run() {
		initPipes();
		
		try {
			var x = INITIAL_X;
			
			while (true) {
				x -= SPEED;
				
				top.setLocation(x, top.getY());
				bottom.setLocation(x, bottom.getY());
				
				if (GuiUtils.isCollided(BIRD_LABEL, top) || GuiUtils.isCollided(BIRD_LABEL, bottom)) {
					GAME_OVER_CALLBACK.run();
					break;
				}
				
				if (x <= FINAL_X)
					break;
				
				sleep(SLEEP);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void initPipes() {
		var width = SpriteConfig.PIPE.getIconWidth();
		var height = SpriteConfig.PIPE.getIconHeight();
		
		var minimumY = PADDING + SpriteConfig.PIPE.getIconHeight() * -1;
		var offsetY = Math.random() * (400 - PIPES_DISTANCE - 2 * PADDING);
		var y = (int) (minimumY + offsetY);
		
		top = new JLabel();
		bottom = new JLabel();
		
		top.setIcon(SpriteConfig.PIPE_REVERSE);
		top.setSize(width, height);
		
		bottom.setIcon(SpriteConfig.PIPE);
		bottom.setSize(width, height);
		
		top.setLocation(INITIAL_X, y);
		bottom.setLocation(INITIAL_X, y + height + PIPES_DISTANCE);
		
		PANEL.add(top);
		PANEL.add(bottom);
	}
}
