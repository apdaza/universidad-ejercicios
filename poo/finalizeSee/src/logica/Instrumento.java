package logica;

public class Instrumento {
	public Instrumento(){
		System.out.println("Se ha creado un instrumento");
	}
	
	protected void finalize(){
		System.out.println("Se ha destruido un instrumento");
	}

}
