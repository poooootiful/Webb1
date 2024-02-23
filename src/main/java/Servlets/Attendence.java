package Servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/Attendance")
public class Attendence extends HttpServlet{

    int StudentId = 0;
    int CourseId = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int id = 1;

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Attendance</title></head>");
        out.println("<body>");
        out.println("<h2>Attendance</h2>");
        out.println("<ul>\n" +
                "        <li style=\"display:inline\"><a href=\"/Home\"></a>Home</li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Students\">Students</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Courses\">Courses</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Attendance\">Attendance</a></li>\n" +
                "    </ul>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>StudentId</th>\n" +
                "    <th>CourseId</th>\n" +
                "  </tr>\n" );

        for (int i = 0; i<5; i++) {
            out.println("  <tr>\n" +
                    "    <td>"+id+"</td>\n" +
                    "    <td>"+StudentId+"</td>\n" +
                    "    <td>"+CourseId+"</td>\n" +
                    "  </tr>\n");
            id++;
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
