package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <title>Manage Information System</title>\n");
      out.write("  <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("  <!-- Font Awesome -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/fontawesome-free/css/all.min.css\">\n");
      out.write("  <!-- Ionicons -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("  <!-- overlayScrollbars -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"dist/css/adminlte.min.css\">\n");
      out.write("  <!-- Google Font: Source Sans Pro -->\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body class=\"hold-transition sidebar-mini\">\n");
      out.write("<!-- Site wrapper -->\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top_navbar.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- Content Wrapper. Contains page content -->\n");
      out.write("    <div class=\"content-wrapper\">\n");
      out.write("        <!-- Content Header (Page header) -->\n");
      out.write("        <section class=\"content-header\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row mb-2\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h1>Blank Page</h1>\n");
      out.write("                    </div>\n");
      out.write("        <div class=\"col-sm-6\">\n");
      out.write("          <ol class=\"breadcrumb float-sm-right\">\n");
      out.write("            <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("            <li class=\"breadcrumb-item active\">Blank Page</li>\n");
      out.write("          </ol>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div><!-- /.container-fluid -->\n");
      out.write("  </section> \n");
      out.write("    <!-- Main content -->\n");
      out.write("    <section class=\"content\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <!-- Default box -->\n");
      out.write("        <div class=\"card\">\n");
      out.write("          <div class=\"card-header\">\n");
      out.write("            <h3 class=\"card-title\">Title</h3>\n");
      out.write("  \n");
      out.write("            <div class=\"card-tools\">\n");
      out.write("              <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"collapse\" data-toggle=\"tooltip\" title=\"Collapse\">\n");
      out.write("                <i class=\"fas fa-minus\"></i></button>\n");
      out.write("              <button type=\"button\" class=\"btn btn-tool\" data-card-widget=\"remove\" data-toggle=\"tooltip\" title=\"Remove\">\n");
      out.write("                <i class=\"fas fa-times\"></i></button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"card-body\">\n");
      out.write("            Start creating your amazing application!\n");
      out.write("          </div>\n");
      out.write("          <!-- /.card-body -->\n");
      out.write("          <div class=\"card-footer\">\n");
      out.write("            Footer\n");
      out.write("          </div>\n");
      out.write("          <!-- /.card-footer-->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.card -->\n");
      out.write("  \n");
      out.write("      </section>\n");
      out.write("      <!-- /.content -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.content-wrapper -->\n");
      out.write("  \n");
      out.write("    <!-- Control Sidebar -->\n");
      out.write("    <aside class=\"control-sidebar control-sidebar-dark\">\n");
      out.write("      <!-- Control sidebar content goes here -->\n");
      out.write("    </aside>\n");
      out.write("    <!-- /.control-sidebar -->   \n");
      out.write("</div>\n");
      out.write("<!-- ./wrapper -->\n");
      out.write("\n");
      out.write("<!-- jQuery -->\n");
      out.write("<script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("<!--Bootstrap 4 -->\n");
      out.write("<script src=\"plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<!-- AdminLTE App -->\n");
      out.write("<script src=\"dist/js/adminlte.min.js\"></script>\n");
      out.write("<!-- AdminLTE for demo purposes -->\n");
      out.write("<script src=\"dist/js/demo.js\"></script>\n");
      out.write("</body>\n");
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
