package co.com.apdaza.polimorfismo.app;

import co.com.apdaza.polimorfismo.base.*;

public class AppFiguras {

	public static Figura figuraAleatoria(){
		switch((int)(Math.random() * 4)) {
	       default:
	       case 0: return new Circulo();
	       case 1: return new Cuadrado();
	       case 2: return new Triangulo();
	       case 3: return new Figura();
		}
	}
	public static void main(String[] args) {
		Figura[] fig = new Figura[4];
		
		for(int i=0;i<4;i++){
			fig[i]=figuraAleatoria();
		}
		
		for(int i=0;i<4;i++){
			fig[i].dibujar();
		}

	}

}
