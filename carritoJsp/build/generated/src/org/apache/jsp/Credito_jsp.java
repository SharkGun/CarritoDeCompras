package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.*;
import java.util.*;
import Modelo.cliente;

public final class Credito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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

      out.write('\n');
      out.write('\n');
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
      out.write("        <link href=\"materialize/css/materialize.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/style12.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/icono.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/stylo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
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
      out.write("    <nav class=\"white\">\n");
      out.write("        <div class=\"nav-wrapper container-fluid\">\n");
      out.write("           \n");
      out.write("           \n");
      out.write("                            <div style=\"margin-left: 15%\">\n");
      out.write("                              \n");
      out.write("                                \n");
      out.write("            <ul class=\"hide-on-med-and-down\" >\n");
      out.write("                \n");
      out.write("              <li ><a href=\"index.jsp\">Catalogo</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarProducto.jsp\">Registrar Producto</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarVenta.jsp\">Registrar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"consultarVentas.jsp\">Consultar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"logeo.jsp\">Logueo de usuarios</a></li>\n");
      out.write("                                        <li ><a href=\"Logout\">Salir</a></li>\n");
      out.write("               \n");
      out.write("\n");
      out.write("                            </ul></div>\n");
      out.write("            <div>\n");
      out.write("            <ul id=\"nav-mobile\" class=\"side-nav\">\n");
      out.write("                <li ><a href=\"index.jsp\">Catalogo</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarProducto.jsp\">Registrar Producto</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"registrarVenta.jsp\">Registrar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"consultarVentas.jsp\">Consultar Ventas</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"\">Logueo de usuarios</a></li>\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <a href=\"#\" data-activates=\"nav-mobile\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write(" \n");
      out.write("        <h1>Cuotas a Pagar</h1>\n");
      out.write("        <div  class=\"cajaC\">\n");
      out.write("            <form method=\"POST\" action=\"controlador\">\n");
      out.write("                <table border=\"1\" >\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Codigo de venta</td>\n");
      out.write("                        <td>5</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Precio</td>\n");
      out.write("                        <td>40</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Cuota</td>\n");
      out.write("                        <td>4</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input class=\"btn\" type=\"submit\" value=\"Pagar\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write(" \n");
      out.write("<script src=\"js/code.jquery.com_jquery-2.1.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"materialize/js/materialize.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"js/init.js\" type=\"text/javascript\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write('\n');
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
