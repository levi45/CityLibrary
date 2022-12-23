import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logoutservlet",value = "/logout")
public class LogoutServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res){

        doPost(req, res);

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.setContentType("text/html");
            Cookie loginCookie = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        loginCookie = cookie;
                        break;
                    }
                }
            }
            if (loginCookie != null) {
                loginCookie.setMaxAge(0);
                res.addCookie(loginCookie);

            }

            res.sendRedirect("login.jsp");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
