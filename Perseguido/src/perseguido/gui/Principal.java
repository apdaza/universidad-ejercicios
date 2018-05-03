/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.gui;

import java.io.File;
import javax.swing.JFrame;
import perseguido.utils.FileUtils;

/**
 *
 * @author daza
 */
public class Principal extends JFrame{
    Lienzo lienzo = new Lienzo();
    FileUtils fu = new FileUtils();
    String[][] matriz;
    
    public Principal(){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        String archivo = fu.archivoAleatorio("../archivos");
        matriz = fu.fileToMatriz("../archivos/" + archivo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(lienzo);
        add(lienzo);
        pack();
        setBounds(0, 0, matriz.length * 32, 40 + matriz[0].length * 32);
        lienzo.iniciarLienzo(matriz);
        lienzo.setBounds(0, 0, matriz.length * 32, matriz[0].length * 32);
    }
    
}
