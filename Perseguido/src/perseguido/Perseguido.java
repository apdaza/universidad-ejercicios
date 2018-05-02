/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import perseguido.gui.Principal;
import perseguido.utils.FileUtils;

/**
 *
 * @author daza
 */
public class Perseguido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileUtils fu = new FileUtils();
        System.out.println("filas " + fu.getFileRowsCount("../archivos/matriz_002.txt"));
        System.out.println("columnas " + fu.getFileColsCount("../archivos/matriz_002.txt"));
        String[][] matriz = fu.fileToMatriz("../archivos/matriz_001.txt");
        Principal p = new Principal();
        
        p.cargarLaberinto(matriz);
        
        p.setVisible(true);
        
        fu.showAsMatriz("../archivos/matriz_002.txt");
        //fu.trasponer("../archivos/matriz_001.txt");
        

    }

    

}
