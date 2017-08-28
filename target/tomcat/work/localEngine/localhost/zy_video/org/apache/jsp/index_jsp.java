package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    \r\n");
      out.write("    <title>Bootstrap 101 Template</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <script src=\"../js/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    \t<style>\r\n");
      out.write("    \t* {\r\n");
      out.write("\t\t\tbox-sizing: border-box;\r\n");
      out.write("\t\t\tfont-family: 微软雅黑;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("    \tbody {\r\n");
      out.write("\t\t\tmargin: 0;\r\n");
      out.write("    \t\tbackground-color: #ddd;\r\n");
      out.write("    \t\tdisplay: flex;\r\n");
      out.write("    \t\tjustify-content: center;\r\n");
      out.write("    \t\talign-items: center;\r\n");
      out.write("    \t\tmargin-top:200px;\r\n");
      out.write("\t\t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"col-sm-offset-1 col-sm-3\">\r\n");
      out.write("\t\t<!--<div class=\"col-sm-offset-1 col-sm-2\">-->\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        <form class=\"form-horizontal\">\r\n");
      out.write("        \t<div class=\"col-sm-8\">\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<img src=\"/main/webapp/img/logo.png\" alt=\"智游\" >\r\n");
      out.write("        \t</div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <!--<label for=\"inputEmail3\" class=\"col-sm-4 control-label\">用户名</label>-->\r\n");
      out.write("\t\t    <div class=\"col-sm-10\">\r\n");
      out.write("\t\t      <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"请输入用户名\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <!--<label for=\"inputPassword3\" class=\"col-sm-4 control-label\">密码</label>-->\r\n");
      out.write("\t\t    <div class=\"col-sm-10\">\r\n");
      out.write("\t\t      <input type=\"password\" class=\"form-control\" id=\"inputPassword3\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <div class=\"col-sm-10\">\r\n");
      out.write("\t\t      <div class=\"checkbox\">\r\n");
      out.write("\t\t        <label>\r\n");
      out.write("\t\t          <input type=\"checkbox\"> Remember me\r\n");
      out.write("\t\t        </label>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <div class=\"col-sm-10\">\r\n");
      out.write("\t\t      <button type=\"button\" class=\"btn btn-primary  btn-block\" style=\"background-color: green;\">登录</button>\r\n");
      out.write("\t\t      \r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t</form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
