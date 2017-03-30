/*
 * Figura.java
 *
 * Created on 16 de agosto de 2007, 05:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package figuras;

/**
 *
 * @author alejo
 */
public class Figura {
    double area;
    double perimetro;
    /** Creates a new instance of Figura */
    public Figura() {
        this.area=0;
        this.perimetro=0;
    }
    
    public double getArea(){
        return this.area;
    }
    
    public double getPerimetro(){
        return this.perimetro;
    }
}
