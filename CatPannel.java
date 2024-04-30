import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class CatPannel extends JPanel {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0, 0, 800, 500);
		
	}
	
	void updateMenuState() { 
		
	}
	 void updateGameState() { 
		 
	 }
	 void updateEndState()  { 
}

	 void drawMenuState(Graphics g) { 
		 
		 g.setColor(Color.BLUE);
			g.fillRect(100, 100, WIDTH, HEIGHT);
	 }
	 void drawGameState(Graphics g) { 
		 g.setColor(Color.BLUE);
			g.fillRect(100, 100, WIDTH, HEIGHT);
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.BLUE);
			g.fillRect(100, 100, WIDTH, HEIGHT);
	 }
	 
	
}
