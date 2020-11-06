package GestionReservations;
import java.util.Date;
import java.util.HashMap;

import GestionSallesMachines.Salle;

public class TempsDeSeance {

	private String jour;
	private String heureDeb;
	private String heureFin;
	private int creaneau;
	private HashMap<Seance,Salle> hmSeanceSalle;
	
	public TempsDeSeance() {
		hmSeanceSalle = new HashMap<Seance,Salle>();
	}

	public TempsDeSeance(String jour, String heureDeb, String heureFin, int creaneau, HashMap<Seance, Salle> hmSeanceSalle) {
		this.jour = jour;
		this.heureDeb = heureDeb;		
		this.heureFin = heureFin;
		this.creaneau = creaneau;
		this.hmSeanceSalle = hmSeanceSalle;
	}


	public HashMap<Seance, Salle> getHmSeanceSalle() {
		return hmSeanceSalle;
	}

	public void setHmSeanceSalle(HashMap<Seance, Salle> hmSeanceSalle) {
		this.hmSeanceSalle = hmSeanceSalle;
	}
	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHeureDeb() {
		return heureDeb;
	}
	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public int getCreaneau() {
		return creaneau;
	}
	public void setCreaneau(int creaneau) {
		this.creaneau = creaneau;
	}

}
