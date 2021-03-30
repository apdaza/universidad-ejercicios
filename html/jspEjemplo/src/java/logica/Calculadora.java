/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 *
 * @author alejo
 */
public class Calculadora {

    public String procesar(String cad){
        String[] cad2 = cad.split(" ");

            float num1=0;
            char op='n';
            for(int x=0;x<cad2.length;x++){
                if(x%2!=0)op=cad2[x].charAt(0);
                else{
                    switch(op){
                        case 'n':
                            num1=Float.parseFloat(cad2[x]);
                            break;
                        case '+':
                            num1+=Float.parseFloat(cad2[x]);
                            break;
                        case '-':
                            num1-=Float.parseFloat(cad2[x]);
                            break;
                        case '*':
                            num1*=Float.parseFloat(cad2[x]);
                            break;
                        case '/':
                            num1/=Float.parseFloat(cad2[x]);
                            break;
                    }
                }
            }

            return String.valueOf(num1);
    }

}
