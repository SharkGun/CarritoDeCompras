
<%@page import="Modelo.*,java.util.*" %>
<%@page import="Modelo.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
	<title>Carrito  <%=session.getAttribute("gAppTitle") %></title>
        <link href="materialize/css/materialize.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style12.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/icono.css" rel="stylesheet" type="text/css"/>
        <link href="css/stylo.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
      <%
            String user=null;
            //Evaluacion de Sesion
            if(session.getAttribute("gUser")==null){
                response.sendRedirect("logeo.jsp");
            }else{
                user=(String) session.getAttribute("gUser");
            }
        %>
    <div class=" navbar-fixed  ">
    <nav class="white">
        <div class="nav-wrapper container-fluid">
                            <div style="margin-left: 15%">
                                
            <ul class="hide-on-med-and-down" >
              <li ><a href="index.jsp">Catalogo</a></li>
					<li><a href="registrarProducto.jsp">Registrar Producto</a></li>
					<li><a href="registrarVenta.jsp">Registrar Ventas</a></li>
					<li><a href="consultarVentas.jsp">Consultar Ventas</a></li>
                                        <li ><a href="Logout">Salir</a></li>
                            </ul></div>
            <div class="perfil"><%=user%></a></div>
            <div>
            <ul id="nav-mobile" class="side-nav">
                <li ><a href="index.jsp">Catalogo</a></li>
					<li><a href="registrarProducto.jsp">Registrar Producto</a></li>
					<li><a href="registrarVenta.jsp">Registrar Ventas</a></li>
					<li><a href="consultarVentas.jsp">Consultar Ventas</a></li>
					<li><a href="Logout">Salir</a></li>
            </ul>
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</div>
        <center>
