package GestionUtilisateurs;

import java.util.ArrayList;

import GestionReservations.Reservation;
import GestionReservations.Seance;

public class Etudiant extends Utilisateur {

	private ArrayList<Seance> lstSeanceEtu;
	private ArrayList<Reservation> lstReser;

	public Etudiant() {

	}
	public Etudiant(String id) {
		super(id);
	}
	
	public Etudiant(String id, String mdp) {
		super(id,mdp);
	}
	
	public Etudiant(String identifiant, String mdp, String nom, String prenom) {
		super(identifiant, mdp, nom, prenom);
	}

	public ArrayList<Seance> getLstSeanceEtu() {
		return lstSeanceEtu;
	}

	public void setLstSeanceEtu(ArrayList<Seance> lstSeanceEtu) {
		this.lstSeanceEtu = lstSeanceEtu;
	}

	public ArrayList<Reservation> getLstReser() {
		return lstReser;
	}

	public void setLstReser(ArrayList<Reservation> lstReser) {
		this.lstReser = lstReser;
	}

	public String getIdentifiant() {
		return super.getIdentifiant();
	}
	public void setIdentifiant(String identifiant) {
		super.setIdentifiant(identifiant);
	}
	public String getMdp() {
		return super.getMdp();
	}
	public void setMdp(String mdp) {
		super.setMdp(mdp);
	}
	public String getNom() {
		return super.getNom();
	}
	public void setNom(String nom) {
		super.setNom(nom);
	}
	public String getPrenom() {
		return super.getPrenom();
	}
	public void setPrenom(String prenom) {
		super.setPrenom(prenom);
	}

	public void reserver() {

	}

	public void annulerReservation() {

	}
}



