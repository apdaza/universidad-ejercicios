package logica;

public class Violin extends Cuerda{
	public Violin(){
		System.out.println("Se ha creado una violin");
	}
	protected void finalize(){
		super.finalize();
		System.out.println("Se ha destruido un violin");
	}
}
