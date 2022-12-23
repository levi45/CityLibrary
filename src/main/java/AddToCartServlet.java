import Dao.ShoppingCartDao;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "addtocart",value = "/addtocart")
public class AddToCartServlet extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int quantity = 1;
            String basket_id = null;
            Cookie[] cookies = req.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("user")) basket_id = cookie.getValue();
                }
            }

            if(req.getParameter("quantity") != null)
                quantity = Integer.parseInt(req.getParameter("quantity"));

            ShoppingCartDao shpd = new ShoppingCartDao();
            shpd.updateCart(Integer.parseInt(req.getParameter("isbn")),basket_id,quantity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        res.sendRedirect("productpage");
    }
}
