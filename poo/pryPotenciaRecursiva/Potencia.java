import java.util.Random;
public class Potencia {

	public static void main(String[] args) {
		int base = new Random().nextInt(10);
		int exp = new Random().nextInt(5);
		System.out.println(base + " elevado a " + exp + " = " +potenciar(base,exp));
	}
	
	static int potenciar(int base,int exp){
		int p;
		if(exp > 1){
			p = base * potenciar(base,exp-1);
		}else{
			p = base;
		}
		return p; 
	}

}
