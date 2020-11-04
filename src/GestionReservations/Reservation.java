package GestionReservations;
import java.util.Date;

public class Reservation {
	 private String numma;
	 private String idee;
	 private String jour;
	 private String heureDeb;
	 private String heureFin;
	 private String etat;
	 private int creaneau;
	 //private int duree; //en heure
	 
	 
	 
	 public Reservation() {
	 }
	 
	 public Reservation(String numma, String idee, String jour, String heureDeb, String heureFin, String etat,int creaneau) {
	 
	  this.numma = numma;
	  this.idee = idee;
	  this.jour = jour;
	  this.heureDeb = heureDeb;
	  this.heureFin = heureFin;
	  this.etat = etat;
	  this.creaneau=creaneau;
	 }
	
	 
	 
	public int getCreaneau() {
	  return creaneau;
	 }
	
	
	
	 public void setCreaneau(int creaneau) {
	  this.creaneau = creaneau;
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
