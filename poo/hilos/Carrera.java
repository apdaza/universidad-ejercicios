import logica.*;

public class Carrera {
	public static void main(String[] args){
		new SimpleThread("montoya").start();
		new SimpleThread("barriquelo").start();
		new SimpleThread("massa").start();
		new SimpleThread("shumacher").start();
		new SimpleThread("alonso").start();
	}
}
