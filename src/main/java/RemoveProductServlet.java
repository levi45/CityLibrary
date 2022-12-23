import Dao.ShoppingCartDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "removefromcart",value = "/removefromcart")
public class RemoveProductServlet extends HttpServlet {

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
            ShoppingCartDao scd = new ShoppingCartDao();
            scd.deleteFromCart(Integer.parseInt(req.getParameter("ISBN")),basket_id);
            res.sendRedirect("shoppingcartlist");
        }catch(Exception e){
            e.printStackTrace();


        }


    }
}