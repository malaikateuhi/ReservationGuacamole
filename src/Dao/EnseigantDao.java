package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.List;
import java.util.Map;

import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Enseignant;

public class EnseigantDao {
	
		public EnseigantDao() {}
		public Enseignant login(String id,String password) {

		    String sqlen = "select * from Enseigant where iden=? and passworden=? ";//faut coorriger le password dans bd admin
		    Enseignant enres = null;
		    Query();
		    
		    parameter.add(id);
		    parameter.add(password);
		    afferentSQL(sqlen);
		    
		    
		    List<Object> objs = Select();
		    System.out.println(objs.get(0));
		    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
		  
		    if (objs.size()!=0) {
		    	/*
		    	  enres = new Enseignant();
		          enres.setNuma((String) rowData.get("iden"));
		          enres.setPassword((String)rowData.get("passwoden"));
		          enres.setNom((String)rowData.get("nomen"));
		          enres.setPrenom((String)rowData.get("prenomen"));
		         */ 
		    	System.out.println("welcom "+rowData.get("nomen"));
		    	return enres;
		    	  
		    }
		    else {
		    return null;}
		    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EnseigantDao en1 = new EnseigantDao();	
			en1.login("22","00");
		}

}
