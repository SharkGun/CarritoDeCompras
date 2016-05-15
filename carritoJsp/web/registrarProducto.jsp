<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Inicio de JSP --> 
  <jsp:directive.include file="header.jsp" />   
              <style type="text/css">
        </style>
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <h4 align="center">Nuevos Productos</h4>
        <div  class="cajaC">
        <form method="post" action="controlador">
            <div id="porfavor">
                <input type="hidden" name="accion" value="RegistrarProducto" />
                <table border="0" width="300" align="center" id="tabla1">
                    <tr>
                        <td>Nombre:</td>
                        <td><input required="" type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Precio:</td>
                        <td> <input required="" type="text" name="txtPrecio" value="0" /></td>
                    </tr>
                    <tr>
                        <td>Imagen:</td>
                        <td><input id="files" type="file" name="txtImagen" value="0" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td ><input style="margin-top: 30px;" class="btn " type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                    <br>
                </table>
            </div>
        </form>
            
            </div>
         <output id="list"></output>
    <%-- FInal del jsp--%>           
			  </div>
			</div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<script>
              function archivo(evt) {
                  var files = evt.target.files; // FileList object
             
                  // Obtenemos la imagen del campo "file".
                  for (var i = 0, f; f = files[i]; i++) {
                    //Solo admitimos imágenes.
                    if (!f.type.match('image.*')) {
                        continue;
                    }
             
                    var reader = new FileReader();
             
                    reader.onload = (function(theFile) {
                        return function(e) {
                          // Insertamos la imagen
                         document.getElementById("list").innerHTML = ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
                        };
                    })(f);
             
                    reader.readAsDataURL(f);
                  }
              }
             
              document.getElementById('files').addEventListener('change', archivo, false);
      </script>
<jsp:directive.include file="footer.jsp" />