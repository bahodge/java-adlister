import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessingServlet", urlPatterns = "/guessinggame")
public class GuessingServlet extends HttpServlet {
    private int computerNumber = (int) Math.floor(Math.random() * 100) + 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(computerNumber);
        String guessString = request.getParameter("guess");
        int guess = Integer.parseInt(guessString);


//        CHeck if it is the number!
        if (guess == computerNumber){
            request.setAttribute("answer", "You Guessed It");
        } else if (guess < computerNumber){
            request.setAttribute("answer", "Higher");
        } else if (guess > computerNumber){
            request.setAttribute("answer", "Lower");
        }

        request.setAttribute("cpuNum", computerNumber);
        request.getRequestDispatcher("guess-answer.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("hi-low.jsp").forward(request, response);
    }
}
