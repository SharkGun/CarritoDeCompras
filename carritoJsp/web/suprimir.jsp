<%-- 
    Document   : suprimir
    Created on : 25-abr-2016, 14:00:20
    Author     : Betax
--%>


<%@page import="Modelo.DetalleVenta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         HttpSession session = request.getSession();
        <%
    // Recuperar el codigo del producto
    int IdPro = Integer.parseInt(request.getParameter("id"));
    // Recuperar el valor de cesto
    
    // Declarar el arraylist 
    ArrayList<DetalleVenta> Lista = new ArrayList<DetalleVenta>();
    // Guardar en Lista lo que esta en el cesto
    Lista = (ArrayList<DetalleVenta>)session.getAttribute("carrito");
    // Recorrer el arraylista para suprimir el producto seleccionado
    for(int i = 0; i < Lista.size(); i++){
        if(Lista.get(i).getCodigoProducto().equalsIgnoreCase(IdPro)){
            Lista.remove(i);
            break;
        }
    }
    // Actualizar el cesto de la sesion
    session.setAttribute("carrito", Lista);
    // Redireccionar
    response.sendRedirect("cesto?txtcant=0");
%>
    </body>
</html>
