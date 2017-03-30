/*
 * Reactangulo.java
 *
 * Created on 16 de agosto de 2007, 07:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package figuras;


/**
 *
 * @author alejo
 */
public class Rectangulo extends Figura implements IFigura{
    int base;
    int altura;
    
    public void setBase(int base){
        this.base = base; 
    }
    
    public int getBase(){
        return this.base;
    }
    
    public void setAltura(int altura){
        this.altura = altura; 
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    public void calcularArea(){
        this.area = this.base*this.altura;
    }
    
    public void calcularPerimetro(){
        this.perimetro = (2*this.base)+(2*this.altura);
    }
    
}
