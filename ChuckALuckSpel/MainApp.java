
public class MainApp {

	public static void main(String[] args) {
		ChuckALuckSpel spel = new ChuckALuckSpel(1000);
		for (int i = 0; i < 100; i++) {
			spel.speelRonde(i % 6 + 1, 10);
		}
	}

}
