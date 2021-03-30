import java.io.File;


public class ListaArchivos {
	public static void main(String[] args) {
		File f = new File("/home/alejo");
		String[] lista = f.list();
		for(int i=0;i<lista.length;i++){
			System.out.println(lista[i]);
		}
	}
}
