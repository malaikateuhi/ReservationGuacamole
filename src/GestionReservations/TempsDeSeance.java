package GestionReservations;
import java.util.Date;
import java.util.HashMap;

import GestionSallesMachines.Salle;

public class TempsDeSeance {
	private String jour;
	private String heureDeb;
	private String heureFin;
	private HashMap<Seance,Salle> hmSeanceSalle = new HashMap();
	private int creneau;
	
	public int getCreneau() {
		return creneau;
	}

	public void setCreneau(int creneau) {
		this.creneau = creneau;
	}

	public TempsDeSeance() {
		
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}


	public TempsDeSeance(String jour, String heureDeb, String heureFin, HashMap<Seance, Salle> hm,
			int creneau) {
		super();
		this.jour = jour;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.hmSeanceSalle = hm;
		this.creneau = creneau;
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

	public HashMap<Seance, Salle> getHmSeanceSalle() {
		return hmSeanceSalle;
	}

	public void setHmSeanceSalle(HashMap<Seance, Salle> hmSeanceSalle) {
		this.hmSeanceSalle = hmSeanceSalle;
	}


	



}
