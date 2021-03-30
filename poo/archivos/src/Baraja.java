import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baraja {
	final static int TAM = 10;
	static String linea;
	static int arreglo[][];
	public static void main(String[] args){
		int c;
		arreglo = new int[2][50];
		StringTokenizer token;
		for(int i=0;i<TAM;i++){
			linea = leerCadena();
			token = new StringTokenizer(linea);
			c=0;
			while(token.hasMoreTokens()){
				arreglo[c][i]=Integer.valueOf(token.nextToken()).intValue();
				//arreglo[1][i]=Integer.valueOf(token.nextToken()).intValue();
				c++;
			}
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
