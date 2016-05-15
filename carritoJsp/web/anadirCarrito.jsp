<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />
   <%@page import="Modelo.ProductoBD"%>
  <% Producto p= ProductoBD.obtenerProducto(Integer.parseInt(request.getParameter("id")));
  %>
		  <div class="main">

			  <div class="featured">
				<h4> <strong>AÑADIR PRODUCTO</strong> </h4>
				</div>
			  <div id="centro" class="cajaC">
                              
        <form method="post" action="controlador">
            <div>
                
                <input type="hidden" name="accion" value="AnadirCarrito" />
                <table border="0" width="330">
                    
                    <tr>
                        <th rowspan="5" width="160"><img src="imagenes/<%= p.getImagen()%>" width="120" height="120"></th>
                        <td>Codigo</td>
                        <td><input type="text" name="txtCodigo" value="<%= p.getCodigoProducto()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="<%= p.getNombre()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtPrecio" value="<%= p.getPrecio()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Cantidad Pedir</td>
                        <td><input required="" type="text" name="txtCantidad" value="0" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn" type="submit" value="Añadir" name="btnAnadir" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
			
			<!-- footer -->
			
			<!-- end of footer -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<!-- end of wrapper -->
</body>
</html>