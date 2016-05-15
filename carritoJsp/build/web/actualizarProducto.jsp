<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />
  <%@page import="Modelo.ProductoBD"%>
  <% Producto p= ProductoBD.obtenerProducto(Integer.parseInt(request.getParameter("id")));
  %>
		  <div class="main">

			  <div class="featured">
				<h4> <strong>ACTUALIZAR PRODUCTO</strong> </h4>
				</div>
			  <div id="centro">
                              
                             
       <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
         <div  class="cajaC">
        <form method="post" action="controlador">
            <div>
                <%-- Indica al controlador que vamos hacer una modificacion --%>
                <input type="hidden" name="accion" value="ModificarProducto" />
                <table border="1">
                    <tr>
                        <td>Codigo</td>
                        <%-- Escribimos el codigo del producto a modificar --%>
                        <td><input type="text" name="txtCodigo" value="<%= p.getCodigoProducto()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <%-- Escribimos el nombre del producto a modificar --%>
                        <td><input type="text" name="txtNombre" value="<%= p.getNombre()%>" /></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <%-- Escribimos el precio del producto a modificar --%>
                        <td><input type="text" name="txtPrecio" value="<%= p.getPrecio()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn" type="submit" value="Actualizar" name="btnActualizar" /></td>
                    </tr>
                </table>
            </div>
        </form>
         </div>
  </div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
			
			
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<!-- end of wrapper -->
<jsp:directive.include file="footer.jsp" />