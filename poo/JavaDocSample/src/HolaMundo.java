import java.util.*;
/** El primer ejemplo de un programa en java
* Muestra un mensaje en patalla con la fecha.
* @author Alejandro Daza
* @author http://apdaza-poo.blogsopt.com
* @version 1.0
*/
public class HolaMundo {
     /** Unico punto de acceso para la clase y la aplicacion
     * @param args arreglo tipo string de parametros
     * @return No tiene retorno
     * @exception no maneja excepciones
     */
     public static void main(String[] args) {
          System.out.println("Hola mundo, hoy es : ");
          System.out.println(new Date());
     }
} ///:~
