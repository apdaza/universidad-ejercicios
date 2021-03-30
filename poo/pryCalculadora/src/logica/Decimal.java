/*
 * Decimal.java
 *
 * Created on 29 de agosto de 2007, 09:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author alejo
 */
public class Decimal extends Matematicas implements IMatematicas{
    
    /**
     * Creates a new instance of Decimal
     */
    public Decimal() {
    }
    
    public void suma(){
        this.resultado = this.numeroA + this.numeroB;
    }
    public void resta(){
        this.resultado = this.numeroA - this.numeroB;
    }
    public void multiplicacion(){
        this.resultado = this.numeroA * this.numeroB;
    }
    public void division(){
        this.resultado = this.numeroA / this.numeroB;
    }
    
    
    
}
