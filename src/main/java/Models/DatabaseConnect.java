package Models;


import java.sql.*;
import java.io.*;
import java.util.*;

public class DatabaseConnect {
    final private String querypath = "src/main/java/models/queries.csv";

    private static DatabaseConnect con = null;

    public static DatabaseConnect Connect (){
        if (con==null) {
        con = new DatabaseConnect();
        }
        return con;
    }
    public LinkedList<String[]> select(String query, String db, String ip, String port, String user, String password){
        LinkedList<String[]> queryReturn = new LinkedList<String[]>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            //add header row to queryReturn
            String[] headerRow = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headerRow[i-1] = md.getColumnName(i);
            }
            queryReturn.add(headerRow);

            //add data row to queryReturn
            while (rs.next()){
                String[] dataRow = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    dataRow[i-1] = rs.getString(i);
                }
                queryReturn.add(dataRow);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return queryReturn;
    }
    public LinkedList<String[]> selectQuery(String queryName) throws NullPointerException{
        try(BufferedReader br = new BufferedReader(new FileReader(querypath))) {
            String query = br.readLine();
            String[] line = null;
            while (query != null){
                line = query.split(",");
                if(line[1].equals(queryName)){
                    return select(line[2], line[3], line[4], line[5], line[6], line[7]);
                }
                query = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}