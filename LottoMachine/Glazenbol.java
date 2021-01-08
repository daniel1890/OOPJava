import java.util.ArrayList;

public class Lottomachine {
	private Glazenbol bol;
	public Scorebord bord;
	public static final int totaalAantalBallen = 45;
	public static final int totaalAantalBallenTrekkenPerBeurt = 6;
	private ArrayList<Lottobal> ballen = new ArrayList<Lottobal>();


	public Lottomachine() {
		bol = new Glazenbol(ballen);
		bord = new Scorebord(ballen);
		bol.verzamelAlleBallen();
	}

	public void voerTrekkingUit() {
		bol.shuffleBallen();
		
		for (int i = 0; i < 6; i++) {
			Lottobal bal = ballen.get(i);
			bord.plaatsBal(bal, i);
		}
		
		Lottobal bonusbal = ballen.get(totaalAantalBallenTrekkenPerBeurt);
		bord.plaatsBonusBal(bonusbal, totaalAantalBallenTrekkenPerBeurt);
		bord.sorteerBallen();
		bord.printScoreBord();
	}

	public static int getTotaalaantalballen() {
		return totaalAantalBallen;
	}

}
