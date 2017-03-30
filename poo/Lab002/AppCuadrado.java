/** Clase AppCuadrado
 * 
 * creada en el laboratorio 002
 * 
 * ejemplo de una clase ejecutable que crea una instaciada de una clase plana
 * 
 * @author alejo
 *
 */

import java.util.Random;
public class AppCuadrado {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rnd = new Random();
		Cuadrado c = new Cuadrado();
		c.setLado((rnd.nextInt(10)));
		c.calcularArea();
		System.out.println("El cuadrado de lado "+c.getLado());
		System.out.println("Tiene un area de "+c.getArea());

	}

}
