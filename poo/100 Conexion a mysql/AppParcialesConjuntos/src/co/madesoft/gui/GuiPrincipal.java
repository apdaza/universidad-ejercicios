/*
 * GuiPrincipal.java
 *
 * Created on 2 de diciembre de 2006, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package co.madesoft.gui;

import javax.swing.*;
import co.madesoft.db.*;
import java.awt.*;
import java.awt.event.*;
import co.madesoft.gui.user.*;

/**
 *
 * @author alejo
 */
public class GuiPrincipal implements ActionListener{
    String usuario,clave;
    JFrame frame;
    JLabel jlbUsuario;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    Object[][] data;
    /** Creates a new instance of GuiPrincipal */
    public GuiPrincipal(String u,int id) {
        usuario = u;

        frame = new JFrame(usuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DbUser us = new DbUser();

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        data = us.getMenuUsuario(id);

        for (int f=0;f<data.length;f++){
            int m = 0;
            if(String.valueOf(data[f][1]).equals("0")){
                menu = new JMenu(String.valueOf(data[f][0]));
                menuBar.add(menu);
                for (int h=0;h<data.length;h++){
                    if(String.valueOf(data[h][1]).equals("1") && data[h][2].equals(data[f][3])){
                        menuItem = new JMenuItem(String.valueOf(data[h][0]));
                        menuItem.addActionListener(this);
                        menu.add(menuItem);
                    }
                }
                m++;
            }
        }

        jlbUsuario = new JLabel(new ImageIcon("cajas.jpg"));
        frame.getContentPane().add(jlbUsuario,BorderLayout.CENTER);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.pack();
        
        //frame.setSize(800,600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setLocationRelativeTo(frame.getParent());
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String task = null;
        
        for (int f=0;f<data.length;f++){
            if(e.getActionCommand().equals(String.valueOf(data[f][0]))){
                task = String.valueOf(data[f][4]);
            }
        }
        //jlbUsuario.setText(task);
        if(task.equals("salir")){
            System.exit(0);
        }
        //clsSesion
        if(task.equals("clsSesion")){
            frame.setVisible(false);
            GuiInicio gi = new GuiInicio();
        }
        if(task.equals("admUsuario")){
            GuiUserAdmin ua = new GuiUserAdmin();
        }
    }
}
