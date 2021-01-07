import java.util.ArrayList;

public class Glazenbol {
	private ArrayList<Lottobal> ballen;

	public Glazenbol(ArrayList<Lottobal> ballen) {
		this.ballen = ballen;
	}

	public void verzamelAlleBallen() {
		if (ballen.size() < 1) {
			for (int i = 1; i < Lottomachine.getTotaalaantalballen(); i++) {
				Lottobal b = new Lottobal(i);
				ballen.add(b);
			}
		}
	}

	public int schepBal() {
		int limit = (int) (Math.random() * Lottomachine.getTotaalaantalballen());
		return ballen.get(limit).getBalNummer();
	}
}