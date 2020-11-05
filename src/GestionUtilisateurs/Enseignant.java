package GestionUtilisateurs;

import java.util.ArrayList;

import GestionReservations.Seance;

public class Enseignant extends Utilisateur {

	private ArrayList<Seance> seances;


	public Enseignant() {	
	}
	
	public Enseignant(String id, String mdp) {
		super(id,mdp);
	}
	
	public String getIdentifiant() {
		return super.getIdentifiant();
	}
	
	public Enseignant(String identifiant, String mdp, String nom, String prenom) {
		super(identifiant, mdp, nom, prenom);
	}
	public Enseignant(String id) {
		super(id);
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
		
	
	public void annulerSeance() {	
	}
}
