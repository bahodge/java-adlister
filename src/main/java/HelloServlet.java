import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


//THIS THE OLD WAY TO DO IT! You need a web.xml USE ANNOTATION INSTEAD

// Say Hello to name
// Increment Number of times viewed
public class HelloServlet extends HttpServlet {

    private int viewNum = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String reset = request.getParameter("reset");
        viewNum++;
        PrintWriter printWriter = response.getWriter();

//        Reset counter
        if (reset != null) {
            if (reset.equalsIgnoreCase("reset")) {
                viewNum = 0;
                printWriter.println("<h1>The Count has been reset</h1>");
            }
        } else if (username != null) {
            printWriter.println("<h1>Your name is " + username + "</h1>");
        } else {
            printWriter.println("<h1>Please login using the URL bar</h1>");
        }
        printWriter.println("<h2> This page has been viewed " + viewNum + "</h2>");
    }
}