package main.java.utils;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

public class GuiUtils {
	public static void addMouseReleasedListener(JPanel panel, Consumer<MouseEvent> callback) {
		panel.addMouseListener(
				new EmptyMouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						callback.accept(e);
					}
				}
		);
	}
	
	public static boolean isCollided(JLabel subject, JLabel obstacle) {
		var subjectMinimumX = subject.getX();
		var subjectMaximumX = subject.getX() + subject.getWidth();
		var subjectMinimumY = subject.getY();
		var subjectMaximumY = subject.getY() + subject.getHeight();
		
		var obstacleMinimumX = obstacle.getX();
		var obstacleMaximumX = obstacle.getX() + obstacle.getWidth();
		var obstacleMinimumY = obstacle.getY();
		var obstacleMaximumY = obstacle.getY() + obstacle.getHeight();
		
		if (subjectMaximumX <= obstacleMinimumX || subjectMinimumX >= obstacleMaximumX)
			return false;
		
		return subjectMaximumY > obstacleMinimumY && subjectMinimumY < obstacleMaximumY;
	}
}

class EmptyMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	}
}
