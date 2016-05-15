package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.*;
import java.util.*;
import Modelo.cliente;

public final class logeo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\" />\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0\" />\n");
      out.write("\t<title>Carrito  ");
      out.print(session.getAttribute("gAppTitle") );
      out.write("</title>\n");
      out.write("        <!--<link href=\"materialize/css/materialize.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/style12.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/icono.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/stylo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- \n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("                    \n");
      out.write("                        <nav id=\"navigation\" style=\"background-color: #C0C0C0\">\n");
      out.write("\t\t\t\t<h1 align=\"center\">CARRITO DE COMPRAS</h1>\n");
      out.write("                            <ul  class=\"nav nav-pills\" >\n");
      out.write("\t\t\t\t\t<li role=\"presentation\" class=\"active\"><a href=\"index.jsp\">Catalogo</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarProducto.jsp\">Registrar Producto</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarVenta.jsp\">Registrar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"consultarVentas.jsp\">Consultar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"logeo2.jsp\">Logueo de usuarios</a></li>\n");
      out.write("                                </ul>\n");
      out.write("\t\t\t\t<div class=\"cl\">&nbsp;</div>\n");
      out.write("\t\t\t</nav>-->\n");
      out.write("    <div class=\" navbar-fixed  \">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write("\n");
      out.write("   <link href=\"http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write(" \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <link href=\"css/style_1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    <div class=\"form\">\n");
      out.write("      \n");
      out.write("      <ul class=\"tab-group\">\n");
      out.write("        \n");
      out.write("        <li class=\"tab active\"><a href=\"#login\">Login</a></li>\n");
      out.write("        <li class=\"tab \"><a href=\"#signup\">Registrar</a></li>\n");
      out.write("      </ul>\n");
      out.write("      \n");
      out.write("      <div class=\"tab-content\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div id=\"login\">   \n");
      out.write("          <h1>Bienvenido</h1>\n");
      out.write("          \n");
      out.write("          <form method=\"post\" action=\"Login\">\n");
      out.write("          <input type=\"hidden\" name=\"accion\" value=\"logeo\" />\n");
      out.write("            <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("              Usuario<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input required=\"\" type=\"text\" autocomplete=\"off\" name=\"txtUsuario\">\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("              Password<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input required=\"\" type=\"password\" autocomplete=\"off\" name=\"txtPassword\">\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("          <button class=\"button button-block\">Iniciar</button>\n");
      out.write("          \n");
      out.write("          </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("          <div id=\"signup\">   \n");
      out.write("          <h1>Registrarme</h1>\n");
      out.write("          \n");
      out.write("          <form method=\"post\" action=\"controlador\">\n");
      out.write("          \n");
      out.write("          <div class=\"top-row\">\n");
      out.write("              <input type=\"hidden\" name=\"accion\" value=\"RegistrarCliente\" />\n");
      out.write("            <div class=\"field-wrap\">\n");
      out.write("              <label>\n");
      out.write("                Nombre<span class=\"req\">*</span>\n");
      out.write("              </label>\n");
      out.write("              <input required=\"\" type=\"text\" autocomplete=\"off\" name=\"txtNombre\">\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("            <div class=\"field-wrap\">\n");
      out.write("              <label>\n");
      out.write("                Apellidos<span class=\"req\">*</span>\n");
      out.write("              </label>\n");
      out.write("              <input required=\"\" type=\"text\" autocomplete=\"off\" name=\"txtApellido\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("              Usuario<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input required=\"\" type=\"text\" autocomplete=\"off\" name=\"txtUsuario\">\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          <div class=\"field-wrap\">\n");
      out.write("            <label>\n");
      out.write("              Password<span class=\"req\">*</span>\n");
      out.write("            </label>\n");
      out.write("            <input required=\"\" type=\"password\" autocomplete=\"off\" name=\"txtPassword\">\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          <button class=\"button button-block\" type=\"submit\" value=\"Registrar\" name=\"btnRegistrar\">Registrar</button>\n");
      out.write("          \n");
      out.write("          </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div><!-- tab-content -->\n");
      out.write("      \n");
      out.write("</div> <!-- /form -->\n");
      out.write("    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("       \n");
      out.write("    <script src=\"js/index.js\" type=\"text/javascript\"></script>\n");
      out.write("    \n");
      out.write("  \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
