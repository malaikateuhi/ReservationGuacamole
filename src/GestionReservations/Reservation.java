package GestionReservations;
import java.util.Date;

import GestionSallesMachines.Machine;
import GestionUtilisateurs.Etudiant;

public class Reservation {
	private Date jour;
	private Date heureDeb;
	private Date heureFin;
	private String etat;
	//private int duree; //en heure
	
	private Machine machine;
	private Etudiant etudiant;
}
