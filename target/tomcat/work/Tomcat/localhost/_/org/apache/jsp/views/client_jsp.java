/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-09 11:06:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class client_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<title>Client Page</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"w3-top\">\r\n");
      out.write("    <div class=\"w3-bar w3-blue-gray w3-card w3-left-align w3-medium\">\r\n");
      out.write("        <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red\" href=\"javascript:void(0);\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey w3-right\">UA</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey w3-right\">EN</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey w3-right\">RU</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey\">Deposit Account</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey\">Credit Account</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button w3-border w3-light-grey\">My Operations</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"w3-row-padding w3-padding-64 w3-container\">\r\n");
      out.write("   <div class=\"w3-third\">\r\n");
      out.write("   <img src=\"/avatar.png\" style=\"width:30%\">\r\n");
      out.write("\r\n");
      out.write("  <h2></h2>\r\n");
      out.write("  <table class=\"w3-table w3-striped w3-bordered w3-border\">\r\n");
      out.write("  <thead class=\"w3-teal\"><th style=\"width:40%\">Account Information</th><th></th></thead>\r\n");
      out.write("  <tr><td>Balance</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Currency</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Validity</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Deposit</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Credit</td><td>TBD</td></tr>\r\n");
      out.write("  </table>\r\n");
      out.write("\r\n");
      out.write("  <h2></h2>\r\n");
      out.write("  <table class=\"w3-table w3-striped w3-bordered w3-border\">\r\n");
      out.write("  <thead class=\"w3-teal\"><th style=\"width:40%\">Contact Details</th><th></th></thead>\r\n");
      out.write("  <tr><td>Name</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Last Name</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Address</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Mobile Phone</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Mail</td><td>TBD</td></tr>\r\n");
      out.write("  <tr><td>Birthday</td><td>TBD</td></tr>\r\n");
      out.write("  </table>\r\n");
      out.write("\r\n");
      out.write("  <h2></h2>\r\n");
      out.write("  <table class=\"w3-table w3-striped w3-bordered w3-border\">\r\n");
      out.write("  <thead class=\"w3-teal\"><th style=\"width:30%\">Operation history</th><th></th></thead>\r\n");
      out.write("  <tr><td>TBD</td><td>TBD</td></tr>\r\n");
      out.write("   </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function w3_open() {\r\n");
      out.write("  document.getElementById(\"mySidebar\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function w3_close() {\r\n");
      out.write("  document.getElementById(\"mySidebar\").style.display = \"none\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("   <div class=\"w3-container w3-grey w3-opacity w3-right-align w3-padding\">\r\n");
      out.write("   <button class=\"w3-btn w3-round-large\" onclick=\"location.href='/'\">Back to main menu</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
