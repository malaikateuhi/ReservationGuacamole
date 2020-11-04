
package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Seance;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Enseignant;
import GestionUtilisateurs.Etudiant;

public class EnseigantDao {
	
		public EnseigantDao() {}
		
		public Enseignant login(String id,String password) {
		    String sqlen = "select * from Enseigant where iden=? and passworden=? ";//faut corriger le password dans bd admin
		    Enseignant enres = null;
		    Query();
		    parameter.add(id);
		    parameter.add(password);
		    afferentSQL(sqlen);
		    List<Object> objs = Select();
		 
		    if (objs.size()!=0) { 
		    	Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
		    	  enres = new Enseignant();
		          enres.setIdentifiant((String) rowData.get("iden"));
		          enres.setMdp((String)rowData.get("passwoden"));
		          enres.setNom((String)rowData.get("nomen"));
		          enres.setPrenom((String)rowData.get("prenomen"));
		    	System.out.println("welcom "+rowData.get("nomen"));
		    	return enres;    	  
		    }
		    else {
		    return null;}
		    }
			
		//	Afficher les seances donnee par un enseignant
		ArrayList<Seance> lstseance;
		public ArrayList<Seance> donnecours(Enseignant enseigant)
		{
			String sql ="select * from donner where iden=?";
			Query(); 
			parameter.add(enseigant.getIdentifiant());
			afferentSQL(sql);
			this.lstseance = new ArrayList<Seance>();
			  List<Object> objs = Select();			  
		        for (int i = 0; i < objs.size(); i++) {
		        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
		        	Seance seance = new Seance();
	                seance.setNumSeance((String)rowData.get("numseance")); 
		            seance.setNomCours((String)rowData.get("nomcours"));
		            seance.setEtat((String)rowData.get("etats"));
	                lstseance.add(seance);
	                
	       }
		        System.out.println(lstseance);
			return lstseance;
		}
		
		//Voir tous les ¨¦tudiants de chaque seance
		ArrayList<Etudiant> lstetudiant;
		public ArrayList<Etudiant> groupetudiant (Seance seance)
		{
			String sql = "SELECT * FROM seance,etudiant Where seance.numgroup=etudiant.numgroup and numseance=? ";
			Query(); 
			parameter.add(seance.getNumSeance());
			afferentSQL(sql);
			this.lstetudiant = new ArrayList<Etudiant>();
			  List<Object> objs = Select();
			  
		        for (int i = 0; i < objs.size(); i++) {
		        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
		        	Etudiant etudiant = new Etudiant();
	                etudiant.setIdentifiant((String)rowData.get("id")); 
		            etudiant.setMdp((String)rowData.get("passworde"));
		            etudiant.setNom((String)rowData.get("nome"));
		            etudiant.setPrenom((String)rowData.get("prenome"));
	                lstetudiant.add(etudiant);
	       }
		        System.out.println(lstetudiant);
			return lstetudiant;
		}
		
		
		
	/*	ArrayList<Salle> lstsalle;
		public ArrayList<Salle>  (Seance seance)
		{
			String sql = "SELECT * FROM seance,etudiant Where seance.numgroup=etudiant.numgroup and numseance=? ";
			Query(); 
			parameter.add(seance.getNumSeance());
			afferentSQL(sql);
			this.lstetudiant = new ArrayList<Etudiant>();
			  List<Object> objs = Select();
			  
		        for (int i = 0; i < objs.size(); i++) {
		        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
		        	Etudiant etudiant = new Etudiant();
	                etudiant.setIdentifiant((String)rowData.get("id")); 
		            etudiant.setMdp((String)rowData.get("passworde"));
		            etudiant.setNom((String)rowData.get("nome"));
		            etudiant.setPrenom((String)rowData.get("prenome"));
	                lstetudiant.add(etudiant);
	       }
		        System.out.println(lstetudiant);
			     return lstetudiant;
		}
		
		 */ 
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EnseigantDao en1 = new EnseigantDao();	
			Enseignant enenget=en1.login("en1","en1");
			en1.donnecours(enenget);
			Seance s1 =new Seance();
			s1.setNumSeance("TP1");
			en1.groupetudiant(s1);
		}

}
