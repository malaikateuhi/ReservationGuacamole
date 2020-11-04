package GestionReservations;
import java.util.Date;

import GestionSallesMachines.Machine;

public class Reservation {
	 private Machine machine;
	 private String idee;
	 private String jour;
	 private String heureDeb;
	 private String heureFin;
	 private String etat;
	 private int creaneau;
	 //private int duree; //en heure
	 
	 
	 
	 public Reservation() {
	 }
	 
	 public Reservation(Machine numma, String idee, String jour, String heureDeb, String heureFin, String etat,int creaneau) {
	 
	  this.machine = numma;
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

	public Machine getMachine() {
		// TODO Auto-generated method stub
		return this.machine;
	}
	 public void setMachine(Machine ma) {
		 this.machine = ma;
	 }
 
}
