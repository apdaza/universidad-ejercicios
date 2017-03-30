package logica;

import java.io.*;

public class Ejecutable {
	
	public static void main(String[] args) throws IOException {
		Lectura l = new Lectura();
		Laberinto laberinto = new Laberinto();
		int n;
		System.out.println("Ingrese el valor de n");
		n=l.leerEntero();
		laberinto.setDimension(n);
		laberinto.setLaberinto();
		String cad[] = new String[n];
		int lab[][] = new int[n][n];
		System.out.println("Ingrese linea a linea la configuracion del laberinto");
		for(int i=0;i<n;i++){
			cad[i]=l.leerCadena();
		}
		laberinto.configurarLaberinto(cad);
		System.out.println("Configuracion terminada");
		laberinto.mostrarLaberinto();
		String sol = laberinto.encontrarSalida();
		if(laberinto.getEstado()=='s'){
			System.out.println("la solucion de salida es "+sol);
		}else{
			System.out.println("no existe solucion");
		}
		laberinto.mostrarLaberinto();
	}

}
