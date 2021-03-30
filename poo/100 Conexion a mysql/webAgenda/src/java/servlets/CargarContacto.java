/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datos.DBContactos;
import datos.DBTabla;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Contacto;

/**
 *
 * @author Alejo
 */
public class CargarContacto extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Contacto c = new Contacto();
        DBTabla conDB = new DBContactos();
        try {
            int conId = Integer.parseInt(request.getParameter("item"));
            String opc = request.getParameter("op");
            out.write(opc);
            ResultSet res = conDB.getRegistroById(conId);
            if(res.next()){
                c.setId(res.getInt("con_id"));
                c.setNombre(res.getString("con_nombre"));
                c.setApellido(res.getString("con_apellido"));
                c.setTelefonoDomicilio(res.getString("con_telefono_domicilio"));
                c.setTelefonoOficina(res.getString("con_telefono_oficina"));
                c.setCelular(res.getString("con_celular"));
                c.setCorreo(res.getString("con_correo"));
                c.setDireccionResidencia(res.getString("con_direccion_residencia"));
                c.setDireccionTrabajo(res.getString("con_direccion_trabajo"));
            }
            
            if(opc.equals("edit")){
                request.getSession().setAttribute("contacto", c);
                response.sendRedirect("editar_contacto.jsp");
            }
            if(opc.equals("delete")){
                conDB.borrarRegistro(c);
                response.sendRedirect("Inicio");
            }
        }catch(Exception e){
            
        }finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
