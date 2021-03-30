/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datos.DBContactos;
import datos.DBTabla;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Contacto;

/**
 *
 * @author Alejo
 */
public class InsertarContacto extends HttpServlet {

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
        DBTabla conDb = new DBContactos();
        try {
            c.setNombre(request.getParameter("txtNombre"));
            c.setApellido(request.getParameter("txtApellido"));
            
            c.setCorreo(request.getParameter("txtCorreo"));
            c.setCelular(request.getParameter("txtCelular"));
            c.setTelefonoDomicilio(request.getParameter("txtTelefonoDomicilio"));
            c.setTelefonoOficina(request.getParameter("txtTelefonoOficina"));
            c.setDireccionResidencia(request.getParameter("txtDireccionDomicilio"));
            c.setDireccionTrabajo(request.getParameter("txtDireccionOficina"));
            
            conDb.insertarRegistro(c);
            
            response.sendRedirect("Inicio");
            
        } finally {            
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
