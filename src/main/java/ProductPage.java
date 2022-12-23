import model.Product;
import java.io.IOException;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "productpage",value = "/productpage")
public class ProductPage extends HttpServlet{



public void doPost(HttpServletRequest req, HttpServletResponse res){
        try {
                doGet(req, res);
        }catch(Exception e){
                e.printStackTrace();
        }
}


public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{

        String userName = null;
        Cookie[] cookies = req.getCookies();
        if(cookies !=null){
                for(Cookie cookie : cookies){
                        if(cookie.getName().equals("user")) userName = cookie.getValue();
                }
        }
        if(userName == null) {res.sendRedirect("login.jsp");}
        else {


                String url = "jdbc:mysql://localhost:3306/bookstore";
                String username = "root";
                String password = "Admin";


                if (req.getParameter("isbn") != null) {
                        String query
                                = "select * from book where ISBN = " + req.getParameter("isbn");
                        String query1 = "select stock.quantity FROM book inner join stock on book.ISBN = stock.ISBN where stock.ISBN = " + req.getParameter("isbn");
                        ResultSet book = null;
                        Product product = null;
                        int stock = -1;
                        try {
                                Class.forName(
                                        "com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection(
                                        url, username, password);
                                Statement stmt = con.createStatement();
                                book = stmt.executeQuery(query);
                                if (book.next()) {
                                        product = new Product(book.getInt("ISBN"), book.getString("title"), book.getInt("year"), book.getBigDecimal("price"), book.getString("publisher_name"),book.getString("author"));
                                }
                                 stmt = con.createStatement();
                                ResultSet quantity = stmt.executeQuery(query1);
                                if(quantity.next()){
                                        stock = quantity.getInt(1);
                                }
                                con.close();
                                req.setAttribute("book", product);
                                req.setAttribute("quantity",stock);
                                req.getRequestDispatcher("/WEB-INF/jsp/productdisplay.jsp").forward(req, res);
                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                } else {
                        ArrayList<Product> product_list = new ArrayList<>();
                        String query
                                = "select * from book";

                        if (req.getParameter("search") != null) {

                                query += " where title LIKE '%" + req.getParameter("search") + "%'";


                        }
                        if (req.getParameter("1") != null) {

                                query += " ORDER BY " + req.getParameter("sort");

                        }

                        ResultSet allproducts = null;
                        try {
                                Class.forName(
                                        "com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection(
                                        url, username, password);

                                Statement stmt = con.createStatement();
                                allproducts = stmt.executeQuery(query);
                                while (allproducts.next()) {
                                        product_list.add(new Product(allproducts.getInt("ISBN"), allproducts.getString("title"), allproducts.getInt("year"), allproducts.getBigDecimal("price"), allproducts.getString("publisher_name"),allproducts.getString("author")));
                                }
                                con.close();
                        } catch (SQLException e) {
                                System.out.println(e.toString());
                        } catch (Exception ex) {
                                System.out.println(ex.toString());
                        }

                        req.setAttribute("list", product_list);
                        req.getRequestDispatcher("/WEB-INF/jsp/productlist.jsp").forward(req, res);
                }
        }
        }



}