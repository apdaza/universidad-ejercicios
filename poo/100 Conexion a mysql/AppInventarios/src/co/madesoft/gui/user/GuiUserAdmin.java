/*
 * GuiUserAdmin.java
 *
 * Created on 7 de diciembre de 2006, 8:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package co.madesoft.gui.user;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import co.madesoft.db.*;
/**
 *
 * @author alejo
 */
public class GuiUserAdmin implements ActionListener{
    JFrame frame;
    JScrollPane spnTabla;
    DefaultTableModel dtm;
    JTable jtbUsuarios;
    JPanel pnlBotones,pnlUsuario,pnlPanel;
    JLabel lblId,lblUsuario,lblClave,lblNombres,lblApellidos,lblEstado,lblRoles;
    JTextField txtId,txtUsuario,txtNombres,txtApellidos,txtEstado;
    JPasswordField jpfClave;
    JButton btnAgregar, btnEditar, btnBorrar;
    JComboBox cmbRoles;
    Object[][] data;
    Object[][] dtRoles;
    String[] strNombreRol;
    DbUser us = new DbUser();
    DbRol rol = new DbRol();
    
    int fila = -1;//fila afectada para editar usuarios
    
    /** Creates a new instance of GuiUserAdmin */
    public GuiUserAdmin() {
        frame = new JFrame("Administrar Usuarios");
        
        //DbUser us = new DbUser();
        
        data = us.getUsuarios();
        
        String[] columNames = {"id","usuario","nombres","apellidos","estados"};
        
        dtm= new DefaultTableModel(data, columNames);
        
        jtbUsuarios = new JTable(dtm);
        jtbUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 150));
                
        spnTabla = new JScrollPane(jtbUsuarios);
        
        
        
        lblId = new JLabel("Id");
        lblUsuario = new JLabel("Usuario");
        lblClave = new JLabel("Clave");
        lblNombres = new JLabel("Nombres");
        lblApellidos = new JLabel("Apellidos");
        lblEstado = new JLabel("Estado");
        
        lblRoles= new JLabel("Rol");
        
        txtId = new JTextField(10);
        txtUsuario = new JTextField(10);
        txtNombres = new JTextField(10);
        txtApellidos = new JTextField(10);
        txtEstado = new JTextField(10);
        jpfClave = new JPasswordField(10);
        
        dtRoles = rol.getRoles();   
        strNombreRol = new String[dtRoles.length];
        for(int a=0;a<dtRoles.length;a++){
            strNombreRol[a]=String.valueOf(dtRoles[a][1]);
        }
        cmbRoles = new JComboBox(strNombreRol);
        
        pnlUsuario = new JPanel(new GridLayout(7,2));
        
        pnlUsuario.add(lblId);
        pnlUsuario.add(txtId);
        pnlUsuario.add(lblUsuario);
        pnlUsuario.add(txtUsuario);
        pnlUsuario.add(lblClave);
        pnlUsuario.add(jpfClave);
        pnlUsuario.add(lblNombres);
        pnlUsuario.add(txtNombres);
        pnlUsuario.add(lblApellidos);
        pnlUsuario.add(txtApellidos);
        pnlUsuario.add(lblEstado);
        pnlUsuario.add(txtEstado);
        pnlUsuario.add(lblRoles);
        pnlUsuario.add(cmbRoles);
        
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnBorrar = new JButton("Borrar");
        
        
        btnAgregar.addActionListener(this);
        btnEditar.addActionListener(this);
        btnBorrar.addActionListener(this);
        
        
        pnlBotones = new JPanel(new GridLayout(1,3));
        
        pnlBotones.add(btnAgregar);
        pnlBotones.add(btnEditar);
        pnlBotones.add(btnBorrar);
        
        
        
        jtbUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                fila = jtbUsuarios.rowAtPoint(e.getPoint());
                int columna = jtbUsuarios.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)){
                    txtId.setText(String.valueOf(jtbUsuarios.getValueAt(fila,0)));
                    txtUsuario.setText(String.valueOf(jtbUsuarios.getValueAt(fila,1)));
                    txtNombres.setText(String.valueOf(jtbUsuarios.getValueAt(fila,2)));
                    txtApellidos.setText(String.valueOf(jtbUsuarios.getValueAt(fila,3)));
                    txtEstado.setText(String.valueOf(jtbUsuarios.getValueAt(fila,4)));
                }
            }
        });
        
                
        
                
        frame.getContentPane().add(spnTabla,BorderLayout.NORTH);
        frame.getContentPane().add(pnlUsuario,BorderLayout.CENTER);
        frame.getContentPane().add(pnlBotones,BorderLayout.SOUTH);
        
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(frame.getParent());
        frame.setVisible(true);
    }
    
    public void limpiarCampos(){
        txtId.setText("");
        txtUsuario.setText("");
        jpfClave.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEstado.setText("");
    }
    
    public void actionPerformed(ActionEvent e){
        int resultado = -1;
        if(e.getSource()==btnEditar){
            int i = Integer.parseInt(txtId.getText());
            String u = txtUsuario.getText();
            String c = String.copyValueOf(jpfClave.getPassword());
            String n = txtNombres.getText();
            String a = txtApellidos.getText();
            String s = txtEstado.getText();
            int index = cmbRoles.getSelectedIndex();
            int r = (int)(Integer.parseInt(String.valueOf(dtRoles[index][0])));
            resultado = us.updateUsuario(i,u,c,n,a,s,r);
            if(resultado==0){
                dtm.setValueAt(u,fila,1);
                dtm.setValueAt(n,fila,2);
                dtm.setValueAt(a,fila,3);
                dtm.setValueAt(s,fila,4);
                limpiarCampos();
            }
        }
        
        //insertUsuario
        if(e.getSource()==btnAgregar){
            
            String u = txtUsuario.getText();
            String c = String.copyValueOf(jpfClave.getPassword());
            String n = txtNombres.getText();
            String a = txtApellidos.getText();
            String s = txtEstado.getText();
            int index = cmbRoles.getSelectedIndex();
            int r = (int)(Integer.parseInt(String.valueOf(dtRoles[index][0])));
            resultado = us.insertUsuario(u,c,n,a,s,r);
            if(resultado>0){
                Object[] newRow={resultado,u,n,a,s};
                dtm.addRow(newRow);
                limpiarCampos();
            }
        }
        
        //deleteUsuario(int id)
        if(e.getSource()==btnBorrar){
            int i = Integer.parseInt(txtId.getText());
            
            resultado = us.deleteUsuario(i);
            if(resultado==0){
                dtm.removeRow(fila);
                limpiarCampos();
            }
        }
        System.out.println(resultado);
    }
    
    
    
}
