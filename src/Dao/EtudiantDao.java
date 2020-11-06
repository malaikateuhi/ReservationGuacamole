package Dao;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
import GestionReservations.Seance;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Etudiant;


public class EtudiantDao {
	public EtudiantDao() {}

	/**
	 * Authentification d'une etudiant
	 */
	public Etudiant login(String id,String password) {

		String sqlclient = "select * from etudiant where ide=? and passworde=? ";
		Etudiant etures = null;

		Query();   
		parameter.add(id);
		parameter.add(password);
		afferentSQL(sqlclient);

		List<Object> objs = Select();

		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			etures = new Etudiant();
			etures.setIdentifiant((String) rowData.get("ide"));
			etures.setMdp((String)rowData.get("passwode"));
			etures.setNom((String)rowData.get("nome"));
			etures.setPrenom((String)rowData.get("prenome"));   
			System.out.println("welcom "+rowData.get("nome"));
			return etures;    	  
		}
		else {

			System.out.println("erreur");
			return null;
		}
	}


	/**
	 *  Si l'锟斤拷l锟斤拷ve a une classe, recommander une machine 
	 *  S'il y a une seance dans la p锟斤拷riode sp锟斤拷cifi锟斤拷e, v锟斤拷rifiez la salle o锟斤拷 le cours a eu lieu
	 * @return
	 */
	public Salle recommande(Etudiant etudiant, String jour,int time) {
		String avoircours ="select * from passer,etudiant,seance where etudiant.numgroup =seance.numgroup "
				+ "and seance.numseance =passer.numseance and ide=? and jour=? and creneau=? and etats<>'Annulle'";
		Query(); 
		parameter.add(etudiant.getIdentifiant());
		parameter.add(jour);
		parameter.add(time);
		afferentSQL(avoircours);
		List<Object> objs = Select();
		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			Salle salle = new Salle();
			salle.setNomSalle((String)rowData.get("numsalle"));   
			System.out.println(salle.getNomSalle());
			Seance seance =new Seance();

			return salle;
		}
		else 
		{return null;}
	}

	/**
	 * Verifier si un etudiant a une seance prevue aux jour et creneau donnes 
	 * @param time nombre de creneaux de la seance
	 * @return
	 */
	public Seance avoirseance(Etudiant etudiant, String jour,int time) {
		String avoircours ="select * from passer,etudiant,seance where etudiant.numgroup =seance.numgroup and seance.numseance =passer.numseance and ide=? and jour=? and creneau=? ";
		Query(); 
		parameter.add(etudiant.getIdentifiant());
		parameter.add(jour);
		parameter.add(time);
		afferentSQL(avoircours);
		List<Object> objs = Select();
		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			Seance seance =new Seance();
			seance.setNumSeance((String)rowData.get("numseance"));
			seance.setNomCours((String)rowData.get("nomcours"));
			System.out.println(seance.getNumSeance());
			return seance;
		}
		else 
		{return null;}
	}



	/**
	 * Recommander une machine disponible dans la salle ou a lieu une seance				
	 * @param salle salle de la seance
	 * @param jour date de la seance
	 * @param time nombre de creneaux de la seance
	 * @return
	 */
	public Machine machinelibre (Salle salle,String jour,int time)
	{
		String sqlmachine = "select * from machine where numsalle=? "
				+ "and numma not in (select numma from reserver where jour=? and creneau=?)";
		Query(); 
		parameter.add(salle.getNomSalle());
		parameter.add(jour);
		parameter.add(time);
		afferentSQL(sqlmachine);
		List<Object> objs = Select();
		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>) objs.get(0);
			Machine machine = new Machine();
			machine.setNumMachine((String)rowData.get("numma")); 
			//machine.setEtat((String)rowData.get("etatm"));
			System.out.println(machine.getNumMachine());
			return machine;
		}
		return null;
	}

	  /**
	 * Recommander une machine pour une reservation en acces libre (hors seance de TP)	
	 * @param jour date de la seance
	 * @param time nombre de creneaux de la seance
	 */
	public Machine choisi(Etudiant etudiant,String jour,int time) {
		// Si l'etudiant n'a pas de seance pendant le creneau ou il veut ,
		// alors recommander une machine qui n'est pas occupee pendant cette periode, 
		// et cette machine n'est pas dans la classe qui a des cours pendant cette periode
		String pascours ="select * from machine "
				+ "where machine.numma not in(select numma from reserver where ide=? and jour=?and creneau=?) "
				+ "and numsalle not in (select numsalle from passer where jour=?and creneau=? and etats<>'Annulle')";
		Query(); 
		parameter.add(etudiant.getIdentifiant());
		parameter.add(jour);
		parameter.add(time);
		parameter.add(jour);
		parameter.add(time);
		afferentSQL(pascours);
		List<Object> objs = Select();
		System.out.println(objs.get(0));
		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			Machine machine = new Machine();
			machine.setNumMachine((String)rowData.get("numma")); 
			machine.setSalle(new Salle((String)rowData.get("numsalle")));
			return machine;
		}
		else {return null;}
	}

	/**
	 * Enregistrer une reservation en BD
	 * @return true si l'enregistrement a bien ete effectue, false sinon
	 */
	public boolean prendreReservation(Reservation reservation) {
		String sql="insert into reserver values(?,?,?,?,?,?,?)";
		Query();
		afferentSQL(sql);
		parameter.add(reservation.getMachine().getNumMachine());
		parameter.add(reservation.getIdee());
		parameter.add(reservation.getJour());
		parameter.add(reservation.getHeureDeb());
		parameter.add(reservation.getHeureFin());
		parameter.add(reservation.getEtat());
		parameter.add(reservation.getCreaneau());
		int ligne=Update();
		if(ligne>=1){ //nombre de lignes affect锟絜s (c'est-锟�-dire le nombre de mises 锟� jour
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Liste des reservations de machines d'un etudiant
	 * @return ArrayList d'objets de type Reservation
	 */
	public  ArrayList<Reservation> infoReserver(Etudiant etudiant) {
		ArrayList<Reservation> lstreservation = new  ArrayList();

		String sql="select * from reserver,machine where machine.numma = reserver.numma and ide=? order by jour,creneau";
		Query();
		parameter.add(etudiant.getIdentifiant());
		afferentSQL(sql);

		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			Reservation rr= new Reservation();
			Salle sa = new Salle((String)rowData.get("numsalle"));
			Machine ma = new Machine((String)rowData.get("numma"),sa);
			rr.setMachine(ma);
			//rr.setMachine(new Machine((String)rowData.get("numma"),new Salle((String)rowData.get("numsalle"))));
			rr.setCreaneau((int)rowData.get("creneau"));
			rr.setHeureDeb((String)rowData.get("heuredebr"));
			rr.setHeureFin((String)rowData.get("heurefinr"));
			rr.setEtat((String)rowData.get("etatr"));
			rr.setIdee((String)rowData.get("ide"));
			rr.setJour((String)rowData.get("jour"));
			lstreservation.add(rr);
		}
		System.out.println(lstreservation);
		return lstreservation;
	}
	
	/**
	 * Suppression d'une reservation
	 * @return true si la reservation est supprimee, false sinon
	 */
	public boolean annulerReservation(Reservation reservation) {
		String sql="DELETE FROM reserver WHERE numma= ? AND ide = ? AND jour = ? AND creneau= ?";
		Query();
		afferentSQL(sql);
		parameter.add(reservation.getMachine().getNumMachine());
		parameter.add(reservation.getIdee());
		parameter.add(reservation.getJour());
		parameter.add(reservation.getCreaneau());
		int ligne=Update();
		if(ligne>=1){ 
			return true;

		}else {
			return false;
		}
	}

	/** 
	 *  Mettre une reservation EN RECLAMATION
	 *  @return true si la reservation, false sinon
	 */
	public boolean signalerReservation(Reservation reservation) {
		String sql = "UPDATE reserver "
				+ "SET etatr = 'EN RECLAMATION' "
				+ "WHERE numma = ? "
				+ "AND ide = ? "
				+ "AND jour = ? "
				+ "AND heuredebr = ? "
				+ "AND heurefinr = ?"
				+ "AND creneau = ?";	

		Query();
		parameter.add(reservation.getMachine().getNumMachine());
		parameter.add(reservation.getIdee());
		parameter.add(reservation.getJour());
		parameter.add(reservation.getHeureDeb());
		parameter.add(reservation.getHeureFin());
		parameter.add(reservation.getCreaneau());
		afferentSQL(sql);			
		int ligne=Update();
		return ligne >= 1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EtudiantDao t1 = new EtudiantDao();	
		Etudiant e1= new Etudiant();
		e1.setIdentifiant("1");
		//t1.login("a","b");
		Salle salle1=new Salle();
		salle1.setNomSalle("M1");
		//t1.machinelibre(salle1, "2020-11-10", 0);
		t1.recommande(e1, "2020-11-10", 0);

		t1.login("1","1");

		//t1.recommande(e1, "2020-11-10", 0);
		t1.avoirseance(e1, "2020-11-10", 0);				
		//t1.choisi(e1, "2020-11-10", 0);
		//Reservation r1= new Reservation("ma1","1","2020-11-10","9:30","10:30","reserve",0);

		//t1.annulerReservation(r1);
		//t1.prendreserver(r1);
		//t1.inforeserver(e1);
	}


}
