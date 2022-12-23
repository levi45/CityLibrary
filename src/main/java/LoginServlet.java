import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.CustomerDao;
import model.Customer;
import java.io.IOException;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("Email");
        String pwd = request.getParameter("pwd");
        CustomerDao cusdao = new CustomerDao();
        Customer cus = cusdao.getCustomer(email);
        if(cus == null) {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else {

            if (cus.getEmail().equals(email)) {
                Cookie loginCookie = new Cookie("user", cus.getEmail());
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.sendRedirect("productpage");
            } else {
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        }
    }

}