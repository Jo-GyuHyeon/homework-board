package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class asdf_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <!-- Standard Meta -->\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"semantic/semantic.js\"></script>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"semantic/semantic.css\" />\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <table class=\"ui celled table\">\n");
      out.write("  <thead>\n");
      out.write("    <tr><th>Header</th>\n");
      out.write("    <th>Header</th>\n");
      out.write("    <th>Header</th>\n");
      out.write("  </tr></thead>\n");
      out.write("  <tbody>\n");
      out.write("    <tr>\n");
      out.write("      <td>\n");
      out.write("        <div class=\"ui ribbon label\">First</div>\n");
      out.write("      </td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td>Cell</td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td>Cell</td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("      <td>Cell</td>\n");
      out.write("    </tr>\n");
      out.write("  </tbody>\n");
      out.write("  <tfoot>\n");
      out.write("    <tr><th colspan=\"3\">\n");
      out.write("      <div class=\"ui right floated pagination menu\">\n");
      out.write("        <a class=\"icon item\">\n");
      out.write("          <i class=\"left chevron icon\"></i>\n");
      out.write("        </a>\n");
      out.write("        <a class=\"item\">1</a>\n");
      out.write("        <a class=\"item\">2</a>\n");
      out.write("        <a class=\"item\">3</a>\n");
      out.write("        <a class=\"item\">4</a>\n");
      out.write("        <a class=\"icon item\">\n");
      out.write("          <i class=\"right chevron icon\"></i>\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("    </th>\n");
      out.write("  </tr></tfoot>\n");
      out.write("</table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
