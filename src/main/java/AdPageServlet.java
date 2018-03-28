import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdPageServlet", urlPatterns = "/ad-page")
public class AdPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adRequested = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("ad", DaoFactory.getAdsDao().single(adRequested));
        request.getRequestDispatcher("ad-page.jsp").forward(request, response);
    }
}
