package BD;

import java.sql.*;
public class BDutile {
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:8081/bd?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt=conn.createStatement();
            String sql;
            sql="SELECT * FROM stu";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                int id=rs.getInt("sid");
                String name=rs.getString("name");
                System.out.print("ID: " + id);
                System.out.print("name: " + name);
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se1) {
                se1.printStackTrace();
            }
        }
    }
}
 