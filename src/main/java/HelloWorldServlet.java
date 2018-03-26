import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//THIS IS A MUCH BETTER WAY TO DO IT! You don't need a web.xml
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/helloworld")
    public class HelloWorldServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
            res.setContentType("text/html");
            String username =req.getParameter("username");
            if (username == null){
                username = "world";
            }
            res.getWriter().print("<h1>Hello " + username + "</h1>");
        }
    }
