
import java.util.Random;

public class Suma {
	
	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(100);
		int b = r.nextInt(100);
		int s = a + b;
		
		System.out.println(a + " + " + b + " = " + s);
		
	}

}
