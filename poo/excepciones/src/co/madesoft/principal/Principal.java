package co.madesoft.principal;

import java.io.IOException;

import co.madesoft.excepciones.*;

public class Principal {
	public static void main(String[] args) throws IOException{
		int num;
        LecturaTeclado l = new LecturaTeclado();
        Operaciones o = new Operaciones();
        Arreglos a = new Arreglos();
        
        System.out.print("Ingrese el primer valor : ");
        o.setValorUno(l.capturarNumero());
        System.out.print("Ingrese el segundo valor : ");
        o.setValorDos(l.capturarNumero());
        System.out.println("El resultado de la división es : "+o.dividir());
        
        System.out.print("Ingrese el codigo del saludo : ");
        a.imprimirArreglo(l.capturarNumero());
        
        
        
    }
}
