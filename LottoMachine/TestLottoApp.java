
public class TestLottoApp {

	public static void main(String[] args) {
		Lottomachine machine = new Lottomachine();
		machine.trekBallen();
		machine.bord.sorteerBallen();
		machine.bord.printScoreBord();
		machine.trekBallen();
		machine.bord.sorteerBallen();
		machine.bord.printScoreBord();
	}

}
