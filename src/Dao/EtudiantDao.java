package Dao;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.List;
import java.util.Map;

import GestionUtilisateurs.Etudiant;


public class EtudiantDao {
public EtudiantDao() {}
public Etudiant login(String id,String password) {

    String sqlclient = "select * from etudiant where ide=? and passworde=? ";
    Etudiant etures = null;
    
    Query();
    
    parameter.add(id);
    parameter.add(password);
    afferentSQL(sqlclient);
    
    
    List<Object> objs = Select();
    System.out.println(objs.get(0));
    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
  
    if (objs.size()!=0) {
    	/*
    	  etures = new Etudiant();
          etures.setNume((String) rowData.get("ide"));
          etures.setPassword((String)rowData.get("passwode"));
          etures.setNom((String)rowData.get("nome"));
          etures.setPrenom((String)rowData.get("prenome"));
         */ 
    	System.out.println("welcom "+rowData.get("nome"));
    	return etures;
    	  
    }
    else {
    return null;}
    }

  

public static void main(String[] args) {
	// TODO Auto-generated method stub
	EtudiantDao t1 = new EtudiantDao();	
	t1.login("a","b");
}

}
