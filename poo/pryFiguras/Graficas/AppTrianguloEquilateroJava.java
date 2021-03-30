package Graficas;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class AppTrianguloEquilateroJava implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JLabel lblBase, lblAltura, lblArea, lblPerimetro;
	JTextField txtBase, txtAltura, txtArea, txtPerimetro;
	JButton btnAceptar;
	
	TrianguloEquilatero t;
	public AppTrianguloEquilateroJava(){
		t=new TrianguloEquilatero();
		
		frame = new JFrame("AppTrianguloEquilatero");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel(new GridLayout(4,2));
		
		lblBase=new JLabel("Base : ",SwingConstants.RIGHT);
		lblAltura=new JLabel("Altura : ",SwingConstants.RIGHT);
		lblArea=new JLabel("Area : ",SwingConstants.RIGHT);
		lblPerimetro=new JLabel("Perimetro : ",SwingConstants.RIGHT);
		
		txtBase = new JTextField(2);
		txtAltura = new JTextField(2);
		txtArea = new JTextField(20);
		txtPerimetro = new JTextField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		frame.getRootPane().setDefaultButton(btnAceptar);
		
		panel.add(lblBase);
		panel.add(txtBase);
		panel.add(lblAltura);
		panel.add(txtAltura);
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
		
		t.setBase((double)Double.parseDouble(txtBase.getText()));
		t.setAltura((double)Double.parseDouble(txtAltura.getText()));
		t.setArea();
		t.setPerimetro();
		
		txtPerimetro.setText(String.valueOf(t.getPerimetro()));
		txtArea.setText(String.valueOf(t.getArea()));
		
	}
	
	public static void main (String[]args){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppTrianguloEquilateroJava a =new AppTrianguloEquilateroJava();
		
	}
	
	
}

