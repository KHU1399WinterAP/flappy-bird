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
