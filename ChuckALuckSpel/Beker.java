import java.util.ArrayList;

public class Beker {
	private int nOgenDobbelsteen = 6;
	public ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();

	public Beker(int nDobbelstenen) {
		for (int i = 0; i < nDobbelstenen; i++) {
			Dobbelsteen d = new Dobbelsteen(nOgenDobbelsteen);
			dobbelstenen.add(d);
		}
	}
	
	public void werpBeker() {
		for (Dobbelsteen d : dobbelstenen) {
			int randomIntTussen0EnDobbelsteenOgen = (int) (Math.random() * nOgenDobbelsteen) + 1;
			d.setHuidigGetal(randomIntTussen0EnDobbelsteenOgen);
		}
	}
	
	public int getnOgenDobbelsteen() {
		return nOgenDobbelsteen;
	}

	public void getGetallen() {
		for (Dobbelsteen d : dobbelstenen) {
			d.getHuidigGetal();
		}
	}

}
