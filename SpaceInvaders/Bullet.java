import processing.core.PApplet;

public class Bullet {
	PApplet app;
	int x, y;
	public static final int SIZE = 16;

	public Bullet(PApplet app, int x, int y) {
		this.x = x;
		this.y = y;
		this.app = app;
	}

	public void show() {
		app.noStroke();
		app.fill(150, 0, 255);
		app.ellipse(this.x, this.y, SIZE, SIZE);
	}
	
	public boolean hits(Alien a) {
		float d = app.dist(this.x, this.y, a.getX(), a.getY());
		return d < (this.SIZE / 2) + (a.SIZE / 2);
	}

	public void move() {
		this.y = this.y - 5;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return SIZE;
	}
	
	// check of kogel buiten het scherm is en verwijder deze.
	public boolean isBenedenHetScherm(Bullet b) {
		return ((b.getY() + b.SIZE) < 0);
	}

}
