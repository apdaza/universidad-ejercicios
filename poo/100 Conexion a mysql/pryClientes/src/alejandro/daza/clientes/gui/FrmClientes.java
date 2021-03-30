/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alejandro.daza.clientes.gui;

import alejandro.daza.clientes.datos.DBCliente;
import alejandro.daza.clientes.logica.Cliente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejo
 */
public class FrmClientes implements ActionListener{

    JFrame frame;
    Container contenedor;
    JButton btnInsertar,btnActualizar,btnBorrar;
    JLabel lblCedula, lblNombre, lblApellido, lblTelefono, lblCorreo;
    JTextField txtCedula, txtNombre, txtApellido, txtTelefono, txtCorreo;
    JScrollPane jspClientes;
    DefaultTableModel dtmClientes;
    JTable jtClientes;
    DBCliente bdc = new DBCliente();
    int fila = -1;
    
    public FrmClientes(){
        int x=10,y=10,wx=180,wy=20;
        frame = new JFrame("Clientes");
        contenedor = frame.getContentPane();
        lblCedula = new JLabel("Cedula :");
        lblNombre = new JLabel("Nombre :");
        lblApellido = new JLabel("Apellido :");
        lblTelefono = new JLabel("Telefono :");
        lblCorreo = new JLabel("Correo :");
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        btnInsertar = new JButton("Insertar");
        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Borrar");
        
        Cliente[] arregloClientes = bdc.getClientes();
        Object[][] dtClientes = new Object[arregloClientes.length][5];
        
        for(int j=0;j<arregloClientes.length;j++){
            dtClientes[j][0]=arregloClientes[j].getCedula();
            dtClientes[j][1]=arregloClientes[j].getApellido();
            dtClientes[j][2]=arregloClientes[j].getNombre();
            dtClientes[j][3]=arregloClientes[j].getTelefono();
            dtClientes[j][4]=arregloClientes[j].getCorreo();
        }
        
        String[] columNames = {"cedula","nombres","apellidos","telefono","correo"};  
        dtmClientes = new DefaultTableModel(dtClientes, columNames);
                
        jtClientes = new JTable(dtmClientes);
        jtClientes.setPreferredScrollableViewportSize(new Dimension(550,200));
        jspClientes = new JScrollPane(jtClientes);
        
        contenedor.setLayout(null);
        lblCedula.setBounds(x,y,wx,wy);
        lblNombre.setBounds(x,y+=30,wx,wy);
        lblApellido.setBounds(x,y+=30,wx,wy);
        lblTelefono.setBounds(x,y+=30,wx,wy);
        lblCorreo.setBounds(x,y+=30,wx,wy);
        
        x = 90;
        y = 10;
        
        txtCedula.setBounds(x,y,wx,wy);
        txtNombre.setBounds(x,y+=30,wx,wy);
        txtApellido.setBounds(x,y+=30,wx,wy);
        txtTelefono.setBounds(x,y+=30,wx,wy);
        txtCorreo.setBounds(x,y+=30,wx,wy);
        
        btnInsertar.setBounds(400,10,150,30);
        btnActualizar.setBounds(400,60,150,30);
        btnBorrar.setBounds(400,110,150,30);
        
        jspClientes.setBounds(10, 200, 550, 200);
        
        contenedor.add(lblCedula);
        contenedor.add(lblNombre);
        contenedor.add(lblApellido);
        contenedor.add(lblTelefono);
        contenedor.add(lblCorreo);
        
        contenedor.add(txtCedula);
        contenedor.add(txtNombre);
        contenedor.add(txtApellido);
        contenedor.add(txtTelefono);
        contenedor.add(txtCorreo);
        
        contenedor.add(btnInsertar);
        contenedor.add(btnActualizar);
        contenedor.add(btnBorrar);
        
        contenedor.add(jspClientes);
        
        btnInsertar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnBorrar.addActionListener(this);
        
        jtClientes.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                fila = jtClientes.rowAtPoint(e.getPoint());
                int columna = jtClientes.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)){
                    txtCedula.setText(String.valueOf(jtClientes.getValueAt(fila,0)));
                    txtApellido.setText(String.valueOf(jtClientes.getValueAt(fila,1)));
                    txtNombre.setText(String.valueOf(jtClientes.getValueAt(fila,2)));
                    txtTelefono.setText(String.valueOf(jtClientes.getValueAt(fila,3)));
                    txtCorreo.setText(String.valueOf(jtClientes.getValueAt(fila,4)));
                }
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        frame.setBounds(0,0,580,500);
        
        frame.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnInsertar){
            Cliente cl = new Cliente();
            cl.setCedula(txtCedula.getText());
            cl.setApellido(txtApellido.getText());
            cl.setNombre(txtNombre.getText());
            cl.setTelefono(txtTelefono.getText());
            cl.setCorreo(txtCorreo.getText());
            cl.crearCliente();
            actualizarTabla();
            limpiarCampos();
        }
        if(e.getSource()==btnActualizar){
            Cliente cl = new Cliente();
            cl.setCedula(txtCedula.getText());
            cl.setApellido(txtApellido.getText());
            cl.setNombre(txtNombre.getText());
            cl.setTelefono(txtTelefono.getText());
            cl.setCorreo(txtCorreo.getText());
            cl.actualizarCliente();
            actualizarTabla();
            limpiarCampos();
        }
        if(e.getSource()==btnBorrar){
            Cliente cl = new Cliente();
            cl.setCedula(txtCedula.getText());
            cl.borrarCliente();
            actualizarTabla();
            limpiarCampos();
        }
    }
    
    public void actualizarTabla(){
        int cont = dtmClientes.getRowCount();
        Cliente cl = new Cliente();
        for(int j=0;j<cont;j++)dtmClientes.removeRow(0);
        Cliente[] arregloClientes = cl.getClientes();
        for(int j=0;j<arregloClientes.length;j++){
           Object obj[] = new Object[5];
           obj[0]=arregloClientes[j].getCedula();
           obj[1]=arregloClientes[j].getApellido();
           obj[2]=arregloClientes[j].getNombre();
           obj[3]=arregloClientes[j].getTelefono();
           obj[4]=arregloClientes[j].getCorreo();
           dtmClientes.addRow(obj);
        }
    }
    
    public void limpiarCampos(){
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
}
