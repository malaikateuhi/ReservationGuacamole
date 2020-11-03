package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;
import java.util.List;
import java.util.Map;

import GestionUtilisateurs.Admin;


public class AdminDao {
	public AdminDao() {}
	public Admin login(String id,String password) {

	    String sqladmin = "select * from admin where ida=? and passworda=? ";//faut coorriger le password dans bd admin
	    Admin ares = null;
	    Query();
	    
	    parameter.add(id);
	    parameter.add(password);
	    afferentSQL(sqladmin);
	    
	    
	    List<Object> objs = Select();
	    System.out.println(objs.get(0));
	    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
	  
	    if (objs.size()!=0) {
	    	/*
	    	  ares = new Admin();
	          ares.setNuma((String) rowData.get("ida"));
	          ares.setPassword((String)rowData.get("passwoda"));
	          ares.setNom((String)rowData.get("noma"));
	          ares.setPrenom((String)rowData.get("prenoma"));
	         */ 
	    	System.out.println("welcom "+rowData.get("noma"));
	    	return ares;
	    	  
	    }
	    else {
	    return null;}
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao a1 = new AdminDao();	
		a1.login("1","2");
	}

	
}
