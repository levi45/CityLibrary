import Dao.ShoppingCartDao;
import model.Contains;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "shoppingcartlist",value = "/shoppingcartlist")
public class ShoppingCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res){

        doPost(req,res);


    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            int quantity = 1;
            String basket_id = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) basket_id = cookie.getValue();
                }
            }
            if(basket_id == null) {res.sendRedirect("login.jsp");}
            else {
                ShoppingCartDao scd = new ShoppingCartDao();
                ArrayList<Contains> contains_list = scd.fetchall(basket_id);
                req.setAttribute("containlist", contains_list);
                req.getRequestDispatcher("/WEB-INF/jsp/cartdisplay.jsp").forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
