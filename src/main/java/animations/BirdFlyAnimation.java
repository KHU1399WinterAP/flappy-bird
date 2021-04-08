package main.java.animations;

import main.java.config.SpriteConfig;

import javax.swing.*;

public class BirdFlyAnimation extends Thread {
	private final Icon[] STATES = {
			SpriteConfig.BIRD_STATE_01,
			SpriteConfig.BIRD_STATE_02,
			SpriteConfig.BIRD_STATE_03,
			SpriteConfig.BIRD_STATE_02
	};
	
	private final JLabel BIRD_LABEL;
	private int stateIndex = 0;
	
	public BirdFlyAnimation(JLabel birdLabel) {
		this.BIRD_LABEL = birdLabel;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				BIRD_LABEL.setIcon(STATES[stateIndex]);
				stateIndex = (stateIndex + 1) % STATES.length;
				
				sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
