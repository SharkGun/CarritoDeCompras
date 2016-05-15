
<%@page import="Modelo.*,java.util.*" %>
<%@page import="Modelo.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
	<title>Carrito  <%=session.getAttribute("gAppTitle") %></title>
<style>
    
        body {
		background: rgb(38, 166, 154);
		
	}
        </style>
</head>
<body>
    <div class=" navbar-fixed  ">
</div>
   <link href="http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600" rel="stylesheet" type="text/css">
    <link href="css/style_1.css" rel="stylesheet" type="text/css"/>
    <div class="form">
      <ul class="tab-group">
        <li class="tab active"><a href="#login">Login</a></li>
        <li class="tab "><a href="#signup">Registrar</a></li>
      </ul>
      <div class="tab-content">
        <div id="login">   
          <h1>Ingresar a Tienda Virtual</h1>
          <form method="post" action="Login">
          <input type="hidden" name="accion" value="logeo" />
            <div class="field-wrap">
            <label>
              User  <span class="req">*</span>
            </label>
            <input required="" type="text" autocomplete="off" name="txtUsuario">
            </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input required="" type="password" autocomplete="off" name="txtPassword">
          </div>
          <center><button class="button button-block">Ingresar</button></center>
          </form>
        </div>
          <div id="signup">   
          <h1>Registro</h1>
          <form method="post" action="controlador">
          <div class="top-row">
              <input type="hidden" name="accion" value="RegistrarCliente" />
            <div class="field-wrap">
              <label>
                Nombre<span class="req">*</span>
              </label>
              <input required="" type="text" autocomplete="off" name="txtNombre">
            </div>
            <div class="field-wrap">
              <label>
                Apellidos<span class="req">*</span>
              </label>
              <input required="" type="text" autocomplete="off" name="txtApellido">
            </div>
          </div>
          <div class="field-wrap">
            <label>
              User<span class="req">*</span>
            </label>
            <input required="" type="text" autocomplete="off" name="txtUsuario">
          </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input required="" type="password" autocomplete="off" name="txtPassword">
          </div>
              <center><button class="button button-block" type="submit" value="Registrar" name="btnRegistrar">Registrar</button></center>
          </form>
        </div>
      </div><!-- tab-content -->
</div> <!-- /form -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="js/index.js" type="text/javascript"></script>
</body>
</html>