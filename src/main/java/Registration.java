import model.Product;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "registration", value = "/registration")
public class Registration extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{


        doPost(req,res);

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {



        String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "Admin";

        try {
            String query = " insert into bookstore.customer (name, address, phone, email)"
                    + " values (?, ?, ?, ?)";
            String query1 = "insert into bookstore.shopping_basket (basket_id)" + " values (?)";

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    url, username, password);
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, req.getParameter("name"));
            preparedStmt.setString(2, req.getParameter("address"));
            preparedStmt.setString(3, req.getParameter("phone"));
            preparedStmt.setString(4, req.getParameter("email"));
            preparedStmt.execute();
            PreparedStatement preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setString(1,req.getParameter("email"));
            preparedStatement1.execute();



            con.close();

        }
        catch (Exception e){
            e.printStackTrace();
            res.sendRedirect("register.jsp");
            return;

        }
res.sendRedirect("login.jsp");

    }


}
