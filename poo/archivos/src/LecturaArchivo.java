import java.io.*;
import java.util.*;
public class LecturaArchivo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new FileReader("prueba.txt"));
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
		}catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}

	}

}
