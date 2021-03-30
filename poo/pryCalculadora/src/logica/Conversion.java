/*
 * Conversion.java
 *
 * Created on 7 de octubre de 2007, 10:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author apdaza
 */
public class Conversion {
    
    public Integer fromHexadecimal(String cad){
        return Integer.parseInt(cad,16);
    }
    
    public Integer fromOctal(String cad){
        return Integer.parseInt(cad,8);
    }
    
    public Integer fromBinario(String cad){
        return Integer.parseInt(cad,2);
    }
    
    public String toHexadecimal(int i){
        return Integer.toHexString(i);
    }
    
    public String toOctal(int i){
        return Integer.toOctalString(i);
    }
    
    public String toBinario(int i){
        return Integer.toBinaryString(i);
    }
    
}
