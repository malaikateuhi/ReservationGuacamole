
package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.HashMap;
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

public class EnseignantDao {

	public EnseignantDao() {}

	/** 
	 * Authentification d'un enseignant
	 */
	public Enseignant login(String id,String password) {
		String sqlen = "select * from enseignant where iden=? and passworden=? ";

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
			return enres;    	  
		}
		else {
			return null;}
	}
	
	/**
	 * 	Afficher les seances donnees par un enseignant et le salle se trouve  
	 * @return ArrayList de un liste qui contient l'objet seance et l'objet salle 
	 */	
	public ArrayList<TempsDeSeance > donnerCours(Enseignant enseigant){
		  
		  ArrayList<TempsDeSeance> lstseance = new ArrayList<TempsDeSeance>();
		  String sql ="SELECT * from seance,passer where seance.numseance=passer.numseance and iden=?";
		  Query(); 
		  parameter.add(enseigant.getIdentifiant());
		  afferentSQL(sql);
		  List<Object> objs = Select();     
		  for (int i = 0; i < objs.size(); i++) {
			  HashMap<Seance,Salle> hmSeanceSalle = new HashMap<Seance, Salle>();
			  Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			  TempsDeSeance tps = new TempsDeSeance();
			   Salle sa = new Salle((String)rowData.get("numsalle"));
			   Seance se =new Seance((String)rowData.get("numseance"),(String)rowData.get("nomcours"));
			
			   hmSeanceSalle.put(se, sa);
			   tps.setHmSeanceSalle(hmSeanceSalle); 
			   tps.setJour((String)rowData.get("jour"));
			   tps.setCreneau((int)rowData.get("creneau"));
			   tps.setHeureDeb((String)rowData.get("heureDeb"));
			   tps.setHeureFin((String)rowData.get("heureFin"));
			   lstseance.add(tps);

		  }		  
		  return lstseance;
	}
	public boolean annulerSeance(Seance seance, TempsDeSeance tpSeance) {
		String sql = "delete from passer "
				+ "WHERE numseance = ? "
				+ "AND jour = ? AND creneau=? "
				+ "AND numsalle = ?";

		Query(); 
		parameter.add(seance.getNumSeance());
		parameter.add(tpSeance.getJour());
		parameter.add(tpSeance.getCreneau());
		parameter.add(tpSeance.getHmSeanceSalle().get(seance).getNomSalle());   
		afferentSQL(sql);   
		int ligne=Update();
		return ligne >= 1;
	}


	/**
	 * Liste des etudiants d'une seance (cours)
	 */
	ArrayList<Etudiant> lstetudiant;
	public ArrayList<Etudiant> groupeEtudiants (Seance seance)
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
		return lstetudiant;
	}


	/**
	 * Liste des salles occupees par une seance (cours)
	 */
	ArrayList<Salle> lstsalle;
	public ArrayList<Salle> sallesOccupees(Seance seance)
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
		return lstsalle;
	}

	/**
	 * Recuperer les machines reservees pour le jour de seance dans le salle et le seance indique
	 */
	ArrayList<Reservation> lstreservation1;
	public ArrayList<Reservation> machineReserver(Salle salle){
		String sql ="select * from reserver,machine,passer "
			    + "where reserver.numma = machine.numma "
			    + "and machine.numsalle = passer.numsalle and passer.jour=reserver.jour "
			    + "and passer.creneau=reserver.creneau and salle.numsalle = ?";

		Query(); 
		parameter.add(salle.getNomSalle());
		afferentSQL(sql);
		this.lstreservation1=new  ArrayList<Reservation>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			Reservation rr= new Reservation();
			rr.setMachine(new Machine((String)rowData.get("numma"), salle));
			rr.setCreaneau((int)rowData.get("creneau"));
			rr.setHeureDeb((String)rowData.get("heuredebr"));
			rr.setHeureFin((String)rowData.get("heurefinr"));
			rr.setEtat((String)rowData.get("etatr"));
			rr.setIdee((String)rowData.get("ide"));
			rr.setJour((String)rowData.get("jour"));
			lstreservation1.add(rr);
		}
		return lstreservation1;
	}
	

	/**
	 * Recuperer toutes les reservations de machines pour un creneau donne d'une seance
	 * @return ArrayList<Reservation>
	 */
	public ArrayList<Reservation> reservationsSeance(Seance seance, TempsDeSeance tpSeance) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();	
		String sql = "SELECT * FROM reserver r, machine m, passer p "
				+ "WHERE r.numma = m.numma AND m.numsalle = p.numsalle "
				+ "AND r.jour = p.jour AND r.heuredebr = p.heuredeb "
				+ "AND p.numseance = ? "
				+ "AND p.jour = ? "
				+ "AND p.heuredeb = ? "
				+ "AND p.heurefin = ?";
		Query(); 
		parameter.add(seance.getNumSeance());
		parameter.add(tpSeance.getJour());
		parameter.add(tpSeance.getHeureDeb());
		parameter.add(tpSeance.getHeureFin());
		afferentSQL(sql);
		List<Object> objs = Select();

		for (int i = 0; i < objs.size(); i++) {	// Recuperation de chaque reservation dans un objet Reservation
			Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			Salle s = new Salle((String)rowData.get("p.numsalle"));
        	Machine m = new Machine((String)rowData.get("numma"), s);
			Reservation res = new Reservation();
        	res.setMachine(m);
			res.setIdee((String)rowData.get("ide")); 
			res.setCreaneau((Integer)rowData.get("creneau")); 
			res.setJour((String)rowData.get("jour")); 
			res.setHeureDeb((String)rowData.get("heuredebr"));
			res.setHeureFin((String)rowData.get("heurefinr"));
			reservations.add(res);
		}

		return reservations;
	}
	
	/**
	 *  Mettre toutes les reservations pour une seance donnee a ANNULEE
	 *  @return true si toutes les reservations ont ete annulees, false sinon
	 */
	public boolean annulerReservations(Seance seance, TempsDeSeance tpSeance) {
		String sql = "UPDATE reserver "
				+ "SET etatr = 'ANNULEE' "
				+ "WHERE numma = ? "
				+ "AND ide = ? "
				+ "AND jour = ? "
				+ "AND heuredebr = ? "
				+ "AND heurefinr = ?";
		
		ArrayList<Reservation> reservations = reservationsSeance(seance, tpSeance);			
		int lignes = 0;
		
		for (Reservation reservation : reservations) {	// Changement d'etat de chaque reservation
			Query();
			parameter.add(reservation.getMachine().getNumMachine());
			parameter.add(reservation.getIdee());
			parameter.add(reservation.getJour());
			parameter.add(reservation.getHeureDeb());
			parameter.add(reservation.getHeureFin());
			afferentSQL(sql);
			lignes += Update();
		}			
		return lignes == reservations.size(); // nombre de lignes modifiees dans la table de la BD
	}

}
