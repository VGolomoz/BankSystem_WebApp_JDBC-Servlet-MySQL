/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-03 09:46:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>W3.CSS Template</title>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("html,body,h1,h2,h3,h4,h5,h6 {font-family: \"Roboto\", sans-serif}\r\n");
      out.write("</style>\r\n");
      out.write("<body class=\"w3-light-grey\">\r\n");
      out.write("\r\n");
      out.write("<!-- Page Container -->\r\n");
      out.write("<div class=\"w3-content w3-margin-top\" style=\"max-width:1400px;\">\r\n");
      out.write("\r\n");
      out.write("  <!-- The Grid -->\r\n");
      out.write("  <div class=\"w3-row-padding\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Left Column -->\r\n");
      out.write("    <div class=\"w3-third\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"w3-white w3-text-grey w3-card-4\">\r\n");
      out.write("        <div class=\"w3-display-container\">\r\n");
      out.write("          <img src=\"/w3images/avatar_hat.jpg\" style=\"width:100%\" alt=\"Avatar\">\r\n");
      out.write("          <div class=\"w3-display-bottomleft w3-container w3-text-black\">\r\n");
      out.write("            <h2>Jane Doe</h2>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <p><i class=\"fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal\"></i>Designer</p>\r\n");
      out.write("          <p><i class=\"fa fa-home fa-fw w3-margin-right w3-large w3-text-teal\"></i>London, UK</p>\r\n");
      out.write("          <p><i class=\"fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal\"></i>ex@mail.com</p>\r\n");
      out.write("          <p><i class=\"fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal\"></i>1224435534</p>\r\n");
      out.write("          <hr>\r\n");
      out.write("\r\n");
      out.write("          <p class=\"w3-large\"><b><i class=\"fa fa-asterisk fa-fw w3-margin-right w3-text-teal\"></i>Skills</b></p>\r\n");
      out.write("          <p>Adobe Photoshop</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge w3-small\">\r\n");
      out.write("            <div class=\"w3-container w3-center w3-round-xlarge w3-teal\" style=\"width:90%\">90%</div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>Photography</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge w3-small\">\r\n");
      out.write("            <div class=\"w3-container w3-center w3-round-xlarge w3-teal\" style=\"width:80%\">\r\n");
      out.write("              <div class=\"w3-center w3-text-white\">80%</div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>Illustrator</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge w3-small\">\r\n");
      out.write("            <div class=\"w3-container w3-center w3-round-xlarge w3-teal\" style=\"width:75%\">75%</div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>Media</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge w3-small\">\r\n");
      out.write("            <div class=\"w3-container w3-center w3-round-xlarge w3-teal\" style=\"width:50%\">50%</div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("\r\n");
      out.write("          <p class=\"w3-large w3-text-theme\"><b><i class=\"fa fa-globe fa-fw w3-margin-right w3-text-teal\"></i>Languages</b></p>\r\n");
      out.write("          <p>English</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge\">\r\n");
      out.write("            <div class=\"w3-round-xlarge w3-teal\" style=\"height:24px;width:100%\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>Spanish</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge\">\r\n");
      out.write("            <div class=\"w3-round-xlarge w3-teal\" style=\"height:24px;width:55%\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>German</p>\r\n");
      out.write("          <div class=\"w3-light-grey w3-round-xlarge\">\r\n");
      out.write("            <div class=\"w3-round-xlarge w3-teal\" style=\"height:24px;width:25%\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div><br>\r\n");
      out.write("\r\n");
      out.write("    <!-- End Left Column -->\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Right Column -->\r\n");
      out.write("    <div class=\"w3-twothird\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"w3-container w3-card w3-white w3-margin-bottom\">\r\n");
      out.write("        <h2 class=\"w3-text-grey w3-padding-16\"><i class=\"fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal\"></i>Work Experience</h2>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>Front End Developer / w3schools.com</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>Jan 2015 - <span class=\"w3-tag w3-teal w3-round\">Current</span></h6>\r\n");
      out.write("          <p>Lorem ipsum dolor sit amet. Praesentium magnam consectetur vel in deserunt aspernatur est reprehenderit sunt hic. Nulla tempora soluta ea et odio, unde doloremque repellendus iure, iste.</p>\r\n");
      out.write("          <hr>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>Web Developer / something.com</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>Mar 2012 - Dec 2014</h6>\r\n");
      out.write("          <p>Consectetur adipisicing elit. Praesentium magnam consectetur vel in deserunt aspernatur est reprehenderit sunt hic. Nulla tempora soluta ea et odio, unde doloremque repellendus iure, iste.</p>\r\n");
      out.write("          <hr>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>Graphic Designer / designsomething.com</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>Jun 2010 - Mar 2012</h6>\r\n");
      out.write("          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </p><br>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"w3-container w3-card w3-white\">\r\n");
      out.write("        <h2 class=\"w3-text-grey w3-padding-16\"><i class=\"fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal\"></i>Education</h2>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>W3Schools.com</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>Forever</h6>\r\n");
      out.write("          <p>Web Development! All I need to know in one place</p>\r\n");
      out.write("          <hr>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>London Business School</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>2013 - 2015</h6>\r\n");
      out.write("          <p>Master Degree</p>\r\n");
      out.write("          <hr>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"w3-container\">\r\n");
      out.write("          <h5 class=\"w3-opacity\"><b>School of Coding</b></h5>\r\n");
      out.write("          <h6 class=\"w3-text-teal\"><i class=\"fa fa-calendar fa-fw w3-margin-right\"></i>2010 - 2013</h6>\r\n");
      out.write("          <p>Bachelor Degree</p><br>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- End Right Column -->\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- End Grid -->\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- End Page Container -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"w3-container w3-teal w3-center w3-margin-top\">\r\n");
      out.write("  <p>Find me on social media.</p>\r\n");
      out.write("  <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\r\n");
      out.write("  <i class=\"fa fa-instagram w3-hover-opacity\"></i>\r\n");
      out.write("  <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\r\n");
      out.write("  <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\r\n");
      out.write("  <i class=\"fa fa-twitter w3-hover-opacity\"></i>\r\n");
      out.write("  <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\r\n");
      out.write("  <p>Powered by <a href=\"https://www.w3schools.com/w3css/default.asp\" target=\"_blank\">w3.css</a></p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
