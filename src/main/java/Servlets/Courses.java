package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/Courses")
public class Courses  extends HttpServlet {

    String Name = null;
    String Yhp = null;
    String Description = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int id = 1;

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Courses</title></head>");
        out.println("<body>");
        out.println("<h2>Courses</h2>");
        out.println("<ul>\n" +
                "        <li style=\"display:inline\"><a href=\"/Home\"></a>Home</li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Students\">Students</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Courses\">Courses</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Attendance\">Attendance</a></li>\n" +
                "    </ul>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Name</th>\n" +
                "    <th><YHP</th>\n" +
                "    <th><Description</th>\n" +
                "  </tr>\n") ;

        for (int i = 0; i<5; i++) {
            out.println("  <tr>\n" +
                    "    <td>"+id+"</td>\n" +
                    "    <td>"+Name+"</td>\n" +
                    "    <td>"+Yhp+"</td>\n" +
                    "    <td>"+Description+"</td>\n" +
                    "  </tr>\n");
            id++;
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}