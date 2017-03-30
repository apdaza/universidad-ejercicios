import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException{
        try{
        	BufferedReader in = new BufferedReader(new        
                InputStreamReader(System.in));
        
	        int num=0;
	
	        System.out.println(" ingrese un numero ");
	        num = Integer.parseInt(in.readLine());
	        
	        System.out.println("numero: "+num);
        }catch(NumberFormatException e){
        	System.out.println(e.toString());
        }
	}

}
