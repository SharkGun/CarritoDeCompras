<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />
		  <div class="main">

			  <div class="featured">
				<h4> <strong>Guardado</strong> </h4>
				</div>
			  <div id="centro">
        <h3 align="center">
            <%
            if(request.getParameter("men")!=null){
                out.println(request.getParameter("men"));
            }
            
            %></h3>
            <br>
            <a class="btn" href="index.jsp">Regresar</a>
        
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