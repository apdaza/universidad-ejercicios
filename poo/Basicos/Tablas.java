import java.util.Random;

public class Tablas {

	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(10);
		for(int i=1;i<=10;i++){
			System.out.println(a + " * " + i + " = " + a*i);
		}

	}

}
