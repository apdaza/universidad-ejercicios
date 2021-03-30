package logica;

public class Guitarra extends Cuerda{
	public Guitarra(){
		System.out.println("Se ha creado una guitarra");
	}
	protected void finalize(){
		super.finalize();
		System.out.println("Se ha destruido una guitarra");
	}
}
