/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuota;
import Modelo.CuotaBD;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.ProductoBD;
import Modelo.Venta;
import Modelo.VentaBD;
import Modelo.cliente;
import Modelo.clienteBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Conexion.getConexion;

/**
 *
 * @author LpKido
 */
public class controlador extends HttpServlet {

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session=request.getSession();
            
            
        Producto p = new Producto();
        //request.getParameter --> Sirve para obtener los valores de las cajas de texto
        p.setNombre(request.getParameter("txtNombre"));
        p.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        p.setImagen(request.getParameter("txtImagen"));
        boolean rpta = ProductoBD.insertarProducto(p);
        if (rpta) {
            //Si inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=Se registro del producto de manera correcta");
        } else {
            //Si no se inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
            response.sendRedirect("mensaje.jsp?men=No se registro el producto");
        }
    }
   
       //Metodo que sirve para actualizar un producto
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p = new Producto();
        p.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        p.setNombre(request.getParameter("txtNombre").toUpperCase());
        p.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        boolean rpta = ProductoBD.actualizarProducto(p);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se actualizo el producto de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se actualizo el producto");
        }
    }
    
    //Sirve para añadir un detalle al carrito
    //La informacion del carrito de compras se guarda en una sesion
    private void anadirCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos la sesion actual
        HttpSession sesion = request.getSession();
        //creamos una variable d etipo arraylist que almacene el detalle
        //de la venta
        ArrayList<DetalleVenta> carrito;
        //Si no existe la sesion creamos al carrito de compras
        if (sesion.getAttribute("carrito") == null) {
            carrito = new ArrayList<DetalleVenta>();
        } else {
            carrito = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");
        }
        //Obtenemos el producto que deseamos añadir al carrito
        Producto p = ProductoBD.obtenerProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        //Creamos un detalle para el carrtio
        DetalleVenta d = new DetalleVenta();
        //Obtenemos los valores de la caja de texto
        d.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        d.setProducto(p);
        d.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
        //Calculamos el descuento, si es sub detalle es mayor a 50 se le hace
        //un descuento del 5% aca es donde se encuentra la logica del negocio
        double subTotal = p.getPrecio() * d.getCantidad();
        if (subTotal > 50) {
            d.setDescuento(subTotal * 0.05);
        } else {
            d.setDescuento(0);
        }
        //Sirva para saber si tenemos agregado el producto al carrito de compras
        int indice = -1;
        //recorremos todo el carrito de compras
        for (int i = 0; i < carrito.size(); i++) {
            DetalleVenta det = carrito.get(i);
            if (det.getCodigoProducto() == p.getCodigoProducto()) {
                //Si el producto ya esta en el carrito, obtengo el indice dentro
                //del arreglo para actualizar al carrito de compras
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            //Si es -1 es porque voy a registrar
            carrito.add(d);
        } else {
            //Si es otro valor es porque el producto esta en el carrito
            //y vamos actualizar la 
            //carrito.set(indice, d);
        }
        //Actualizamos la sesion del carrito de compras
        sesion.setAttribute("carrito", carrito);
        //Redireccionamos al formulario de culminar la venta
        response.sendRedirect("registrarVenta.jsp");
    }



//Metodo que sirve para registrar toda la venta en la base de datos
    private void registrarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user=null;
        user=(String) session.getAttribute("gUser");
        Venta v=new Venta();
        v.setCliente(user);
        ArrayList<DetalleVenta> detalle  = (ArrayList<DetalleVenta>) session.getAttribute("carrito");
        boolean rpta=VentaBD.insertarVenta(v, detalle);
       
    }
    
    private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
                cliente c = new cliente();
                //request.getParameter --> Sirve para obtener los valores de las cajas de texto
                c.setNombre(request.getParameter("txtNombre"));
                c.setApellido(request.getParameter("txtApellido"));
                c.setUsuario(request.getParameter("txtUsuario"));
                c.setPassword(request.getParameter("txtPassword"));
                boolean rpta = clienteBD.insertarCliente(c);
                if (rpta) {
                    //Si inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
                    response.sendRedirect("mensaje.jsp?men=Se registro el cliente de manera correcta");
                } else {
                    //Si no se inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
                    response.sendRedirect("mensaje.jsp?men=No se registro el cliente");
                }
    
    }
   
    private void registrarCredito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        Cuota c = new Cuota();
        c.setCodigoventa(Integer.parseInt(request.getParameter("txtCodigoVenta")));
        c.setMonto_venta(Double.parseDouble(request.getParameter("txtTotal")));
        c.setMonto_cuota(Double.parseDouble(request.getParameter("txtCuota")));
        
        boolean rpta = CuotaBD.insertarCuota(c);
        if (rpta) {
                    //Si inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
                    response.sendRedirect("mensaje.jsp?men=Se registro el credito");
                } else {
                    //Si no se inserto lo redireccionamos a otra pagina que se llama "mensaje.jsp"
                    response.sendRedirect("mensaje.jsp?men=No se registro la cuota");
                }
        
    }
    
     private void obtenerCredito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user=null;
        user=(String) session.getAttribute("gUser");
        String usu;
        double total;
        usu=request.getParameter(user);
        total=Double.parseDouble(request.getParameter("txtTotal"));
        
         CuotaBD.obtenerCredito(usu);
        
    }
    
    
   public void deleteUsuario(String StrCodigo){                
        PreparedStatement pst = null;
        String StrSQL = "DELETE SENMAEUSUARIOS WHERE usu_codigo = ?";
        try {			
            pst= getConexion().prepareStatement(StrSQL);
            pst.setString(1, StrCodigo);
            // execute delete SQL stetement
            pst.executeUpdate();
            System.out.println("Registro eliminado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println(this.getClass().getName()+ ": " + e);
            }
        }
        
    }
    
   
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VentaBD oVentaBD= new VentaBD();
        if(request.getParameter("accion") != null && !request.getParameter("accion").isEmpty()){
                String AccionWeb = request.getParameter("accion");
                if("eliminar".equals(AccionWeb)){                    
               oVentaBD.deleteUsuario(Integer.parseInt(request.getParameter("codigo")),Integer.parseInt(request.getParameter("id")));                   
                }
    }}

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
           
        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarProducto")) {
            this.registrarProducto(request, response);
        } else if (accion.equals("ModificarProducto")) {
            this.actualizarProducto(request, response);
        } else if (accion.equals("AnadirCarrito")) {
            this.anadirCarrito(request, response);
        } else if (accion.equals("RegistrarVenta")) {
            this.registrarVenta(request, response);
        } else if (accion.equals("RegistrarCliente")) {
            this.registrarCliente(request, response);
        }else if (accion.equals("RegistrarCredito")) {
            this.registrarCredito(request, response);
        }
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
