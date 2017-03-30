package logica;

public class GrupoMariachi {
	Guitarra guitarra;
	Viola viola;
	Violin violin;
	
	public GrupoMariachi(){
		System.out.println("Se ha creado un grupo mariachi");
		guitarra = new Guitarra();
		viola = new Viola();
		violin = new Violin();
	}
	
	protected void finalize(){
		System.out.println("Se ha destruido un grupo mariachi");
	}
}
