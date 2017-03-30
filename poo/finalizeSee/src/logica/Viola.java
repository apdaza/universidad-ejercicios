package logica;

public class Viola extends Cuerda{
	public Viola(){
		System.out.println("Se ha creado una viola");
	}
	protected void finalize(){
		super.finalize();
		System.out.println("Se ha destruido una viola");
	}
}
