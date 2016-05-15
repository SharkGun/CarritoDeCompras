
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.include file="header.jsp" /> 
<div class="main">
        <h1>Cuotas a Pagar</h1>
        <% double total=Double.parseDouble(request.getParameter("total"));
    Cuota c= CuotaBD.obtenerCredito(request.getParameter("id"));
  %>
        <div  class="cajaC">
            <form method="POST" action="controlador">
               
                <table border="1" >
                    
                    <tr>
                        <td>Codigo de venta</td>
                        <td><input type="text" name="txtCodigoVenta" value="<%= c.getCodigoventa()%>"></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtTotal" value="<%= total%>"></td>
                    </tr>
                    <tr>
                        <td>Cuota</td>
                        <td><input type="text" name="txtCuota" /></td>
                    </tr>
                    <tr><td></br></td><td></br></td></tr>
                    <tr><td></br></td><td></br></td></tr>
                    <tr>
                        <td><input class="btn" type="submit" value="Calcular"/></td>
                    
                        <td><input class="btn" type="submit" name="accion" value="RegistrarCredito" /></td>
                    </tr>
                    
                </table>
            </form>
        </div>
                    <a href="detalleCredito.jsp" target="detalle">ver Detalle</a>
                    
                    <center>
            <div id="mostrarDato">
                <iframe name="detalle" width="90%" height="150" frameborder="0" > 
                
                </iframe>
            </div>
           </center>
             
<jsp:directive.include file="footer.jsp" />
