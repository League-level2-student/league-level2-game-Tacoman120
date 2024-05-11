import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Cat extends GameObject {
	int laneOne = 1;
	int laneTwo = 2;
	int laneThree = 3;
	int currentLane = laneTwo;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Cat(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
		if (needImage) {
		    loadImage ("catImage.png");
		}
	}
	

	void draw(Graphics g){
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	public void right() {
		if(x<=750) {
        x+=speed;
		}
    }
	public void left() {
		if(x>=10)
        x-=speed;
    }
	public void up() {
		if(currentLane == 1) {
			
		}else {
			currentLane--;
		}
		
		if(currentLane == 1) {
				y=120;
		}if(currentLane == 2) {
			y=240;
		}if(currentLane == 3) {
			y=360;
	}
	}
		
	public void down() {
        
if(currentLane == 3) {
			
		}else {
			currentLane++;
		}
		
		if(currentLane == 1) {
			y=120;
		}if(currentLane == 2) {
			y=240;
		}if(currentLane == 3) {
			y=360;
		}
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


