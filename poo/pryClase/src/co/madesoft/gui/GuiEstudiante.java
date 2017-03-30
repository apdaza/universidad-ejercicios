package co.madesoft.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import co.madesoft.db.*;

public class GuiEstudiante implements ActionListener {
	
	JFrame frame;
    JScrollPane spEstudiantes,spNotas;
    DefaultTableModel dtmEstudiantes,dtmNotas;
    JTable jtbEstudiantes,jtbNotas;
    JPanel pnlEstudiantes;
    JLabel lblCodigo,lblNombre;
    JTextField txtCodigo,txtNombre;
    Object[][] dtEstudiantes;
    Object[][] dtNotas;
    DbEstudiante us = new DbEstudiante();
    
    int fila = -1;
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		GuiEstudiante g = new GuiEstudiante();
	}

	public GuiEstudiante(){
		frame = new JFrame("Notas de estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dtEstudiantes = us.getEstudiantes();
        
        String[] columNames = {"codigo","nombres"};      
        dtmEstudiantes= new DefaultTableModel(dtEstudiantes, columNames);
        
        String[] columNamesNotas = {"codigo","asignatura","nota"};
        dtmNotas = new DefaultTableModel(dtNotas,columNamesNotas);
                
        jtbEstudiantes = new JTable(dtmEstudiantes);
        jtbEstudiantes.setPreferredScrollableViewportSize(new Dimension(500, 120));
         
        jtbNotas = new JTable(dtmNotas);
        jtbNotas.setPreferredScrollableViewportSize(new Dimension(500,80));
        
        spEstudiantes = new JScrollPane(jtbEstudiantes);
        spNotas = new JScrollPane(jtbNotas);
        
        lblCodigo = new JLabel("Codigo");
        lblNombre = new JLabel("Nombre");
        
        txtCodigo = new JTextField(10);
        txtNombre = new JTextField(10);

        pnlEstudiantes = new JPanel(new GridLayout(2,2));
        pnlEstudiantes.add(lblCodigo);
        pnlEstudiantes.add(txtCodigo);
        pnlEstudiantes.add(lblNombre);
        pnlEstudiantes.add(txtNombre);

        jtbEstudiantes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                fila = jtbEstudiantes.rowAtPoint(e.getPoint());
                int columna = jtbEstudiantes.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)){
                    txtCodigo.setText(String.valueOf(jtbEstudiantes.getValueAt(fila,0)));
                    txtNombre.setText(String.valueOf(jtbEstudiantes.getValueAt(fila,1)));
                    
                    dtNotas = us.getNotasByEstudiante(String.valueOf(jtbEstudiantes.getValueAt(fila,0)));
                    int contRows = dtmNotas.getRowCount();
                    for(int i=0;i<contRows;i++){
                    	dtmNotas.removeRow(0);
                    }
                    for(int i=0;i<dtNotas.length;i++){
                    	Object[] newRow={dtNotas[i][0],dtNotas[i][1],dtNotas[i][2]};
                        dtmNotas.addRow(newRow);
                    }
                }
            }
        });
                
        frame.getContentPane().add(spEstudiantes,BorderLayout.NORTH);
        frame.getContentPane().add(pnlEstudiantes,BorderLayout.CENTER);
        frame.getContentPane().add(spNotas,BorderLayout.SOUTH);
        
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(frame.getParent());
        frame.setVisible(true);
    }
    
    public void limpiarCampos(){
        txtCodigo.setText("");
        txtNombre.setText("");
    }
    
    public void actionPerformed(ActionEvent e){
        int resultado = -1;
    }
}
