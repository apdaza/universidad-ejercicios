
import java.util.Random;

public class AleatoriosHastaCien {

	public static void main(String[] args) {
		Random r = new Random();
		int a = 0;
		while(a<100){
			a = r.nextInt(120);
			System.out.println(a);
		}

	}

}
