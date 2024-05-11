import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Random random = new Random();
	Cat claws;
	ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
	ArrayList<Fish> fishies = new ArrayList<Fish>();
	int itemSpawn;
	int spawnLane = 0;
	
	ObjectManager(Cat claws){
		this.claws = claws;
	}
	
	void addThing() {
		itemSpawn = random.nextInt(5);
		if(itemSpawn == 1) {
			spawnLane = random.nextInt(3);
			if(spawnLane == 0) {
				fishies.add(new Fish(750,120,20,20));
			}else if(spawnLane == 1) {
				fishies.add(new Fish(750,240,20,20));
			}else if(spawnLane == 2) {
				fishies.add(new Fish(750,360,20,20));
			}
		} else {
		spawnLane = random.nextInt(3);
		if(spawnLane == 0) {
			obstacles.add(new Obstacles(750,120,50,50));
		}else if(spawnLane == 1) {
			obstacles.add(new Obstacles(750,240,50,50));
		}else if(spawnLane == 2) {
			obstacles.add(new Obstacles(750,360,50,50));
		}
		}
	}
	void update() {
		for(Obstacles o : obstacles) {
			o.update();
			if(o.x<0) {
				o.isActive = false;
			}
		}
		for(Fish f : fishies) {
			f.update();
			if(f.x<0) {
				f.isActive = false;
			}
		}
	}
	void purgeObjects() {
		for(int i = 0; i<obstacles.size(); i++) {
			if(obstacles.get(i).isActive == false) {
				obstacles.remove(i);
			}
		}
		for(int i = 0; i<fishies.size(); i++) {
			if(fishies.get(i).isActive == false) {
				fishies.remove(i);
			}
		}
	}
	void draw(Graphics g) {
		claws.draw(g);
		for(Obstacles o: obstacles) {
			o.draw(g);
		}
		for(Fish f: fishies) {
			f.draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addThing();
	}
}
