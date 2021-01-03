import processing.core.PApplet;

public class Ship {
	PApplet app;
	int x;
	int y;

	public static int size = 20;

	public Ship(PApplet app) {
		this.app = app;
		x = app.width / 2;
	}

	public void show() {
		app.fill(255);
		app.rect(this.x, app.height - size, size, size);
	}

	public void move(int i) {
		this.x += i * 5;
		x = app.constrain(this.x, 0, app.width - size);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

}
