package GestionReservations;

import GestionUtilisateurs.Enseignant;
import GestionUtilisateurs.Groupe;

public class Seance {
	private String numSeance;
	private String nomCours;
	private String etat;

	public Seance(String numSeance) {
		 this.numSeance = numSeance;
	}
	public Seance() {
		// TODO Auto-generated constructor stub
	}
	public String getNumSeance() {
		return numSeance;
	}
	public void setNumSeance(String numSeance) {
		this.numSeance = numSeance;
	}
	public String getNomCours() {
		return nomCours;
	}
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}

	
//	private Groupe groupeEtu;
//	private Enseignant ensignant;
}
