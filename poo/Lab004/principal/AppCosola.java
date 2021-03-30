package principal;

import figuras.*;

public class AppCosola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado c = new Cuadrado();
		Rectangulo r = new Rectangulo();
		
		c.setLado(5);
		c.calcularArea();
		c.calcularPerimetro();
		
		System.out.println("El cuadrado de lado "+c.getLado()+" tiene un area de "+c.getArea());
	}

}
