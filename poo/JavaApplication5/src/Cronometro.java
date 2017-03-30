/*El ejemplo, lo unico que hace es un cronometro, 
 cada segundo imprime el conteo regresivo, primero, 
 la clase Cronometro en el contructor esta recibiendo el 
 total de segundos a regresar, ahi se instancia el Timer, 
 luego se invoca el metodo schedule, el cual recibe como parametro 
 una clase Timertask, la cual para este caso es una clase muy sencilla 
 llamada RemindTask que extiende de TimerTask y que 
 sobreescribe el metodo run().
 
 lo que se encuentre dentro del metodo run es lo que se estara ejecutando cada segundo.
 */



import java.util.Timer;
import java.util.TimerTask;

/**
 * @author crysfel
 * July 26, 2006
 */

public class Cronometro {
    private Timer timer;
    private int segundos;
    
    public Cronometro(int seconds) {
        timer = new Timer();
        segundos = seconds;
        timer.schedule(new RemindTask(),0, 1*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
                segundos--;
                System.out.println(segundos);
                if(segundos<=0){
                    System.out.println("Terminamos la ejecucion del timer");
                    timer.cancel(); 
                }
        }
    }

    public static void main(String args[]) {
            System.out.println("Inicia conteo: 15");
            new Cronometro(15);
    }
} 