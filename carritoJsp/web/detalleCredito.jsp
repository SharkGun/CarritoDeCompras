
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="color:white">
        <h1></h1>
        <div  style="background-color: rgba(232,238,238,0.5);width:80%;border-radius: 6px">
            <%
                            ArrayList<DetalleCredito> lista = DetalleCreditoBD.obtenerDetalleCredito(Integer.parseInt(request.getParameter("cod")));
                                     
                                 for (int i=0;i<lista.size();i++) {
                                     DetalleCredito d=lista.get(i);
                            
                %>
         <table border="1"  width="90%">
                
                <tr style="background-color: skyblue; color: black; font-weight: bold">
                    <th>CodigoVenta</th><th>Cliente</th><th>Fecha</th><th>CodigoProducto</th>
                    <th>Nombre</th><th>Precio</th><th>Cantidad</th><th>Descuento</th>
                    <th>Parcial</th><th>SubTotal</th><th>TotalPagar</th>
                </tr>
                <%-- Lista de todos los productos --%>
                
                <tr>
                    <td><%= d.getCodigoCredito() %></td>
                    <td><%= d.getMonto() %></td>
                    <td><%= d.getFecha_pago() %></td>
                    <td><%= d.getInteres() %></td>
                    <td><%= d.getTotal() %></td>
              
                </tr>
    </body>
</html>
