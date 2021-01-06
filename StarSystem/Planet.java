import processing.core.PApplet;

public class Planet {
	PApplet app;
	private float radius;
	private float angle;
	private float distance;
	private int red;
	private int green;
	private int blue;
	private float orbitSpeed;
	Planet[] planets;

	public Planet(PApplet app, float r, float d, int red, int green, int blue) {
		this.app = app;
		this.radius = r;
		this.distance = d;
		this.angle = app.random((float) (Math.PI * 2));
		this.orbitSpeed = app.random((float) 0.02, (float) 0.05);
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	void orbit() {
		angle = angle + orbitSpeed;
	}

	void spawnPlanets(int total, int level) {
		planets = new Planet[total];
		for (int i = 0; i < planets.length; i++) {
			float r = (float) (radius * 0.5);
			float d = app.random(75, 300);
			int c = (int) app.random(255);
			int[] rgb = new int[3];
			for (int j = 0; j < rgb.length; j++) {
				rgb[j] = (int)app.random(255);
			}
			planets[i] = new Planet(app, r, d, rgb[0], rgb[1], rgb[2]);
		}

	}

	public void show() {
		app.pushMatrix();
		app.rotate(angle);
		app.translate(distance, 0);
		app.fill(this.red, green, blue);
		app.ellipse(0, 0, radius * 2, radius * 2);

		if (planets != null) {
			for (int i = 0; i < planets.length; i++) {
				planets[i].show();
				planets[i].orbit();
			}
		}
		app.popMatrix();
	}

}
