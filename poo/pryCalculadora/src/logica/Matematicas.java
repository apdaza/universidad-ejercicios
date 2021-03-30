/*
 * Matematicas.java
 *
 * Created on 29 de agosto de 2007, 09:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author alejo
 */
public class Matematicas {
    protected int numeroA;
    protected int numeroB;
    protected int resultado;
    protected char operacion;
    
    /** Creates a new instance of Matematicas */
    public Matematicas() {
        this.numeroA = 0;
        this.numeroB = 0;
        this.resultado = 0;
        this.operacion = ' ';
    }
    
    public void setNumeroA(int n){
        this.numeroA = n;
        System.out.println(this.numeroA);
    }
    
    public void setNumeroB(int n){
        this.numeroB = n;
        System.out.println(this.numeroB);
    }
    
    public void setResultado(int n){
        this.resultado = n;
    }
    
    public void setOperacion(char o){
        this.operacion = o;
    }
    
    public int getNumeroA(){
        return this.numeroA;
    }
    
    public int getNumeroB(){
        return this.numeroB;
    }
    
    public int getResultado(){
        return this.resultado;
    }
    
    public char getOperacion(){
        return this.operacion;
    }
        
}
