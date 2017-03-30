package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lectura {
	public int leerEntero(){
		int num=0;
		InputStreamReader reader =new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(reader);
		try {
			num=Integer.parseInt(buffer.readLine());			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción numerica");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en lectura");
		}
		return num;
	}
	
	public String leerCadena(){
		String cad = new String("");
		InputStreamReader reader =new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(reader);
		try{
			cad = buffer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en lectura");
		}
		
		return cad;
	}
	

}
