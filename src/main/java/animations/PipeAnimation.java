package main.java.animations;

import main.java.config.SpriteConfig;

import javax.swing.*;

public class PipeAnimation extends Thread {
	private final JPanel PANEL;
	private final int INTERVAL;
	private final int SPEED;
	
	public PipeAnimation(JPanel panel, int interval, int speed) {
		this.PANEL = panel;
		this.INTERVAL = interval;
		this.SPEED = speed;
	}
	
	public PipeAnimation(JPanel panel) {
		this(panel, 1800, 2);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				new PipeMovementAnimation(PANEL, SPEED).start();
				
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
	private final int SPEED;
	
	private JLabel top;
	private JLabel bottom;
	
	public PipeMovementAnimation(JPanel panel, int speed) {
		this.PANEL = panel;
		this.SPEED = speed;
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
