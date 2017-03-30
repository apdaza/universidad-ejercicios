
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chamo
 */
public class CrearFormato {
    public static void main(String[] args) {
        try {
            File outputFile = new File("outagain.txt");
            FileOutputStream fos = new FileOutputStream(outputFile);
            int c;
            String cadena = "hola \n mundo";
            for(int x=0;x<cadena.length();x++)
                fos.write((byte)cadena.charAt(x));
            
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }

}
