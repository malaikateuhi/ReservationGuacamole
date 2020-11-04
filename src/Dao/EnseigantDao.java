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
import GestionReservations.TempsDeSeance;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Enseignant;
import GestionUtilisateurs.Etudiant;

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
		    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
		    if (objs.size()!=0) {
		    	/*
		    	  enres = new Enseignant();
		          enres.setNuma((String) rowData.get("iden"));
		          enres.setPassword((String)rowData.get("passwoden"));
		          enres.setNom((String)rowData.get("nomen"));
		          enres.setPrenom((String)rowData.get("prenomen"));
		         */ 
		    	System.out.println("welcom "+rowData.get("nomE"));
		    	return enres;    	  
		    }
		    else {
		    return null;}
		    }
			
		
		ArrayList<Seance> lstseance;
		public ArrayList<Seance> machinelibre(Enseignant enseigant)
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
			return lstseance;
		}
		
		
		ArrayList<Etudiant> lstetudiant;
		public ArrayList<Etudiant> groupetudiant (Seance seance)
		{
			String sql = "SELECT * FROM seance,etudiant Where seance.numgroup=etudiant.numgroup and numseance=? ";
			Query(); 
			parameter.add(seance.getNumSeance());
			afferentSQL(sql);
			this.lstseance = new ArrayList<Seance>();
			  List<Object> objs = Select();
			  
		        for (int i = 0; i < objs.size(); i++) {
		        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
		        	Etudiant etudiant = new Etudiant();
	                etudiant.setIdentifiant((String)rowData.get("id")); 
		            etudiant.setMdp((String)rowData.get("passworde"));
		            etudiant.setNom((String)rowData.get("nome"));
		            etudiant.setPrenom((String)rowData.get("prenome"));
	                lstseance.add(seance);
	       }
			return lstetudiant;
		}
		
		/**
		 * Recupere toutes les reservations de machines pour un creneau donne une seance
		 * @return ArrayList<Reservation>
		 */
		public ArrayList<Reservation> reservationsSeance(Seance seance, TempsDeSeance tpSeance) {
			ArrayList<Reservation> reservations = new ArrayList<Reservation>();
			
			String sql = "SELECT r.* FROM reserver r, machine m, passer p "
					+ "WHERE r.numma = m.numma AND m.numsalle = p.numsalle "
					+ "AND r.jour = p.jour AND r.heuredebr = p.heuredeb "
					+ "AND p.numseance=? "
					+ "AND p.jour = ? "
					+ "AND p.heuredeb = ?";
			Query(); 
			parameter.add(seance.getNumSeance());
			parameter.add(tpSeance.getJour());
			parameter.add(tpSeance.getHeureDeb());
			afferentSQL(sql);

			List<Object> objs = Select();

			for (int i = 0; i < objs.size(); i++) {
				Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
				Reservation res = new Reservation();
				res.setJour((String)rowData.get("jour")); 
				res.setHeureDeb((String)rowData.get("heuredebr"));
				res.setHeureFin((String)rowData.get("heurefinr"));
				reservations.add(res);
			}

			return reservations;
		}
		
		
		
		
		  
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EnseigantDao en1 = new EnseigantDao();	
			en1.login("22","00");
		}

}
