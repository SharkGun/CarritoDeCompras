<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="materialize/css/materialize.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div  style="background-color: rgba(232,238,238,0.5);width:80%;border-radius: 6px">
            <%
                            ArrayList<DetalleVenta> lista = DetalleVentaBD.obtenerDetalleVenta(Integer.parseInt(request.getParameter("cod")));
                                     
                                 for (int i=0;i<lista.size();i++) {
                                     DetalleVenta d=lista.get(i);
                            
                %>
            <table border="1"  width="90%">
                
                <tr style="background-color: skyblue; color: black; font-weight: bold">
                    <th>CodigoVenta</th><th>Cliente</th><th>Fecha</th><th>CodigoProducto</th>
                    <th>Nombre</th><th>Precio</th><th>Cantidad</th><th>Descuento</th>
                    <th>Parcial</th><th>SubTotal</th><th>TotalPagar</th>
                </tr>
                <%-- Lista de todos los productos --%>
                
                <tr>
                    <td><%= d.getCodigoVenta() %></td>
                    <td><%= d.getCliente() %></td>
                    <td><%= d.getFecha() %></td>
                    <td><%= d.getCodigoProducto() %></td>
                    <td><%= d.getNombre() %></td>
                    <td><%= d.getPrecio() %></td>
                    <td><%= d.getCantidad() %></td>
                    <td><%= d.getDescuento() %></td>
                    <td><%= d.getParcial() %></td>
                    <td><%= d.getSubtotal() %></td>
                    <td><%= d.getTotal() %></td>
                </tr>
                
                
            </table>
            <a href="obtenerDetalleVenta.jsp?cod=<%= d.getCodigoVenta() %>" target="detalle">Pagar</a>
               
                <%
                            }
                %>
        </div>
    </center>
            
<jsp:directive.include file="footer.jsp" />