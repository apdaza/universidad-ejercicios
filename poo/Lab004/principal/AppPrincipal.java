/*
 * AppPrincipal.java
 *
 * Created on 16 de agosto de 2007, 04:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figuras.*;

/**
 *
 * @author alejo
 */
public class AppPrincipal implements ActionListener{
    JFrame jfrFrame;
    JPanel jpnCuadrado,jpnRectangulo,jpnResultado;
    JTabbedPane jtpPestanas;
    JLabel jlbLado,jlbBase,jlbAltura,jlbArea,jlbPerimetro,jlbNulo;
    JTextField txtLado,txtBase,txtAltura,txtArea,txtPerimetro;
    JButton jbtAceptar,jbtCancelar;
    Cuadrado c;
    Rectangulo r;
        
    public AppPrincipal() {
        jfrFrame = new JFrame("Aplicación de Figuras");
        jfrFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrFrame.setPreferredSize(new Dimension(500,200));
        jpnCuadrado = new JPanel(new GridLayout(2,2));
        jpnRectangulo = new JPanel(new GridLayout(2,2));
        jpnResultado = new JPanel(new GridLayout(3,2));
        c = new Cuadrado();
        r = new Rectangulo();
        
        jtpPestanas = new JTabbedPane();
        
        jlbLado = new JLabel("Lado:",SwingConstants.RIGHT);
        jlbBase = new JLabel("Base:",SwingConstants.RIGHT);
        jlbAltura = new JLabel("Altura:",SwingConstants.RIGHT);
        jlbArea = new JLabel("Area");
        jlbPerimetro = new JLabel("Perimetro");
        jlbNulo = new JLabel("");
        txtLado = new JTextField(5);
        txtBase = new JTextField(5);
        txtAltura = new JTextField(5);
        txtArea = new JTextField(5);
        txtPerimetro = new JTextField(5);
        
        jbtAceptar = new JButton("Aceptar");
        jbtCancelar = new JButton("Cancelar");
        
        jbtAceptar.addActionListener(this);
        jbtCancelar.addActionListener(this);
             
        jpnCuadrado.add(jlbLado);
        jpnCuadrado.add(txtLado);
        jpnCuadrado.add(jlbNulo);
        jpnCuadrado.add(jlbNulo);
        
        jpnRectangulo.add(jlbBase);
        jpnRectangulo.add(txtBase);
        jpnRectangulo.add(jlbAltura);
        jpnRectangulo.add(txtAltura);
        
        jpnResultado.add(jlbArea);
        jpnResultado.add(txtArea);
        jpnResultado.add(jlbPerimetro);
        jpnResultado.add(txtPerimetro);
        jpnResultado.add(jbtAceptar);
        jpnResultado.add(jbtCancelar);
        
        jtpPestanas.addTab("Cuadrado",jpnCuadrado);
        jtpPestanas.addTab("Rectangulo",jpnRectangulo);
        
        jfrFrame.getContentPane().add(jtpPestanas,BorderLayout.NORTH);
        jfrFrame.getContentPane().add(jpnResultado,BorderLayout.SOUTH);
        
        jfrFrame.pack();
        jfrFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand()==jbtAceptar.getText()){
            if(jtpPestanas.getSelectedIndex()==0){
                c.setLado(Integer.parseInt(txtLado.getText()));
                c.calcularArea();
                c.calcularPerimetro();
                txtArea.setText(String.valueOf(c.getArea()));
                txtPerimetro.setText(String.valueOf(c.getPerimetro()));
            }
            if(jtpPestanas.getSelectedIndex()==1){
                r.setBase(Integer.parseInt(txtBase.getText()));
                r.setAltura(Integer.parseInt(txtAltura.getText()));
                r.calcularArea();
                r.calcularPerimetro();
                txtArea.setText(String.valueOf(r.getArea()));
                txtPerimetro.setText(String.valueOf(r.getPerimetro()));
            }
        }else{
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args){
        AppPrincipal a = new AppPrincipal();
    }
    
    
}
