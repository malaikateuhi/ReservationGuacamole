package GestionSallesMachines;

import java.util.HashMap;

import GestionReservations.Reservation;
import GestionUtilisateurs.Etudiant;

public class Machine {
	private String numMachine;
	private EtatMachineSalle etat;
	
	private HashMap<Etudiant,Reservation> hmReser;
	
	public Machine() {
	
	}
	public Machine(String numMachine, EtatMachineSalle etat, HashMap<Etudiant, Reservation> hmReser) {
		super();
		this.numMachine = numMachine;
		this.etat = etat;
		this.hmReser = hmReser;
	}
	public String getNumMachine() {
		return numMachine;
	}
	public void setNumMachine(String numMachine) {
		this.numMachine = numMachine;
	}
	public EtatMachineSalle getEtat() {
		return etat;
	}
	public void setEtat(EtatMachineSalle etat) {
		this.etat = etat;
	}
	public HashMap<Etudiant, Reservation> getHmReser() {
		return hmReser;
	}
	public void setHmReser(HashMap<Etudiant, Reservation> hmReser) {
		this.hmReser = hmReser;
	}
	
	
}
