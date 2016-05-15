<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*,java.util.*" %>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />

		  <div class="main">

			  <div class="featured">
				<h4><strong>CONSULTA DE VENTAS</strong> </h4>
				</div>
			  <div id="centro">
                              
                              <div  class="cajaC">
            <table border="1" align="left" width="400">
                <tr>
                    <th colspan="4" id="centro" > Lista de Ventas</th>
                </tr>
                <tr >
                    <th>Codigo</th><th>Nombre</th><th>Fecha</th><th>Accion</th>
                </tr>
                <%-- Lista de todos los productos --%>
                <%
                            String usu=user;
                            
            
                            ArrayList<Venta> lista = VentaBD.obtenerVentas(usu);
                                 for (Venta v : lista) {
                %>
                <tr>
                    <td><%= v.getCodigoVenta() %></td>
                    <td><%= v.getCliente() %></td>
                    <td><%= v.getFecha() %></td>
                    <%-- Enlaces a las paginas de actualizar o anadir al carrito --%>
                    <td><a href="obtenerDetalleVenta.jsp?cod=<%= v.getCodigoVenta() %>" target="detalle">ver Detalle</a></td>
                    <td><a href="suprimir.jsp?cod=<%= v.getCodigoVenta() %>" >Eliminar</a></td>
               
                    
                    
                </tr>
                <%
                            }
                %>

            </table>
                              </div>
       <p>
       <center>
            <div id="mostrarDato">
                <iframe name="detalle" width="90%" height="150" frameborder="0" > 
                
                </iframe>
            </div>
           </center>
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
<jsp:directive.include file="footer.jsp" />