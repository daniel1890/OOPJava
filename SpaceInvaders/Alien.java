import processing.core.PApplet;

public class Alien {
	PApplet app;
	int x, y;
	public static final int SIZE = 30;
	int xdir = 1;

	public Alien(PApplet app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void show() {
		app.fill(255, 0, 200);
		app.ellipse(this.x, this.y, SIZE, SIZE);
	}
	
	public void move () {
		this.x = this.x + this.xdir;
	}
	
	public void shiftDown() {
		this.xdir *= -1;
		this.y += SIZE / 2;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
