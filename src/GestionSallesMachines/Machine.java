package GestionSallesMachines;

import java.util.HashMap;

import GestionReservations.Reservation;
import GestionUtilisateurs.Etudiant;

public class Machine {
	private String numMachine;
	private EtatMachineSalle etat;
	
	private HashMap<Etudiant,Reservation> hmReser;
	
}
