import processing.core.PApplet;

public class SolarSystemAppp extends PApplet{

	public static void main(String[] args) {
		PApplet.main(new String[] {"SolarSystemAppp"} );

	}
	
	Planet sun;

	public void settings() {
		size(600, 600);
	}
	
	public void setup() {
		int[] GEEL = { 204, 204, 0 };
		sun = new Planet(this, 50, 0, GEEL[0], GEEL[1], GEEL[2]);
		sun.spawnPlanets((int) this.random(3, 10), 0);
	}
	
	public void draw() {
		this.background(0);
		this.translate(this.width / 2, this.height / 2);
		sun.show();
	}
}
