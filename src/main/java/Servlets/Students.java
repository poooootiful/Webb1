package Servlets;

import Models.DatabaseConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@WebServlet(urlPatterns = "/Students")
public class Students extends HttpServlet {

    String Firstname = null;
    String Lastname = null;
    String Origin = null;
    String Hobby = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int id = 1;

        out.println("<html>");
        out.println("<head><title>Students</title></head>");
        out.println("<body>");
        out.println("<h2>Students</h2>");
        out.println("<ul>\n" +
                "        <li style=\"display:inline\"><a href=\"/Home\"></a>Home</li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Students\">Students</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Courses\">Courses</a></li>\n" +
                "        <li style=\"display:inline\"><a href=\"/Attendance\">Attendance</a></li>\n" +
                "    </ul>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>First Name</th>\n" +
                "    <th>Last Name</th>\n" +
                "    <th>Origin</th>\n" +
                "    <th>Hobby</th>\n" +
                "  </tr>\n");

        LinkedList<String[]> queryReturn = DatabaseConnect.Connect().selectQuery("Getstudents");

        System.out.println(queryReturn);


        /*for (int i = 0; i<5; i++) {
            out.println("  <tr>\n" +
                    "    <td>"+id+"</td>\n" +
                    "    <td>"+Firstname+"</td>\n" +
                    "    <td>"+Lastname+"</td>\n" +
                    "    <td>"+Origin+"</td>\n" +
                    "    <td>"+Hobby+"</td>\n" +
                    "  </tr>\n");
            id++;
        }*/

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}