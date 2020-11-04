package GestionReservations;

import GestionUtilisateurs.Enseignant;
import GestionUtilisateurs.Groupe;

public class Seance {
	private String numSeance;
	private String nomCours;
	private String etat;
	public void setNumSeance(String numS) {
		// TODO Auto-generated method stub
		this.numSeance = numS;
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
	public String getNumSeance() {
		return numSeance;
	}
	
//	private Groupe groupeEtu;
//	private Enseignant ensignant;
}
