package logica;

public class Cuerda extends Instrumento{
	public Cuerda(){
		System.out.println("Se ha creado un instrumento de cuerda");
	}
	protected void finalize(){
		super.finalize();
		System.out.println("Se ha destruido un instrumento de cuerda");
	}
}
