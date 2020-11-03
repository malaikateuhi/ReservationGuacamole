package GestionUtilisateurs;

import java.util.ArrayList;

import GestionReservations.Seance;

public class Enseignant extends Utilisateur {
	
	private ArrayList<Seance> seances;
	
	public Enseignant(String identifiant, String mdp, String nom, String prenom) {
		super(identifiant, mdp, nom, prenom);
	}
	
	public void annulerSeance() {
		
	}
}
