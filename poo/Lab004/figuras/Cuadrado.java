/*
 * Cadrado.java
 *
 * Created on 16 de agosto de 2007, 07:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package figuras;


/**
 *
 * @author alejo
 */
public class Cuadrado extends Figura implements IFigura{
    int lado;
    
    public void setLado(int lado){
        this.lado = lado;
    }
    
    public int getLado(){
        return this.lado;
    }
    
    public void calcularArea(){
        this.area = this.lado*this.lado;
    }
    
    public void calcularPerimetro(){
        this.perimetro = 4*this.lado;
    }
}
