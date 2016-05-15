<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />
                    <h3 align="center">Lista de Productos</h3>
                    <style type="text/css">
        </style>
                    <center>
                        <div style="width: 700px;background-color: blue(232,238,238,0.5);padding: 10px">
            <table border="0" align="center" >
                
                
                <%-- Lista de todos los productos --%>
                <%
                  ArrayList<Producto> lista = ProductoBD.obtenerProducto();
                  int salto=0;
                  for (Producto p : lista) {
                %>
                
                    <th ><img src="imagenes/<%=p.getImagen()%>" class="Productos"><p>
                    <%= p.getNombre()%><br>
                    S/ <%= p.getPrecio()%><p>
                    <%-- Enlaces a las paginas de actualizar o anadir al carrito --%>
                    <a href="actualizarProducto.jsp?id=<%= p.getCodigoProducto()%>">Modificar</a> |
                        <a href="anadirCarrito.jsp?id=<%= p.getCodigoProducto()%>">Añadir</a>
                       <!--<a href="cuota.jsp?id=<//%= p.getCodigoProducto()%>">cuota</a>-->
                    </th>
                
                <%
                salto++;
                if(salto==4){
                    %>
                    <tr> 
                        <%
                        salto=0;
                }
                            }
                %>

            </table>
                        </div>
                    </center>
        </div>

 <!-- final de js -->
 
			  </section>
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