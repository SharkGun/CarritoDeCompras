<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />
		  <div class="main">

			  <div class="featured">
				<h4> <strong>Confirmar Registro</strong> </h4>
				</div>
			  <div id="centro">
        <h3 align="center">
            <%
            if(request.getParameter("men")!=null){
                out.println(request.getParameter("men"));
            }
            
            %>
            <br>
            <a href="index.jsp">Volver a Principal</a>
        </h3>
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