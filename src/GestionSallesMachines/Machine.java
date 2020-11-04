package GestionSallesMachines;

import java.util.HashMap;

import GestionReservations.Reservation;
import GestionUtilisateurs.Etudiant;

public class Machine {
	private String numMachine;
	private String etat;
	private Salle salle;
	
	private HashMap<Etudiant,Reservation> hmReser;
	
	public Machine() {
	
	}

	public Machine(String numM) {
		this.numMachine = numM;
	}
	public Machine(String numM,Salle salle) {
		this(numM);
		this.salle = salle;
	}
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public String getNumMachine() {
		return numMachine;
	}
	public void setNumMachine(String numMachine) {
		this.numMachine = numMachine;
	}

	public HashMap<Etudiant, Reservation> getHmReser() {
		return hmReser;
	}
	public void setHmReser(HashMap<Etudiant, Reservation> hmReser) {
		this.hmReser = hmReser;
	}
	
	
}
