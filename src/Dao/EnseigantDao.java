
package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
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
		
		
		//Voir les salles de classe occup¨¦es par la s¨¦ance
	    ArrayList<Salle> lstsalle;
		public ArrayList<Salle> salleoccupe(Seance seance)
		{
				String sql = "select * from passer where numseance = ?";
				Query(); 
				parameter.add(seance.getNumSeance());
				afferentSQL(sql);
				this.lstsalle = new ArrayList<Salle>();
				List<Object> objs = Select();
				  
			        for (int i = 0; i < objs.size(); i++) {
			        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			        	Salle salle = new Salle();
			        	salle.setNomSalle((String)rowData.get("numsalle")); 
			        	if (lstsalle.contains(salle)==false) {
		                lstsalle.add(salle);}
	       }
		        System.out.println(lstsalle);
			     return lstsalle;
		}
		
		
		//Quelles machines sont r¨¦serv¨¦es pour le jour de seance dans le salle et le seance indique
		ArrayList<Reservation> lstreservation1;
		public ArrayList<Reservation> machineReserver(Salle salle){
			String sql ="select * from reserver,machine,salle,passer "
					+ "where reserver.numma = machine.numma and machine.numsalle =salle.numsalle "
					+ "and salle.numsalle = passer.numsalle and passer.jour=reserver.jour "
					+ "and passer.creneau=reserver.creneau and salle.numsalle = ?";
			Query(); 
			 parameter.add(salle.getNomSalle());
	    	 afferentSQL(sql);
	    	 this.lstreservation1=new  ArrayList<Reservation>();
	    	  List<Object> objs = Select();
		        for (int i = 0; i < objs.size(); i++) {
		        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
		        	Reservation rr= new Reservation();
		        	rr.setNumma((String)rowData.get("numma"));
		        	rr.setCreaneau((int)rowData.get("creneau"));
		        	rr.setHeureDeb((String)rowData.get("heuredeb"));
		        	rr.setHeureFin((String)rowData.get("heurefinr"));
		        	rr.setEtat((String)rowData.get("etatr"));
		        	rr.setIdee((String)rowData.get("ide"));
		        	rr.setJour((String)rowData.get("jour"));
		        	lstreservation1.add(rr);
		        }
		        System.out.println(lstreservation1);
		        return lstreservation1;
	     }
			
			
			
			
			
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EnseigantDao en1 = new EnseigantDao();	
			Enseignant enenget=en1.login("en1","en1");
			en1.donnecours(enenget);
			Seance s1 =new Seance();
			s1.setNumSeance("TP1");
			en1.groupetudiant(s1);
		    en1.salleoccupe(s1);
		    Salle sa1 =new Salle();
		    sa1.setNomSalle("M1");
		    en1.machineReserver(sa1);
		}

}
