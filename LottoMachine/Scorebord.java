import java.util.ArrayList;
import java.util.Arrays;

public class Scorebord {
	private int[] scores = new int[7];
    private ArrayList<Lottobal> ballen;

	public Scorebord(ArrayList<Lottobal> ballen) {
		this.ballen = ballen;
	}

	public void plaatsBal(int bal, int i) {
		scores[i] = bal;
	}

	public void plaatsBonusBal(int bal, int aantalKeerTrekken) {
		scores[aantalKeerTrekken] = bal;
	}

	public void sorteerBallen() {
		Arrays.sort(scores);
	}

	public void printScoreBord() {
		sorteerBallen();
		for (int i = 0; i < 6; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println("Bonusbal: " + scores[6]);
	}

}
