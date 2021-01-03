import java.util.ArrayList;

import processing.core.PApplet;

public class SpaceInvadersApp extends PApplet {

	public static void main(String[] args) {
		PApplet.main(new String[] { "SpaceInvadersApp" });
	}

	Ship ship;
	ArrayList<Alien> Aliens = new ArrayList<Alien>();
	ArrayList<Bullet> Bullets = new ArrayList<Bullet>();
	int level = 1;

	public void settings() {
		size(600, 400);
	}

	public void setup() {
		ship = new Ship(this);
		resetGameStateAndAddLevel(level);
	}

	public void draw() {
		background(51);
		tekenLevel();
		ship.show();
		boolean edge = false;

		// met deze loop worden de randen van de Aliens gechecked met de rand van het scherm; wanneer er collisie is draaien de aliens van richting.
		for (int i = 0; i < Aliens.size(); i++) {
			Alien a = Aliens.get(i);
			a.show();
			a.move();
			if (a.getX() > this.width - (a.SIZE / 2) || a.getX() < 0 + (a.SIZE / 2)) {
				edge = true;
			}
			//reset gamestate wanneer speler collide met 1 van de aliens.
			if (a.getY() > this.height - ship.getSize()) {
				Aliens.clear();
				level = 1;
				resetGameStateAndAddLevel(level);
			}
		}
		
		// wanneer alle aliens verslagen zijn wordt het level verhoogt en de aliens gereset.
		if (Aliens.size() == 0) {
			level ++;
			resetGameStateAndAddLevel(level);
		}
		
		// wanneer de aliens de rand van het scherm raken schuiven ze een stukje omlaag.
		if (edge) {
			for (int i = 0; i < Aliens.size(); i++) {
				Alien a = Aliens.get(i);
				a.shiftDown();
			}
		}
		
		for (int i = 0; i < Bullets.size(); i++) {
			Bullet b = Bullets.get(i);
			b.show();
			b.move();

			if (b.isBenedenHetScherm(b)) {
				Bullets.remove(i);
			}

			// check met deze loop elke individuele kogel en vergelijk deze
			// met de positie van de aliens.

			for (int j = 0; j < Aliens.size(); j++) {
				Alien a = Aliens.get(j);
				if (b.hits(a)) {
					Bullets.remove(i);
					Aliens.remove(j);
					System.out.println(Aliens.size());
				}
			}
		}
	}

	public void keyPressed() {
		if (keyCode == 32) {
			Bullet b = new Bullet(this, ship.getX() + (ship.getSize() / 2), this.height - ship.getSize());
			Bullets.add(b);
			System.out.println(Bullets.size());
		}

		if (keyCode == RIGHT) {
			ship.move(1);
		} else if (keyCode == LEFT) {
			ship.move(-1);
		}
	}
	
	// reset Aliens en voeg een extra rij toe.
	public void resetGameStateAndAddLevel(int level) {
		for (int j = 0; j < level; j++) {
			for (int i = 0; i < 6; i++) {
				Alien a = new Alien(this, i * 80 + 80, 30 + (j * 40));
				Aliens.add(a);
			}
		}
	}
	
	// noteer huidig level bovenin het scherm.
	public void tekenLevel() {
		fill(255);
		this.text("Level: " + level, this.width / 2, 20);
	}
}
