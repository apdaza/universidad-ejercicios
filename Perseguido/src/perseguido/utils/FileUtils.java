/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daza
 */
public class FileUtils {

    public int getFileRowsCount(String filePath) {
        int rows = 0;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                sc.nextLine();
                rows++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    public int getFileColsCount(String filePath) {
        int cols = 0;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                int count = sc.nextLine().split(" ").length;
                if (count > cols) {
                    cols = count;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cols;
    }

    public String[][] fileToMatriz(String filePath) {
        String[][] matriz = new String[getFileRowsCount(filePath)][getFileColsCount(filePath)];
        int fila = 0;
        String[] linea;
        try {
            Scanner sc = new Scanner(new File(getClass().getResource(filePath).getPath()));
            while (sc.hasNext()) {
                int col = 0;
                linea = sc.nextLine().split(" ");
                for (int i = 0; i < linea.length; i++) {
                    matriz[fila][i] = linea[i];
                }
                fila++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;
    }

    public void showAsMatriz(String filePath) {
        String[][] matriz = fileToMatriz(filePath);
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println("");
        }
    }

    public void trasponer(String filePath) {
        
        try {
            //File inputFile = new File("prueba.txt");
            File outputFile = new File("outagain.txt");

            //FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            String[][] matriz = fileToMatriz(filePath);
            String[][] matriz2 = new String[matriz[0].length][matriz.length];
            for (int f = 0; f < matriz2.length; f++) {
                for (int c = 0; c < matriz2[f].length; c++) {
                    matriz2[f][c] = matriz[c][f];
                    //fos.write(matriz[f][c].charAt(0));
                    //fos.write(' ');
                }
                //fos.write('\n');
            }
            for (int f = 0; f < matriz2.length; f++) {
                for (int c = 0; c < matriz2[f].length; c++) {
                    //matriz2[f][c] = matriz[c][f];
                    fos.write(matriz2[f][c].charAt(0));
                    fos.write(' ');
                }
                fos.write('\n');
            }

            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }

}
