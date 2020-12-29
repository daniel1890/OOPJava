package main;

import processing.core.PApplet;

public class KlokApp extends PApplet {

	public static void main(String[] args) {
		PApplet.main(new String[] { "main.KlokApp" });

	}

	Klok deKlok;

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		background(255);
		deKlok = new Klok(150, 100, 200, this);

		deKlok.setTijd(23, 59);
	}

	public void draw() {
		deKlok.tik();
		deKlok.tekenKlok();
	}

}
