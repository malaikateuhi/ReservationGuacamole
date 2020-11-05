package GestionSallesMachines;

import java.util.HashMap;

import GestionReservations.Reservation;
import GestionUtilisateurs.Etudiant;

public class Machine {

	private String numMachine;
	private Salle salle;	
	private HashMap<Reservation, Etudiant> hmReser;
	
	public Machine() {}

	public Machine(String numM) {
		this.numMachine = numM;
	}
	
	public Machine(String numM,Salle salle) {
		this(numM);
		this.salle = salle;
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

	public HashMap<Reservation, Etudiant> getHmReser() {
		return hmReser;
	}
	public void setHmReser(HashMap<Reservation, Etudiant> hmReser) {
		this.hmReser = hmReser;
	}
	
	
}
