/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-12-06 17:24:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Product;

public final class productlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head> <link href=\"css/productlist.css\" rel=\"stylesheet\" type=\"text/css\"> </head>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar\">\r\n");
      out.write(" <h1>Books</h1>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"wrap\">\r\n");
      out.write("    <div class=\"search\">\r\n");
      out.write("    <form action=\"productpage\",method=\"get\">\r\n");
      out.write("       <input type=\"text\" name = \"search\" class=\"searchTerm\" placeholder=\"What are you looking for?\">\r\n");
      out.write("       <button type=\"submit\" class=\"searchButton\">\r\n");
      out.write("         <i class=\"fa fa-search\"></i>\r\n");
      out.write("         </form>\r\n");
      out.write("      </button>\r\n");
      out.write("    </div>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"sort\">\r\n");
      out.write("    <div class=\"collection-sort\">\r\n");
      out.write("      <label>Filter by:</label>\r\n");
      out.write("      <form action = \"productpage\", method = \"get\">\r\n");
      out.write("      <select class=\"dropdown\" name = \"sort\" onchange=\"this.form.submit()\">\r\n");
      out.write("        <option value=\"/\">All Books</option>\r\n");
      out.write("        <option value=\"price\">Low to High</option>\r\n");
      out.write("        <option value=\"price DESC\">High to low</option>\r\n");
      out.write("        <option value=\"year\">Published Date</option>\r\n");
      out.write("      </select>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"collection-sort\">\r\n");
      out.write("      <label>Sort by:</label>\r\n");
      out.write("      <select class=\"dropdown\">\r\n");
      out.write("        <option value=\"/\">Featured</option>\r\n");
      out.write("      </select>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <ul class=\"nav-links\">\r\n");
      out.write("       <li class=\"nav-item\"><a href=\"http://localhost:8080/bookstore/logout\" action = \"post\">Sign out</a></li>\r\n");
      out.write("       <li class=\"nav-item\"><a href=\"http://localhost:8080/bookstore/shoppingcartlist\">Cart</a></li>\r\n");
      out.write("\r\n");
      out.write(" </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<main class=\"cards\">\r\n");
      out.write("\r\n");
 for(Product element: (java.util.ArrayList<Product>)request.getAttribute("list")){ 
      out.write("\r\n");
      out.write("  <article class=\"card\">\r\n");
      out.write("    <img src=\"resources/img/");
      out.print(element.getISBN());
      out.write(".jpg\" alt=\"Sample photo\">\r\n");
      out.write("    <div class=\"text\">\r\n");
      out.write("      <h3><a href=\"http://localhost:8080/bookstore/productpage?isbn=");
      out.print(element.getISBN());
      out.write('"');
      out.write('>');
      out.print(element.getTitle());
      out.write("</a></h3>\r\n");
      out.write("      <p class=\"price\">$");
      out.print(element.getPrice());
      out.write("</p>\r\n");
      out.write("      <form action = \"addtocart\" method = \"post\">\r\n");
      out.write("      <input type = \"hidden\" name = \"isbn\" value = \"");
      out.print(element.getISBN());
      out.write("\">\r\n");
      out.write("      <button type = \"submit\">Add to cart</button>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </article>\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("  </main>\r\n");
      out.write("\r\n");
      out.write("  </html>");
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