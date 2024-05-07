import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class CatPannel extends JPanel implements ActionListener, KeyListener{
	
	

	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Timer frameDraw;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font instructionFont = new Font("Arial", Font.PLAIN, 28);
    Font nextFont = new Font("Arial", Font.PLAIN, 28);
    Cat tabby = new Cat(700, 250, 50, 50);
    
	CatPannel(){
		
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
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
		 g.setColor(Color.green);
			g.fillRect(0, 0, 800, 500);
			tabby.draw(g);
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
		    } else {
		        currentState++;
		    }
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	
}
