package GestionReservations;
import java.util.Date;

public class TempsDeSeance {
	private String jour;
	private String heureDeb;
	private String heureFin;
	private int creaneau;
	
	
	
	public TempsDeSeance(String jour, String heureDeb, String heureFin, int creaneau) {
		super();
		this.jour = jour;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.creaneau = creaneau;
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
