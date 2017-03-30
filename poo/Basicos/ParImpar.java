
import java.util.Random;

public class ParImpar {

	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(100);
		
		if(a%2==0){
			System.out.println(a + " es par");
		}else{
			System.out.println(a + " es impar");
		}
	}

}
