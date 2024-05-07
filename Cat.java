import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Cat extends GameObject {
	int laneOne = 1;
	int laneTwo = 2;
	int laneThree = 3;
	int currentLane = laneTwo;
	
	Cat(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	public void right() {
        x+=speed;
    }
	public void left() {
        x-=speed;
    }
	public void up() {
		if(currentLane == 1) {
			y=166;
		}if(currentLane == 2) {
			y=332;
		}if(currentLane == 3) {
			y=498;
	}
	}
		
	public void down() {
        x+=speed;
    }

}
