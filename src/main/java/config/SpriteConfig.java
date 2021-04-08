package main.java.config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {
	private static final int BIRD_SIZE_MULTIPLIER = 2;
	
	private static final URL BACKGROUND_URL = SpriteConfig.class.getResource("/main/resources/sprites/Background.png");
	
	private static final URL BIRD_STATE_01_URL = SpriteConfig.class.getResource("/main/resources/sprites/Bird - State 01.png");
	private static final URL BIRD_STATE_02_URL = SpriteConfig.class.getResource("/main/resources/sprites/Bird - State 02.png");
	private static final URL BIRD_STATE_03_URL = SpriteConfig.class.getResource("/main/resources/sprites/Bird - State 03.png");
	
	public static final BufferedImage BACKGROUND = createImage(BACKGROUND_URL, "Background");
	
	public static final Icon BIRD_STATE_01 = createIcon(BIRD_STATE_01_URL, "Bird");
	public static final Icon BIRD_STATE_02 = createIcon(BIRD_STATE_02_URL, "Bird");
	public static final Icon BIRD_STATE_03 = createIcon(BIRD_STATE_03_URL, "Bird");
	
	private static BufferedImage createImage(URL url, String name) {
		try {
			if (url != null)
				return ImageIO.read(url);
			
			printError(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static Icon createIcon(URL url, String name) {
		try {
			if (url != null) {
				var image = ImageIO.read(url);
				var width = image.getWidth() * BIRD_SIZE_MULTIPLIER;
				var height = image.getHeight() * BIRD_SIZE_MULTIPLIER;
				
				return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
			}
			
			printError(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static void printError(String name) {
		System.out.printf("Cannot find %s sprite.\n", name);
	}
}
