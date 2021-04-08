package main.java.config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {
	private static final URL BACKGROUND_URL = SpriteConfig.class.getResource("/main/resources/sprites/Background.png");
	
	private static final URL BIRD_STATE_01_URL = SpriteConfig.class.getResource("/main/resources/sprites/Bird - State 01.png");
	
	public static final BufferedImage BACKGROUND = createImage(BACKGROUND_URL, "Background");
	
	public static final Icon BIRD_STATE_01 = createIcon(BIRD_STATE_01_URL, "Bird");
	
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
		if (url != null)
			return new ImageIcon(url);
		
		printError(name);
		return null;
	}
	
	private static void printError(String name) {
		System.out.printf("Cannot find %s sprite.\n", name);
	}
}
