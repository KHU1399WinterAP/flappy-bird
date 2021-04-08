package main.java.animations;

import javax.swing.*;

public class GravityAnimation extends Thread {
	public static boolean halt = false;
	
	private final int GRAVITY_FORCE = 2;
	
	private final JLabel LABEL;
	private final Runnable GAME_OVER_CALLBACK;
	
	public GravityAnimation(JLabel LABEL, Runnable gameOverCallback) {
		this.LABEL = LABEL;
		this.GAME_OVER_CALLBACK = gameOverCallback;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				if (!halt)
					LABEL.setLocation(LABEL.getX(), LABEL.getY() + GRAVITY_FORCE);
				
				if (LABEL.getY() > 400)
					break;
				
				sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		GAME_OVER_CALLBACK.run();
	}
}
