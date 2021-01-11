
public class ChuckALuckSpel {
	public Beker beker;
	private int nDobbelstenen = 3;
	public int inzetSpelerTotaal;
	private int geluksGetal;
	private static int huidigeRonde = 0;

	public ChuckALuckSpel(int inzetSpeler) {
		beker = new Beker(nDobbelstenen);
		this.inzetSpelerTotaal = inzetSpeler;
	}

	public void speelRonde(int geluksGetal, int inzetBeurt) {
		while (inzetSpelerTotaal > 0) {
			if (geluksGetal > 0 && geluksGetal <= beker.getnOgenDobbelsteen()) {
				huidigeRonde += 1;
				this.geluksGetal = geluksGetal;
				beker.werpBeker();
				geefSpelerGeldTerug(inzetBeurt);
				System.out.println("Huidige ronde: " + huidigeRonde);
				System.out.println("Uw geluksgetal:          " + geluksGetal);
				printDobbelstenen();
				System.out.println("Saldo na beurt: " + inzetSpelerTotaal);
				System.out.println("--------------------------------------");
			} else {
				System.out.println("Geluksgetal moet gelijk of lager zijn dan het aantal ogen op een dobbelsteen");
				System.out.println("--------------------------------------");
			}
		}
		while (inzetSpelerTotaal <= 0) {
			System.out.println("Werp meer geld in alstublieft.");
			break;
		}
	}

	public int aantalOgenGelijkAanGetal(int geluksGetal) {
		int aantalGelijk = 0;
		for (int i = 0; i < nDobbelstenen; i++) {
			Dobbelsteen d = beker.dobbelstenen.get(i);
			if (vergelijkGetal(geluksGetal, d.huidigGetal)) {
				aantalGelijk += 1;
			}
		}

		return aantalGelijk;
	}

	public void geefSpelerGeldTerug(int inzetBeurt) {
		int aantalGelijk = aantalOgenGelijkAanGetal(geluksGetal);
		if (aantalGelijk == 0) {
			inzetSpelerTotaal -= inzetBeurt;
		} else if (aantalGelijk == 1) {
			inzetSpelerTotaal = inzetSpelerTotaal;
		} else if (aantalGelijk == 2) {
			inzetSpelerTotaal += inzetBeurt;
		} else if (aantalGelijk == 3) {
			inzetSpelerTotaal += (inzetBeurt * 10);
		}
	}

	public boolean vergelijkGetal(int getal1, int getal2) {
		return getal1 == getal2;
	}

	public void printDobbelstenen() {
		System.out.println("Worp door de computer: " + beker.dobbelstenen.get(0).huidigGetal + " "
				+ beker.dobbelstenen.get(1).huidigGetal + " " + beker.dobbelstenen.get(2).huidigGetal);
	}

}
