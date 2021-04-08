package main.java.animations;

import javax.swing.*;

public class BirdJumpAnimation extends Thread {
	private final int SLEEP = 10;
	
	private final JLabel BIRD_LABEL;
	private final int DISTANCE;
	private final int DURATION;
	
	private final Runnable END_CALLBACK;
	
	public BirdJumpAnimation(JLabel birdLabel, int distance, int duration, Runnable endCallback) {
		this.BIRD_LABEL = birdLabel;
		this.DURATION = duration;
		this.DISTANCE = distance;
		this.END_CALLBACK = endCallback;
	}
	
	public BirdJumpAnimation(JLabel birdLabel, Runnable endCallback) {
		this(birdLabel, 80, 100, endCallback);
	}
	
	@Override
	public void run() {
		var deltaY = (DISTANCE * SLEEP * 1.0) / DURATION;
		
		try {
			for (int i = 1; i <= DURATION / SLEEP; i++) {
				BIRD_LABEL.setLocation(BIRD_LABEL.getX(), (int) (BIRD_LABEL.getY() - deltaY));
				
				sleep(SLEEP);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		END_CALLBACK.run();
	}
}
