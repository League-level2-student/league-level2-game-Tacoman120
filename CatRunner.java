import javax.swing.JFrame;

public class CatRunner {
	CatPannel cp;
	JFrame street;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatRunner runner = new CatRunner();
		runner.setup();
	}
	
	CatRunner(){
		street = new JFrame();
		cp = new CatPannel();
		
	}
	
	void setup(){
		street.add(cp);
		street.setSize(WIDTH, HEIGHT);
		street.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		street.setVisible(true);
		street.addKeyListener(cp);
		
	}

}
