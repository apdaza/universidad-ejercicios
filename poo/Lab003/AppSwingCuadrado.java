import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AppSwingCuadrado implements ActionListener {
	JFrame frame;
	JPanel panel;
	JTextField txtArea;
	JFormattedTextField txtLado;
	JLabel lblLado,lblArea;
	JButton btnAceptar;
	
	
	public AppSwingCuadrado() {
		//instancio los elementos de la interfaz grafica
		frame = new JFrame("Aplicación Grafica Cuadrado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout(3,2));
		lblLado = new JLabel("Lado:");
		lblArea = new JLabel("Area:");
		txtLado = new JFormattedTextField(new Integer(3));
		txtArea = new JTextField(2);
		btnAceptar = new JButton("Calcular");
		//adiciono un listener al boton
		btnAceptar.addActionListener(this);
		//establesco btnAceptar como boton por defecto
		frame.getRootPane().setDefaultButton(btnAceptar);
		
		txtArea.setEditable(false);
		//adiciono al panel los difrenets elementos
		panel.add(lblLado);
		panel.add(txtLado);
		panel.add(lblArea);
		panel.add(txtArea);
		//adiciono al frame el panel y el boton
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(btnAceptar,BorderLayout.SOUTH);
		//cierro el frame y lo hago visible
		frame.pack();
		frame.setVisible(true);
	}


	public void actionPerformed(ActionEvent arg0) {
		Cuadrado c = new Cuadrado();
		c.setLado((int)Integer.valueOf(txtLado.getText()));
		c.calcularArea();
		txtArea.setText(String.valueOf(c.getArea()));
		
	}


	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppSwingCuadrado a = new AppSwingCuadrado();

	}

}
