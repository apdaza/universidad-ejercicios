package Graficas;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class AppCirculoJava implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JLabel lblRadio, lblArea, lblPerimetro;
	JTextField txtRadio, txtArea, txtPerimetro;
	JButton btnAceptar;
	
	Circulo c;
	public AppCirculoJava(){
		c=new Circulo();
		
		frame = new JFrame("AppCirculo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel(new GridLayout(3,2));
		
		lblRadio=new JLabel("Radio : ",SwingConstants.RIGHT);
		lblArea=new JLabel("Area : ",SwingConstants.RIGHT);
		lblPerimetro=new JLabel("Perimetro : ",SwingConstants.RIGHT);
		
		txtRadio = new JTextField(2);
		txtArea = new JTextField(20);
		txtPerimetro = new JTextField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		frame.getRootPane().setDefaultButton(btnAceptar);
		
		panel.add(lblRadio);
		panel.add(txtRadio);
		panel.add(lblPerimetro);
		panel.add(txtPerimetro);
		panel.add(lblArea);
		panel.add(txtArea);
		
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(btnAceptar,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		c.setRadio((double)Double.parseDouble(txtRadio.getText()));
		c.setArea();
		c.setPerimetro();
		
		txtPerimetro.setText(String.valueOf(c.getPerimetro()));
		txtArea.setText(String.valueOf(c.getArea()));
		
	}
	
	public static void main (String[]args){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppCirculoJava a =new AppCirculoJava();
		
	}
	
	
}
