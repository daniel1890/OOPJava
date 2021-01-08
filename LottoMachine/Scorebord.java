import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Scorebord {
	private ArrayList<Lottobal> ballen;

	public Scorebord(ArrayList<Lottobal> ballen) {
		this.ballen = ballen;
	}

	public void plaatsBal(Lottobal bal, int i) {
		ballen.set(i, bal);
	}

	public void plaatsBonusBal(Lottobal bonusbal, int aantalKeerTrekkenLaatsteGetal) {
		ballen.set(aantalKeerTrekkenLaatsteGetal, bonusbal);
	}

	public void sorteerBallen() {
		for (int i = Lottomachine.totaalAantalBallenTrekkenPerBeurt; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (ballen.get(j).getBalNummer() > ballen.get(j + 1).getBalNummer()) {
					Lottobal bal = ballen.get(j);
					ballen.set(j, ballen.get(j + 1));
					ballen.set(j + 1, bal);
				}
			}
		}
	}

	public void printScoreBord() {
		for (int i = 0; i < 6; i++) {
			Lottobal bal = ballen.get(i);
			System.out.print(bal.getBalNummer() + " ");
		}

		Lottobal bonusbal = ballen.get(Lottomachine.totaalAantalBallenTrekkenPerBeurt);
		System.out.println("Bonusbal: " + bonusbal.getBalNummer());
	}

}
