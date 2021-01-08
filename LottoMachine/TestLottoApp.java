
public class TestLottoApp {

	public static void main(String[] args) {
		Lottomachine machine = new Lottomachine();
		for(int i = 0; i < 100; i++) {
			machine.voerTrekkingUit();
		}
		
	}

}
