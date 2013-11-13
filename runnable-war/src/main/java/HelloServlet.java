import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 13.11.13
 * Time: 14:03
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/"})
public class HelloServlet extends HttpServlet {


   public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

       try {
           httpServletResponse.getWriter().write("Hello from runnable war file");
       } catch (IOException e) {
           e.printStackTrace();

       }
   }
}
