import java.io.File;
import java.io.FileNotFoundException;


public class PropiedadesArchivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("/home/alejo/entrada.txt");
		if(f.exists()){
			System.out.println("Nombre del archivo "+f.getName());
	        System.out.println("Camino             "+f.getPath());
	        System.out.println("Camino absoluto    "+f.getAbsolutePath());
	        System.out.println("Se puede escribir  "+f.canRead());
	        System.out.println("Se puede leer      "+f.canWrite());
	        System.out.println("Tamaño             "+f.length());
		}
	}

}
