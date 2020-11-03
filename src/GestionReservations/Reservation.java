package GestionReservations;
import java.util.Date;

public class Reservation {
	protected String numma;
	protected String idee;
	protected String jour;
	protected String heureDeb;
	protected String heureFin;
	protected String etat;
	//private int duree; //en heure
	
	public Reservation() {
	}

	
	
	public String getNumma() {
		return numma;
	}



	public void setNumma(String numma) {
		this.numma = numma;
	}



	public String getIdee() {
		return idee;
	}



	public void setIdee(String idee) {
		this.idee = idee;
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

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
