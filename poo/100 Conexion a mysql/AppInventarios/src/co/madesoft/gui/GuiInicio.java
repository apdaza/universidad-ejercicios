/*
 * GuiInicio.java
 *
 * Created on 2 de diciembre de 2006, 13:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package co.madesoft.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import co.madesoft.db.*;
/**
 *
 * @author alejo
 */
public class GuiInicio implements ActionListener{
    JFrame frame;
    JPanel pnlCampos,pnlBotones;
    JLabel jlbUsuario,jlbClave;
    JTextField jtfUsuario;
    JPasswordField jpfClave;
    JButton jbtAceptar,jbtCancelar;

    /** Creates a new instance of GuiInicio */
    public GuiInicio() {
        frame = new JFrame("Login de usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlCampos = new JPanel(new GridLayout(2,2));
        pnlBotones = new JPanel(new GridLayout(1,2));

        jlbUsuario = new JLabel("Usuario",SwingConstants.RIGHT);
        jlbClave = new JLabel("Clave",SwingConstants.RIGHT);

        jtfUsuario = new JTextField(5);
        jpfClave = new JPasswordField(5);

        jbtAceptar = new JButton("Aceptar");
        jbtAceptar.addActionListener(this);
        jbtCancelar = new JButton("Cancelar");
        jbtCancelar.addActionListener(this);

        frame.getRootPane().setDefaultButton(jbtAceptar);

        pnlCampos.add(jlbUsuario);
        pnlCampos.add(jtfUsuario);
        pnlCampos.add(jlbClave);
        pnlCampos.add(jpfClave);
        pnlBotones.add(jbtAceptar);
        pnlBotones.add(jbtCancelar);

        frame.getContentPane().add(pnlCampos,BorderLayout.NORTH);
        frame.getContentPane().add(pnlBotones,BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(frame.getParent());
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtCancelar){System.exit(0);}
		if(e.getSource()==jbtAceptar){
			DbUser us = new DbUser();
			boolean v = us.valUsuario(jtfUsuario.getText(), String.copyValueOf(jpfClave.getPassword()));
			if(v==true){
				int id = us.getIdUsuario(jtfUsuario.getText(), String.copyValueOf(jpfClave.getPassword()));
				GuiPrincipal p = new GuiPrincipal(jtfUsuario.getText(),id);
				frame.setVisible(false);
			}else{
				jtfUsuario.setText("");
				jpfClave.setText("");
			}
			
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		GuiInicio g = new GuiInicio();

	}

    
}
