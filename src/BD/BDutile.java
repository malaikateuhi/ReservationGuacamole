package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDutile {
	private String bdurl="jdbc:mysql://127.0.0.1:3306/projet_guacamole_bd?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
	private String username="root";
	private String mdp="";
	private String jdbcname="com.mysql.cj.jdbc.Driver";
	//connection
	public Connection getCon()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("reussidriver");
	    Connection con=DriverManager.getConnection(bdurl,username,mdp);
	    return con;
	}
	//close
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	//Test
	public static void main(String[] args) {
		BDutile bdutil=new BDutile();	
		try{
			bdutil.getCon();
	        System.out.println("connecxion reussie");
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	}
}

