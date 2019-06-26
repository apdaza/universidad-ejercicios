package co.madesoft.excepciones;

public class Arreglos {
	String cadenas[]= {"Cadena Uno","Cadena Dos","Cadena Tres"};

    public void imprimirArreglo(int i){
        try{
            System.out.println(cadenas[i]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("excepción capturada: "+e.toString());
        }catch(Exception e){
            System.out.println("excepción capturada: "+e.toString());
        }
    }
}
