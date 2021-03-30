import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baraja2 {
	final static int TAM = 6;
	static String linea;
	static int arreglo[][];
	public static void main(String[] args){
		arreglo = new int[2][50];
		StringTokenizer token;
		int pos;
		for(int i=0;i<TAM;i++){
			linea = leerCadena();
			pos = linea.indexOf(" ");
			arreglo[0][i]=Integer.valueOf(linea.substring(0, pos)).intValue();
			arreglo[1][i]=Integer.valueOf(linea.substring(pos+1, linea.length())).intValue();			
		}
		mezclar();
		for(int i=0;i<TAM;i++){
			System.out.print(arreglo[0][i]+" ");
			System.out.println(arreglo[1][i]+" ");
		}
		
	}
	
	public static void mezclar(){
		int a1[],a2[], m;
		m=TAM/2;
		a1=new int[m];
		a2=new int[m];
		int cont=0;
		for(int i=0;i<m;i++){
			a1[i]=arreglo[1][i];
			a2[i]=arreglo[1][i+m];
		}
		for(int i=0;i<m;i++){
			arreglo[1][cont++]=a1[i];
			arreglo[1][cont++]=a2[i];
		}
	}
	
	
	public static String leerCadena(){
		String cad = new String("");
		InputStreamReader reader =new InputStreamReader(System.in);
		BufferedReader buffer=new BufferedReader(reader);
		try{
			cad = buffer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en lectura");
		}
		
		return cad;
	}

}
