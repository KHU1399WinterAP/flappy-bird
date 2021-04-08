package main.java.animations;

import javax.swing.*;

public class GravityAnimation extends Thread {
	private final int GRAVITY_FORCE = 2;
	
	private final JLabel LABEL;
	
	public GravityAnimation(JLabel LABEL) {
		this.LABEL = LABEL;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				LABEL.setLocation(LABEL.getX(), LABEL.getY() + GRAVITY_FORCE);
				
				sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
