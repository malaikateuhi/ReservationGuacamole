package GestionReservations;
import java.util.Date;
import java.util.HashMap;

import GestionSallesMachines.Salle;

public class TempsDeSeance {
	private Date jour;
	private Date heureDeb;
	private Date heureFin;
	
	public TempsDeSeance() {
		
	}
	public TempsDeSeance(Date jour, Date heureDeb, Date heureFin, HashMap<Seance, Salle> hmSeanceSalle) {
		super();
		this.jour = jour;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.hmSeanceSalle = hmSeanceSalle;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Date getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public HashMap<Seance, Salle> getHmSeanceSalle() {
		return hmSeanceSalle;
	}

	public void setHmSeanceSalle(HashMap<Seance, Salle> hmSeanceSalle) {
		this.hmSeanceSalle = hmSeanceSalle;
	}

	private HashMap<Seance,Salle> hmSeanceSalle;
}
