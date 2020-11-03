package GestionReservations;
import java.util.Date;


public class Reservation {
	private Date jour;
	private Date heureDeb;
	private Date heureFin;
	private EtatReservation etat;
	
	//private int duree; //en heure
	public Reservation(Date jour, Date heureDeb, Date heureFin, EtatReservation etat) {
		super();
		this.jour = jour;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.etat = etat;
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
	public EtatReservation getEtat() {
		return etat;
	}
	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}

}
