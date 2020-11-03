package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
import GestionSallesMachines.Machine;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Etudiant;


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
	
	ArrayList<Machine> lstMachine;
	ArrayList<Etudiant> lstEtudiant;
	public ArrayList<Machine> tousmachine ()
	{
		String sqlreserver = "select * from machine";
		Query(); 
		afferentSQL(sqlreserver);
		this.lstMachine= new ArrayList<Machine>();
		  List<Object> objs = Select();
	        for (int i = 0; i < objs.size(); i++) {
	        	Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
	        	Machine machine= new Machine();
	        	machine.setNumMachine((String)rowData.get("jour"));
	        	machine.setEtat((String)rowData.get("etatr"));
	            lstMachine.add(machine);
	        }
		return lstMachine;
	}

	
	
	public ArrayList<Etudiant> tousetudiant (){
		String sqlreserver = "select * from etudiant";
		Query(); 
		afferentSQL(sqlreserver);
		this.lstEtudiant= new ArrayList<Etudiant>();
		  List<Object> objs = Select();
	        for (int i = 0; i < objs.size(); i++) {
	        	Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
	        	Etudiant etudiant= new Etudiant();
	        	etudiant.setIdentifiant((String)rowData.get("ide"));
	        	etudiant.setMdp((String)rowData.get("passworde"));
	        	etudiant.setNom((String)rowData.get("nome"));
	        	etudiant.setPrenom((String)rowData.get("prenome"));
	            lstEtudiant.add(etudiant);
	        }
		return lstEtudiant;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao a1 = new AdminDao();	
		a1.login("1","2");
	}

	
}
