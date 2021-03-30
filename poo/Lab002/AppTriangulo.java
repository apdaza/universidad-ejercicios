import java.util.Random;


public class AppTriangulo {
	public static void main(String[] args){
		Random rnd = new Random();
		Triangulo t = new Triangulo();
		t.setAltura(rnd.nextInt(10));
		t.setBase(rnd.nextInt(10));
		t.calcularArea();
		System.out.println("El triangulo con base : "+t.getBase());
		System.out.println("y con altura : "+t.getAltura());
		System.out.println("tiene un area de : "+t.getArea());
	}

}
