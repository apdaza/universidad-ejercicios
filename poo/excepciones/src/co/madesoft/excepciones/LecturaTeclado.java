package co.madesoft.excepciones;

import java.io.*;

public class LecturaTeclado {
	public int capturarNumero() throws IOException{
		int num = 0;
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader in = new BufferedReader(isr);
	        num = Integer.parseInt(in.readLine( ));
        }catch(NumberFormatException e){
        	System.out.println("Seprodujo una excepción de tipo numerico "+ e.toString());
        }
        return num;
    }
}
