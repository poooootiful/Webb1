package Servlets;
import Models.DatabaseConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/Attendance")
public class Attendence extends HttpServlet{

    //The Sql line used to get info
    String AttendanceSql = "SELECT*FROM atendance";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Connect to database
        Connection con = DatabaseConnect.getConnection();

        //Make a veriable for printing out html
        PrintWriter out = response.getWriter();

        //Html
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
        out.println("<table style = \"border: 1px solid\">\n" +
                "  <tr>\n" +
                "    <th style = \"border: 1px solid\">Id</th>\n" +
                "    <th style = \"border: 1px solid\">StudentId</th>\n" +
                "    <th style = \"border: 1px solid\">CourseId</th>\n" +
                "  </tr>\n" );

        //Get info from database and put it in the table
        try {
            Statement statement = con.createStatement();

            ResultSet result = statement.executeQuery(AttendanceSql);

            while(result.next()) {
                out.println(("  <tr>\n" +
                        "    <td style = \"border: 1px solid\">"+result.getInt("id")+"</td>\n" +
                        "    <td style = \"border: 1px solid\">"+result.getInt("CourseID")+"</td>\n" +
                        "    <td style = \"border: 1px solid\">"+result.getInt("StudentID")+"</td>\n" +
                        "  </tr>\n"));
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        //Closing tags for html
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
