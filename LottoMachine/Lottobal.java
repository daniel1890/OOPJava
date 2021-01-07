
public class Lottobal {
	private int balNummer;

	public Lottobal(int nummer) {
		this.balNummer = nummer;
	}

	public boolean isNummerGroterDan(Lottobal andereBal) {
		return balNummer > andereBal.balNummer;
	}

	public String toString() {
		return "" + balNummer;
	}

	public int getBalNummer() {
		return balNummer;
	}

	public void setBalNummer(int balNummer) {
		this.balNummer = balNummer;
	}

}
