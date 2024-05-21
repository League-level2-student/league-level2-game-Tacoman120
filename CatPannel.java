import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;



public class CatPannel extends JPanel implements ActionListener, KeyListener{
	
	

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Timer frameDraw;
    Timer itemSpawn;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font instructionFont = new Font("Arial", Font.PLAIN, 28);
    Font nextFont = new Font("Arial", Font.PLAIN, 28);
    Cat tabby = new Cat(50, 240, 50, 50);
    ObjectManager manager = new ObjectManager(tabby);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    
    
	CatPannel(){
		
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    if (needImage) {
	        loadImage ("highway.png");
	    }
	}
    
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	void updateMenuState() { 
		
	}
	 void updateGameState() { 
		 
		 manager.update();
	 }
	 void updateEndState()  { 
}

	 void drawMenuState(Graphics g) { 
		 
		 g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 800, 500);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("Cat Runner", 280, 100);
			g.setFont(instructionFont);
			g.setColor(Color.YELLOW);
			g.drawString("press ENTER to start the game", 220, 300);
			g.setFont(nextFont);
			g.setColor(Color.YELLOW);
			g.drawString("press SPACE for instructions", 240, 400);
	 }
	 void drawGameState(Graphics g) { 
		 if (gotImage) {
				g.drawImage(image, 0, 0, 800, 500, null);
			} else {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, 800, 500);
			}


		manager.draw(g);
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, 800, 500);
			g.setFont(titleFont);
			g.setColor(Color.BLACK);
			g.drawString("Game Over", 280, 100);
			g.setFont(instructionFont);
			g.setColor(Color.BLACK);
			g.drawString("press ENTER to return to menu", 220, 300);
			g.setFont(nextFont);
			g.setColor(Color.BLACK);
			g.drawString("you scored  points!", 240, 400);
	 }
	 
	 void startGame() {
		 itemSpawn = new Timer(1000 , manager);
		    itemSpawn.start();
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action");
		repaint();
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else if(currentState == MENU){
		    	startGame();
		    } else if(currentState == GAME){
		    } 
		        currentState++;
		    }
		   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			tabby.up();
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			tabby.down();
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			tabby.left();
		    System.out.println("LEFT");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			tabby.right();
		    System.out.println("RIGHT");
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	 
	
}
