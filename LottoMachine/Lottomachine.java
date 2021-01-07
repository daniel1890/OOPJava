import java.util.ArrayList;

public class Lottomachine {
	private Glazenbol bol;
	public Scorebord bord;
	public static final int totaalAantalBallen = 45;
	private ArrayList<Lottobal> ballen = new ArrayList<Lottobal>();



	public Lottomachine() {
		bol = new Glazenbol(ballen);
		bord = new Scorebord(ballen);
		bol.verzamelAlleBallen();
	}

	public void trekBallen() {
		int aantalKeerTrekken = 6;
		for (int i = 1; i < 7; i++) {
			int bal = bol.schepBal();
			bord.plaatsBal(bal, i);
		}
		int bonusbal = bol.schepBal();
		bord.plaatsBonusBal(bonusbal, aantalKeerTrekken);
	}

	public static int getTotaalaantalballen() {
		return totaalAantalBallen;
	}

}
