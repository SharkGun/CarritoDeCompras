<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />

		  <div class="main">

			  <div class="featured">
				<h4><strong>REGISTRO DE VENTAS</strong> </h4>
				</div>
			  <div id="centro">
          <%-- Inicio del jsp--%>    
              
          
<div class="cajaD">
    
<form method="post" action="controlador">
<%-- Llamamos a la accion Registrar Venta --%>


<table border="1" align="center" width="400">
    <tr style="background-color: #fff; color: orange; font-weight: bold">
        <td colspan="6">Carrito de Compras</td>
    </tr>
    <tr style="background-color: orange; font-weight: bold">
        <td>Cliente:</td>
        <td colspan="5"><%=user%></td>
    </tr>
    <tr style="background-color: orange;  font-weight: bold">
        <td>Nombre</td>
        <td>Precio</td>
        <td>Cantidad</td>
        <td>Descuento</td>
        <td>Sub. Total</td>
        <td></td>
    </tr>
    <%-- Los productos que tenemos en la sesion que se llama carrito --%>
    <%
    double total=0;
        ArrayList<DetalleVenta> lista = (ArrayList<DetalleVenta>)session.getAttribute("carrito");
        if(lista!=null){
            
            for (DetalleVenta d : lista) {
    %>
                    <tr>
                        <td><%= d.getProducto()%></td>
                        <td><%= d.getProducto().getPrecio()%></td>
                        <td><%= d.getCantidad()%></td>
                        <td><%= d.getDescuento()%></td>
                        <td><%= (d.getProducto().getPrecio() * d.getCantidad())-d.getDescuento()%></td>
                        <td><a href="registrarVenta.jsp?d=<%= d.getCodigoProducto()%>" class="btn"  >eliminar</a></td>
                    </tr>
    <%
        
    
    total=total+(d.getProducto().getPrecio() * d.getCantidad())-d.getDescuento();
                    }
               }
    %>
    <tr>
       
        <th colspan="4" align="right">Total</th>
        <th><input type="text" name="txtTotal" value="<%=total%>"/></th>
    </tr>
    <tr >
        <td colspan="5"><input class="btn" type="submit" name="accion" value="RegistrarVenta" /></td>
        <td colspan="5"><a class="btn" href="Credito.jsp?id=<%= user%>&total=<%=total%>">cuota</a></td>

    </tr>
</table>
</form>
</div>
    <h4 align="center"><a class="btn" href="index.jsp">Seguir Comprando</a></h4>
  </div>
			</div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
			
			<!-- footer -->
		
		
<!-- end of wrapper -->
<jsp:directive.include file="footer.jsp" />